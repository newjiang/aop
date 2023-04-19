package demo.jiang.aop.theory.chain.spring;

public abstract class ChainHandler {

    public  void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();

}
