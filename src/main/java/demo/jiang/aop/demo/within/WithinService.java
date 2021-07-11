package demo.jiang.aop.demo.within;

import org.springframework.stereotype.Service;

/**
 * 匹配包/类型的切莫
 */
@Service
public class WithinService {

    public String alpha() {
        return "alpha";
    }

    public String beta() {
        return "beta";
    }
}
