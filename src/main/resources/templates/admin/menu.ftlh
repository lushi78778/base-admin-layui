<#import '../common/admin.ftlh' as admin>
<#-- 后台管理基本布局 -->
<@admin.layout>
<#-- 数据表格 -->
    <table id="menu" lay-filter="menu"></table>
<#-- 数据表格头工具栏 -->
    <script type="text/html" id="toolbar">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-normal" lay-event="add">添加菜单</button>
        </div>
    </script>
<#-- 数据表格行工具 -->
    <script type="text/html" id="action">
        <a class="layui-btn layui-btn-default" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger" lay-event="delete">删除</a>
    </script>
<#-- 菜单相关js -->
    <script src="js/menu.js"></script>
</@admin.layout>
<#-- 数据表单 -->
<form class="layui-form layui-form-pane layui-hide" lay-filter="save" id="menu-form" autocomplete="off">
    <#-- 菜单ID -->
    <input type="text" name="id" class="layui-input layui-hide layui-disabled" readonly>
    <#-- 父级菜单 -->
    <div class="layui-form-item">
        <label class="layui-form-label">父级菜单</label>
        <div class="layui-input-block">
            <select name="pid">
                <option value="0">无</option>
                <#list menus as menu>
                    <option value="${menu.id}">${menu.name}</option>
                    <#if menu.children?size gt 0>
                        <#list menu.children as child>
                            <option value="${child.id}">—— ${child.name}</option>
                        </#list>
                    </#if>
                </#list>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" placeholder="请输入菜单名称" class="layui-input" lay-verify="required" lay-reqText="请输入菜单名称">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单路径</label>
        <div class="layui-input-block">
            <input type="text" name="path" placeholder="请输入菜单路径" class="layui-input" lay-verify="required" lay-reqText="请输入菜单路径">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜单图标</label>
        <div class="layui-input-block">
            <input type="text" name="icon" placeholder="请选择菜单图标" class="layui-input" readonly
                   lay-verify="required" lay-reqText="请选择菜单图标">
        </div>
        <div class="layui-row" id="icon"></div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-normal layui-btn-fluid" type="button" lay-submit lay-filter="save">保存</button>
    </div>
</form>