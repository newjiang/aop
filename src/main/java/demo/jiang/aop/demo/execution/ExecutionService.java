package demo.jiang.aop.demo.execution;

import org.springframework.stereotype.Service;

@Service
public class ExecutionService {

    public void alpha() {

    }

    public void beta() {

    }

    public String beta(String param) {
        return param;
    }

    public Integer beta(Integer param) {
        return param;
    }

    public Long beta(String param1, Integer param2) {
        return 1L;
    }

}
