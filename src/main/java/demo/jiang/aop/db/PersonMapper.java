package demo.jiang.aop.db;

import demo.jiang.aop.model.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    /**
     * 根据ID查询实体
     *
     * @param id id
     * @return 实体
     */
    @Select("SELECT * FROM PERSON WHERE ID = #{id}")
    Person findById(Integer id);

    /**
     * 根据Id删除实体
     *
     * @param id id
     * @return 影响行数
     */
    @Delete("DELETE FROM PERSON WHERE ID = #{id}")
    int deleteById(Integer id);
}
