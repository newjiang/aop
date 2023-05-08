package demo.jiang.aop.theory.dynamic.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.aop.framework.AdvisedSupport;

import java.lang.reflect.Method;

/**
 * CGlib代理是基于继承来实现的
 * 无法对象static，final，private类和方法，进行代理
 * Spring选择GClib的策略{@link org.springframework.aop.framework.DefaultAopProxyFactory#createAopProxy(AdvisedSupport)}
 */
@Slf4j
public class CGlibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("{} before ..", this.getClass().getSimpleName());
        Object result;
        try {
            result = proxy.invokeSuper(obj, args);
        } catch (Exception e) {
            log.info("{} exception ..", this.getClass().getSimpleName());
            throw e;
        } finally {
            log.info("{} after ..", this.getClass().getSimpleName());
        }
        return result;
    }

}
