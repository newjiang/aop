package demo.jiang.aop.demo.object;

import org.springframework.stereotype.Service;

@Service
public class ObjectService implements IObjectService {

    @Override
    public String alpha() {
        return "alpha";
    }

    @Override
    public String beta() {
        return "beta";
    }
}
