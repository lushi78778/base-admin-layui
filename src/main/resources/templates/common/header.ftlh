<div class="layui-header">
    <div class="layui-logo">
        <h2>Base Admin</h2>
    </div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left"></ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="img/default_avatar.jpg" class="layui-nav-img" alt="admin">
                <span>admin</span>
            </a>
            <dl class="layui-nav-child">
                <dd><a href="profiles">个人信息</a></dd>
                <dd><a onclick="logout()">退出登录</a></dd>
            </dl>
        </li>
    </ul>
</div>