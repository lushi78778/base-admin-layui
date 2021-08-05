<#import '../common/admin.ftlh' as admin>
<#-- 后台管理基本布局 -->
<@admin.layout>
<#-- 数据表格 -->
    <table id="role" lay-filter="role"></table>
<#-- 数据表格头工具栏 -->
    <script type="text/html" id="toolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-normal" lay-event="add">添加角色</button>
        </div>
    </script>
<#-- 数据表格行工具 -->
    <script type="text/html" id="action">
        <a class="layui-btn layui-btn-default" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger" lay-event="delete">删除</a>
    </script>
<#-- 角色相关js -->
    <script src="js/role.js"></script>
</@admin.layout>
<#-- 数据表单 -->
<form class="layui-form layui-form-pane layui-hide" lay-filter="save" id="role-form" autocomplete="off">
    <#-- 角色ID -->
    <input type="text" name="id" class="layui-input layui-hide layui-disabled" readonly>
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" placeholder="请输入角色名称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色备注</label>
        <div class="layui-input-block">
            <input type="text" name="remark" placeholder="请输入角色备注" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色权限</label>
        <div class="layui-input-block">
            <div id="menus"></div>
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-normal layui-btn-fluid" type="button" lay-submit lay-filter="save">保存</button>
    </div>
</form>