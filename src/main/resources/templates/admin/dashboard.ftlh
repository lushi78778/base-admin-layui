<#import '../common/admin.ftlh' as admin>
<@admin.layout>
    <blockquote class="layui-elem-quote">
        <h1>${USER.username}，欢迎使用Base Admin后台管理系统🎉</h1>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-xs6">
            <div class="layui-card">
                <div class="layui-card-header">
                    <h2>✨技术选型</h2>
                </div>
                <div class="layui-card-body">
                    <p style="font-weight: bold;">前端：</p>
                    <p style="text-indent: 2em">Freemarker</p>
                    <p style="text-indent: 2em">Layui</p>
                    <p style="font-weight: bold;">后端：</p>
                    <p style="text-indent: 2em">Spring Boot</p>
                    <p style="text-indent: 2em">Spring Data JPA</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs6">
            <div class="layui-card">
                <div class="layui-card-header">
                    <h2>⏳更新日志</h2>
                </div>
                <div class="layui-card-body">
                    <ul class="layui-timeline">
                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">2021年08月05日</h3>
                                <p>Base Admin 后台管理系统脚手架V1.0发布</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</@admin.layout>