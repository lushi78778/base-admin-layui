package hui.base.dao;

import hui.base.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 系统菜单表（Menu）Dao层
 *
 * @author hui
 * @date 2021-07-29 09:11:27
 */
public interface MenuDao extends JpaRepository<Menu, Integer> {
}
