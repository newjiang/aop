package demo.jiang.aop.theory.chain.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端
 */
@Slf4j
public class Client {
    /**
     * HandlerAlpha
     */
    static class HandlerAlpha extends Handler {
        @Override
        protected void processed() {
            log.info("handle by {} ..", this.getClass().getSimpleName());
        }
    }

    /**
     * HandlerBate
     */
    static class HandlerBate extends Handler {
        @Override
        protected void processed() {
            log.info("handle by {} ..", this.getClass().getSimpleName());
        }
    }

    /**
     * HandlerGamma
     */
    static class HandlerGamma extends Handler {
        @Override
        protected void processed() {
            log.info("handle by {} ..", this.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Handler alpha = new HandlerAlpha();
        Handler bate = new HandlerBate();
        Handler gamma = new HandlerGamma();
        alpha.setHandler(bate);
        bate.setHandler(gamma);
        alpha.execute();
    }
}
