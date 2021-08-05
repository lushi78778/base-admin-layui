<#import '../common/admin.ftlh' as admin>
<#-- 后台管理基本布局 -->
<@admin.layout>
<#-- 数据表格 -->
    <table id="user" lay-filter="user"></table>
<#-- 数据表格头工具栏 -->
    <script type="text/html" id="toolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-normal" lay-event="add">添加用户</button>
        </div>
    </script>
<#-- 数据表格行工具 -->
    <script type="text/html" id="action">
        <a class="layui-btn layui-btn-default" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger" lay-event="delete">删除</a>
    </script>
<#-- 用户相关js -->
    <script src="js/user.js"></script>
</@admin.layout>
<#-- 数据表单 -->
<form class="layui-form layui-form-pane layui-hide" lay-filter="save" id="user-form" autocomplete="off">
    <#-- 用户ID -->
    <input type="text" name="id" class="layui-input layui-hide layui-disabled" readonly>
    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
            <select name="role">
                <#list roles as role>
                    <option value="${role.id}">${role.name}</option>
                </#list>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="password" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" pane>
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="gender" value="男" title="男">
            <input type="radio" name="gender" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" name="phone" placeholder="请输入电话" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" placeholder="请输入邮箱" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <button type="button" class="layui-btn layui-btn-normal" id="test1">上传头像</button>
        <img class="layui-upload-img" id="demo1" style="width: 64px;height: 64px;margin-left: 20px">
        <p id="demoText"></p>
        <input type="text" name="avatar" class="layui-hide" value="default_avatar.jpg">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-normal layui-btn-fluid" type="button" lay-submit lay-filter="save">保存</button>
    </div>
</form>