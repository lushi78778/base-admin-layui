package base.dao;

import base.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 系统角色表（Role）Dao层
 *
 * @author hui
 * @date 2021-07-29 09:11:43
 */
public interface RoleDao extends JpaRepository<Role, Integer> {
}
