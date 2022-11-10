# Base Admin Layui

## 使用指南
将代码导入到Eclipse或IDEA等开发工具中

创建base数据库，将项目根目录下的base.sql导入到base数据库中

修改**src\main\resources\application.yaml**中数据库相关配置为自己的环境

启动**src\main\java\hui\base\Application.java**，访问路径为：http://localhost:9999/base


## 开发环境
1. **Java 11**
2. **MySQL 8.0**

## 技术选型
1. **Spring Boot**
2. **Spring Data JPA**
3. **Freemarker**
4. **Layui**

## 功能设计

1. 系统首页
2. 菜单管理（添加、修改、删除、查询）
3. 角色管理（添加、修改、删除、查询）
4. 用户管理（添加、修改、删除、查询）
5. 用户登录
6. 个人信息
7. 退出登录