package base.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统菜单表(Menu)实体类
 *
 * @author hui
 * @date 2021-07-29 09:07:17
 */
@Data
@Entity
public class Menu implements Serializable {
    private static final long serialVersionUID = -23960490608530841L;
    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 父级菜单ID
     */
    private Integer pid;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 菜单路径
     */
    private String href;
    /**
     * 菜单图标
     */
    private String icon;

    @Transient
    private List<Menu> child = new ArrayList<>();
}
