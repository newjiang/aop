package demo.jiang.aop.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取Spring的上下文
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    /**
     * Spring的上下文
     */
    @Setter
    @Getter
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        setContext(context);
    }
}

