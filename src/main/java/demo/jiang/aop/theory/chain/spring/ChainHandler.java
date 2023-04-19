package demo.jiang.aop.theory.chain.spring;

/**
 * 调用链处理器
 */
public abstract class ChainHandler {
    /**
     * 执行
     *
     * @param chain 调用链
     */
    public void execute(Chain chain) {
        proceed();
        chain.proceed();
    }

    /**
     * 继续执行
     */
    protected abstract void proceed();
}
