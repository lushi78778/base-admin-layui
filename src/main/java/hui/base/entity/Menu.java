package hui.base.entity;


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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String path) {
		this.href = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}
}
