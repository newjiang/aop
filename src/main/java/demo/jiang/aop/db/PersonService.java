package demo.jiang.aop.db;

import demo.jiang.aop.context.ApplicationContextHolder;
import demo.jiang.aop.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    /**
     * 根据ID查询实体
     *
     * @param id id
     * @return 实体
     */
    public Person findById(int id) {
        return personMapper.findById(id);
    }

    /**
     * 根据Id删除实体
     *
     * @param id id
     * @return 影响行数
     */
    @Transactional
    public int deleteById(int id) {
        int firstDelete = personMapper.deleteById(id);
        int secondDelete = personMapper.deleteById(id);
        log.info("firstDelete = {}", firstDelete);
        log.info("secondDelete = {}", secondDelete);
        int res = firstDelete + secondDelete;
        if (firstDelete == 0 || secondDelete == 0) {
            log.error("delete[id = {}] failure!!!", id);
            throw new IllegalArgumentException("id = " + id + " 删除失败");
        }
        return res;
    }

    /**
     * alpha
     *
     * @param id id
     * @return 影响行数
     */
    public int alpha(int id) {
        return deleteById(id);
    }

    /**
     * beta
     *
     * @param id id
     * @return 影响行数
     */
    @Transactional
    public int beta(int id) {
        return deleteById(id);
    }

    /**
     * gamma
     *
     * @param id id
     * @return 影响行数
     */
    public int gamma(int id) {
        return ApplicationContextHolder.getContext().getBean(PersonService.class).deleteById(id);
    }
}
