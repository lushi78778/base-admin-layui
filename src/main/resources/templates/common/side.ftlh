<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" id="leftMenu" lay-filter="leftMenu">
            <#list menus as menu>
                <#if menu.children?size == 0>
                    <li class="layui-nav-item">
                        <a href="${menu.path}">
                            <i class="layui-icon ${menu.icon}"></i> <span>${menu.name}</span>
                        </a>
                    </li>
                <#else>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            <i class="layui-icon ${menu.icon}"></i> <span>${menu.name}</span>
                        </a>
                        <dl class="layui-nav-child">
                            <#list menu.children as child>
                                <dd>
                                    <a href="${child.path}">
                                        <i class="layui-icon ${child.icon}"></i> <span>${child.name}</span>
                                    </a>
                                </dd>
                            </#list>
                        </dl>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>
</div>