package demo.jiang.aop.theory.chain.spring;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Client {
    static class ChainHandlerAlpha extends ChainHandler {
        @Override
        protected void proceed() {
            log.info("handle by {} ..", this.getClass().getSimpleName());
        }
    }

    static class ChainHandlerBeta extends ChainHandler {
        @Override
        protected void proceed() {
            log.info("handle by {} ..", this.getClass().getSimpleName());
        }
    }

    static class ChainHandlerGamma extends ChainHandler {
        @Override
        protected void proceed() {
            log.info("handle by {} ..", this.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = new ArrayList<>();
        handlers.add(new ChainHandlerAlpha());
        handlers.add(new ChainHandlerBeta());
        handlers.add(new ChainHandlerGamma());
        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
