package demo.jiang.aop.model;

import demo.jiang.aop.annotation.MyArgs;
import lombok.Data;

@Data
@MyArgs
public class ArgsDto {
    /**
     * id
     */
    private String id;

    public ArgsDto() {
    }

    public ArgsDto(String id) {
        this.id = id;
    }
}
