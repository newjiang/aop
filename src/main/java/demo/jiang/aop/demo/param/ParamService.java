package demo.jiang.aop.demo.param;

import org.springframework.stereotype.Service;

@Service
public class ParamService {

    public String findAny() {
        return "findAny";
    }

    public Long findById(Long id) {
        return id;
    }

    public String deleteById(Long id) {
        return "deleteById";
    }


}
