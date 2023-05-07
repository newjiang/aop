package demo.jiang.aop.db;

import demo.jiang.aop.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PersonService service;

    @ParameterizedTest
    @ValueSource(ints = 1)
    void findById(int id) {
        log.info("persion = {}", service.findById(id));
    }

    @ParameterizedTest
    @ValueSource(ints = 9)
    void deleteById(int id) {
        // 删除前的查询
        Person before = mapper.findById(id);
        log.info("before delete = {}", before);
        Assertions.assertNotNull(before);

        // 测试事务
        Assertions.assertThrows(IllegalArgumentException.class, () -> log.info("delete={}", service.deleteById(id)));

        // 删除后的查询
        Person after = mapper.findById(id);
        log.info("after delete = {}", after);
        Assertions.assertNotNull(after); // 不为空
    }

    @ParameterizedTest
    @ValueSource(ints = 1)
    void beta(int id) {
        // 删除前的查询
        Person before = mapper.findById(id);
        log.info("before delete = {}", before);
        Assertions.assertNotNull(before);

        // 测试AOP
        Assertions.assertThrows(IllegalArgumentException.class, () -> log.info("delete={}", service.beta(id)));

        // 删除后的查询
        Person after = mapper.findById(id);
        log.info("after delete = {}", after);
        Assertions.assertNotNull(after); // 不为空
    }

    @ParameterizedTest
    @ValueSource(ints = 2)
    void gamma(int id) {
        // 删除前的查询
        Person before = mapper.findById(id);
        log.info("before delete = {}", before);
        Assertions.assertNotNull(before);

        // 测试AOP
        Assertions.assertThrows(IllegalArgumentException.class, () -> log.info("delete={}", service.gamma(id)));

        // 删除后的查询
        Person after = mapper.findById(id);
        log.info("after delete = {}", after);
        Assertions.assertNotNull(after); // 不为空
    }

    @ParameterizedTest
    @ValueSource(ints = 3)
    void alpha(int id) {
        // 删除前的查询
        Person before = mapper.findById(id);
        log.info("before delete = {}", before);
        Assertions.assertNotNull(before);

        // 测试AOP
        Assertions.assertThrows(IllegalArgumentException.class, () -> log.info("delete={}", service.alpha(id)));

        // 删除后的查询
        Person after = mapper.findById(id);
        log.info("after delete = {}", after);
        Assertions.assertNull(after); // 为空
    }
}