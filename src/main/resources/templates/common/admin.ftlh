<#macro layout>
    <!DOCTYPE html>
    <html lang="zh">
    <head>
        <base href="${request.contextPath}/">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Base Admin 后台管理系统脚手架</title>
        <link rel="stylesheet" href="lib/layui/css/layui.css">
        <link rel="stylesheet" href="css/admin.css">
        <script src="lib/layui/layui.js"></script>
        <script src="lib/jquery-3.6.0.js"></script>
        <script src="js/admin.js"></script>

    </head>
    <body>
        <div class="layui-layout layui-layout-admin">
            <#include './header.ftlh'>
            <#include './side.ftlh'>
            <div class="layui-body">
                <!-- 内容主体区域 -->
                <div class="admin-content layui-panel">
                    <#nested>
                </div>
            </div>
        </div>
    </body>
    </html>
</#macro>
