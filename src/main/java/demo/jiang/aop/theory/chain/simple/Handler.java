package demo.jiang.aop.theory.chain.simple;

import lombok.Data;

/**
 * 处理器
 */
@Data
public abstract class Handler {
    /**
     * 处理器对象
     */
    private Handler handler;

    /**
     * 执行
     */
    public void execute() {
        proceed();
        if (handler != null) {
            handler.execute();
        }
    }

    /**
     * 继续执行
     */
    protected abstract void proceed();
}
