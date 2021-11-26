package base.controller;

import base.bean.Result;
import base.bean.RetCode;
import base.dao.UserDao;
import base.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理控制器
 *
 * @author hui
 * @date 2021-07-29 09:22:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    /**
     * 查询所有用户
     *
     * @return 统一返回值JSON
     */
    @PostMapping("/list")
    public Result list() {
        List<User> users = userDao.findAll();
        return new Result(RetCode.OK, users, users.size());
    }

    /**
     * 添加/修改用户
     *
     * @param user User对象
     * @return 统一返回值JSON
     */
    @PostMapping("/save")
    public Result save(User user) {
        userDao.save(user);
        return new Result(RetCode.OK);
    }

    /**
     * 根据ID删除用户
     *
     * @param id 用户ID
     * @return 统一返回值JSON
     */
    @PostMapping("/delete")
    public Result delete(Integer id) {
        userDao.deleteById(id);
        return new Result(RetCode.OK);
    }
}
