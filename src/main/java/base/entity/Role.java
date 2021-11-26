package base.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (Role)实体类
 *
 * @author hui
 * @date 2021-07-29 09:07:16
 */
@Data
@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 261193586078963535L;
    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色备注
     */
    private String remark;

    @OneToMany
    List<Menu> menu = new ArrayList<>();
}
