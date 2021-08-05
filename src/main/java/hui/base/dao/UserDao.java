package hui.base.dao;

import hui.base.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 系统用户表（Dao层）
 *
 * @author hui
 * @date 2021-07-29 09:11:00
 */
public interface UserDao extends JpaRepository<User, Integer> {
	/**
	 * 根据用户名查询用户
	 *
	 * @param username 用户名
	 * @return User对象
	 */
	User findUserByUsername(String username);
}
