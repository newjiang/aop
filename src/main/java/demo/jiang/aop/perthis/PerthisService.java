package demo.jiang.aop.perthis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Scope("prototype")
public class PerthisService implements IPerthisService {
    @Override
    public void foo() {
        log.info("{}.foo() ..", this.getClass().getSimpleName());
    }
}
