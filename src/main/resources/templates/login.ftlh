<!doctype html>
<html lang="en">
<head>
    <base href="${request.contextPath}/">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link rel="stylesheet" href="lib/layui/css/layui.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <#-- 粒子背景 -->
    <div id="particles-js"></div>
    <#-- 登录表单 -->
    <form class="layui-form login-form layui-panel" autocomplete="off">
        <h1 class="login-title">
            <img style="height: 30px" src="img/logo.png" alt="logo">
            <span>Base Admin</span>
        </h1>
        <#-- 用户名 -->
        <div class="layui-form-item">
            <i class="layui-icon layui-icon-username"></i>
            <input type="text" name="username" placeholder="请输入用户名" class="layui-input" lay-verify="required" lay-reqText="请输入用户名">
        </div>
        <#-- 密码 -->
        <div class="layui-form-item">
            <i class="layui-icon layui-icon-password"></i>
            <input type="password" name="password" placeholder="请输入密码" class="layui-input" lay-verify="required" lay-reqText="请输入密码">
        </div>
        <#-- 验证码 -->
        <div class="layui-form-item">
            <i class="layui-icon layui-icon-vercode"></i>
            <input type="text" name="captcha" placeholder="请输入验证码" class="layui-input" lay-verify="required" lay-reqText="请输入验证码">
            <img id="captcha" src="captcha" alt="验证码生成失败！">
        </div>
        <div class="layui-form-item">
            <button class="layui-btn layui-btn-normal layui-btn-fluid" id="submit" type="button" lay-submit lay-filter="login">
                登录
            </button>
        </div>
    </form>
    <script src="lib/layui/layui.js"></script>
    <script src="lib/jquery-3.6.0.js"></script>
    <script src="lib/particles.js"></script>
    <script>
        layui.use(['form'], function () {
            const form = layui.form;
            //监听提交
            form.on('submit(login)', async function (data) {
                //调用登录接口
                const res = await $.post("login", data.field);
                if (res.code === 1000) {
                    //登录成功，跳转到系统首页
                    location.href = res.data;
                } else {
                    //登录失败，弹出提示
                    layer.msg(res.msg)
                }
            });
        });

        //按下回车登录
        $("body").on('keyup', e => {
            if (e.which === 13) {
                $("#submit").trigger("click");
            }
        })

        //点击刷新验证码
        $("#captcha").on('click', e => {
            e.target.src += "?" + Math.random();
        })
    </script>
</body>
</html>