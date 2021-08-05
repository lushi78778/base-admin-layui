layui.use(['element'], function () {
    const element = layui.element;

    //激活当前导航菜单
    const current = location.pathname;
    const start = current.indexOf("/", 2) + 1;
    const path = current.substring(start);
    const navs = $("#leftMenu a");
    navs.map((index, nav) => {
        const href = $(nav).attr("href");
        if (href === path) {
            $(nav).parents("li").addClass("layui-nav-itemed")
            $(nav).parent("li").addClass("layui-this")
            $(nav).parent("dd").addClass("layui-this")
        }
    })

    //扩展关闭Layer弹框功能
    $("body")
        .on("keyup", e => {
            //按下ESC关闭Layer弹框
            if (e.which === 27) {
                layer.closeAll();
            }
        })
        .on("click", e => {
            //点击Layer弹框自身以外的部分关闭弹框
            if ($(e.target).hasClass("layui-layer-shade")) {
                layer.closeAll();
            }
        })
        .on("keyup", e => {
            //回车提交layui弹框内的表单
            if (e.which === 13) {
                $(".layui-layer-content .layui-btn-fluid").trigger("click");
            }
        })
});