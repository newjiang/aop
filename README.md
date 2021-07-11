### 什么是AOP？
    AOP是一种编程范式，不是编程语言，为了解决特定的问题，而不是所有的问题的。
    初衷：
        为了解决代码重复，关注点分离的问题。
    使用AOP的好处：
        集中处理某一关注点/横切面逻辑
        可以很方便添加/删除关注点
    应用场景：
        权限控制，缓存控制，事务控制......
### 切面表达式
    pointcut expression - 切面表达式
    expression:
        designators(指示器)
            匹配方法： 
                execution()
            匹配注解：
                @target()
                @args()
                @within()
                @annotaion()
            匹配包/类型
                within()
            匹配对象    
                this()
                bean()
                target()
            匹配参数
                args()
        wildecards(通配符)
            *  （匹配任意数量的字符）
            +  （匹配制定数量的类及其子类）
            .. （一般用于匹配任意数量的子包或参数）
        operators(运算符)
            && （与）
            || （或）
            !  （非）
            
     Advice注解
     1.@Before          前置通知
     2.@After           后置通知，方法执行完后
     3.@AfterReturning  返回通知，成功执行后
     4.AfterThrowing    异常通知，抛出异常后
     5.@Around          环绕通知

### AOP原理
    AOP织入的时机
        1.编译期(Aspectj)
        2.类加载时(AspectJ 5+)
        3.运行时（Spring AOP）
    运行时织入是如何实现的呢？
        ——答案是代理实现。
    
    代理
        静态代理
        动态代理
            通过接口实现的代理
            通过继承实现的代理
    静态代理的缺点：
        代理越多，重复越多。
        
    动态代理：
        JDK代理：
            只能代理接口的
            通过java. lang.reflect.Proxy去动态生成代理类
            实现java.lang.reflect.InvocationHandler完成织入
        cglib代理：
            通过继承的方式实现代理类
            因为基于继承的方式实现代理，所以无法对static，final类进行代理       
            因为基于继承的方式实现代理，所以无法对static，private方法进行代理    
    Spring如何选择代理bean?
        如果目标对象实现了接口,则默认采用JDK动态代理
        如果目标对象没有实现接口,则采用Cglib进行动态代理
        如果目标对象实现了接口,且强制cglib代理,则使用cglib代理
        
        在SpringBoot中，启动类加上以下注解强制使用Cglib代理，该注解默认是false
        @EnableAspectJAutoProxy(proxyTargetClass = true)
        
        具体可以看Spring源码
```java
    public class DefaultAopProxyFactory implements AopProxyFactory, Serializable {
        public DefaultAopProxyFactory() {
        }
    
        public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
            if (!config.isOptimize() && !config.isProxyTargetClass() && !this.hasNoUserSuppliedProxyInterfaces(config)) {
                return new JdkDynamicAopProxy(config);
            } else {
                Class<?> targetClass = config.getTargetClass();
                if (targetClass == null) {
                    throw new AopConfigException("TargetSource cannot determine target class: Either an interface or a target is required for proxy creation.");
                } else {
                    return (AopProxy)(!targetClass.isInterface() && !Proxy.isProxyClass(targetClass) ?
                    new ObjenesisCglibAopProxy(config) : new JdkDynamicAopProxy(config));
                }
            }
        }
    
        private boolean hasNoUserSuppliedProxyInterfaces(AdvisedSupport config) {
            Class<?>[] ifcs = config.getProxiedInterfaces();
            return ifcs.length == 0 || ifcs.length == 1 && SpringProxy.class.isAssignableFrom(ifcs[0]);
        }
    }
```
    代理AOP对象
    
              |--------------|
              |    proxy     |
              |  |--------|  |
    [caller]->|->| target |  |
              |  |--------|  |
              |              |
              |--------------|
    设计模式
```java
public interface Subject {
    void request();

    void hello();
}

public class ProxySubject implements Subject{

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("-------before-------");
        try{
            realSubject.request();
        }catch (Exception e){
            System.out.println("-------ex-------"+e.getMessage());
            throw e;
        }finally {
            System.out.println("-------after-------");
        }
    }

    @Override
    public void hello() {
        realSubject.hello();
    }
}

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real ISubject execute request");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
```
### Spring AOP 的一些坑
    1.不宜把重要的业务逻辑放到aop中处理
    2.无法拦截static、final方法、private方法
    3.无法拦截内部方法调用
    
```java

//坑3的代码情况
@Service
public class DemoService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getData(){
        System.out.println("select from database");
        return Arrays.asList("AAA","BBB","CCC");
    }
    
    public List<String> innerCall(){
        return getData();
    }
}
////////////////////////////////////////////////////////
////////////////////   解决方案   ///////////////////////
////////////////////////////////////////////////////////
/**
* 编写一个bean注入到容器中，
* 然后通过该bean去容器获取对应的service的代理对象，
* 用该对象调用缓存的方法。
* 
* 原因：
*   Spring Aop是通过代理实现的，
*   this的引用是bean本身，不是代理对象，
*   我们从IOC容器中获取的bean其实都是代理对象，不是bean本身，
*   更主要的原因是AOP拦截是代理对象，不是bean本身。
*   因此才会出现无法拦截内部方法调用的情况
*/
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext ctx;

    public static ApplicationContext getContext() {
        return ctx;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
@Service
public class DemoService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getData(){
        System.out.println("select from database");
        return Arrays.asList("AAA","BBB","CCC");
    }
    public List<String> innerCall(){
       MenuService proxy = ApplicationContextHolder.getContext().getBean(MenuService.class);
       return proxy.getData();
    }
}
