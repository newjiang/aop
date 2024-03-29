package demo.jiang.aop.theory.chain.spring;

import java.util.List;

/**
 * 调用链
 *
 * @see org.springframework.aop.framework.ReflectiveMethodInvocation#proceed()
 */
public class Chain {

    private final List<ChainHandler> handlers;

    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    /**
     * 执行
     */
    public void proceed() {
        if (index >= handlers.size()) {
            return;
        }
        handlers.get(index++).execute(this);
    }
}
