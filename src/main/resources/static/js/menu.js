layui.use(['table', 'form'], function () {
    const table = layui.table;
    const form = layui.form;

    /* 渲染图标列表 */
    icons.map(icon => {
        $("#icon").append(
            "<div class='layui-col-xs2' style='margin-top: 2px;text-align: center'>" +
            "<button type='button' class='layui-btn layui-btn-primary' onclick='setIcon(\"" + icon + "\",this)'>" +
            "<i class='layui-icon " + icon + "'></i>" +
            "</button>" +
            "</div>"
        )
    })

    /* 数据表格列设置 */
    const cols = [[
        {field: 'id', title: 'ID', width: 100, align: 'center'},
        {field: 'pid', title: '父级菜单ID', width: 100, align: 'center'},
        {field: 'name', title: '菜单名称', align: 'center'},
        {field: 'path', title: '菜单路径', align: 'center'},
        {
            field: 'icon', title: '菜单图标', align: 'center', templet: function (d) {
                return "<i class='layui-icon " + d.icon + "'>";
            }
        },
        {title: '操作', toolbar: '#action', width: 200, align: 'center'}
    ]]

    //渲染表格
    table.render({
        url: 'menu/list',
        method: 'post',
        elem: '#menu',
        toolbar: '#toolbar',
        defaultToolbar: ['filter', 'exports'],
        page: true,
        cols: cols,
    })

    //头工具栏事件
    table.on('toolbar(menu)', function (obj) {
        if (obj.event === "add") {
            const menuForm = $("#menu-form");
            $(menuForm)[0].reset();
            $(menuForm).removeClass("layui-hide");
            layer.open({
                type: 1,
                area: '500px',
                title: "添加菜单",
                content: menuForm,
                end: function () {
                    $(menuForm).addClass("layui-hide");
                }
            })
            return false;
        }
    });

    //监听行工具事件
    table.on('tool(menu)', async function (obj) {
        if (obj.event === 'edit') {
            form.val("save", obj.data)
            const menuForm = $("#menu-form");
            $(menuForm).removeClass("layui-hide");
            layer.open({
                type: 1,
                area: '500px',
                title: "修改菜单",
                content: menuForm,
                end: function () {
                    $(menuForm).addClass("layui-hide");
                }
            })
            return false;
        }
        if (obj.event === 'delete') {
            const params = {
                id: obj.data.id
            }
            const res = $.post("menu/delete", params);
            console.log(res)
            obj.del();
            return false;
        }
    });

    //表单提交
    form.on('submit(save)', async function (data) {
        console.log(data.field)
        const res = await $.post("menu/save", data.field);
        console.log(res)
        layer.closeAll()
        table.reload("menu")
    })
})

//显示/隐藏图标列表
function showIcon() {
    const icons = $("#icon");
    if ($(icons).hasClass("layui-hide")) {
        $(icons).removeClass("layui-hide");
    } else {
        $(icons).addClass("layui-hide");
    }
}

//设置图标
function setIcon(icon, btn) {
    $("input[name='icon']").val(icon);
    $("#icon button").removeClass("layui-btn-normal").addClass("layui-btn-primary")
    $(btn).removeClass("layui-btn-primary").addClass("layui-btn-normal");
}

//图标
const icons = [
    "layui-icon-heart-fill",
    "layui-icon-heart",
    "layui-icon-light",
    "layui-icon-time",
    "layui-icon-bluetooth",
    "layui-icon-at",
    "layui-icon-mute",
    "layui-icon-mike",
    "layui-icon-key",
    "layui-icon-gift",
    "layui-icon-email",
    "layui-icon-rss",
    "layui-icon-wifi",
    "layui-icon-logout",
    "layui-icon-android",
    "layui-icon-ios",
    "layui-icon-windows",
    "layui-icon-transfer",
    "layui-icon-service",
    "layui-icon-subtraction",
    "layui-icon-addition",
    "layui-icon-slider",
    "layui-icon-print",
    "layui-icon-export",
    "layui-icon-cols",
    "layui-icon-screen-restore",
    "layui-icon-screen-full",
    "layui-icon-rate-half",
    "layui-icon-rate",
    "layui-icon-rate-solid",
    "layui-icon-cellphone",
    "layui-icon-vercode",
    "layui-icon-login-wechat",
    "layui-icon-login-qq",
    "layui-icon-login-weibo",
    "layui-icon-password",
    "layui-icon-username",
    "layui-icon-refresh-3",
    "layui-icon-auz",
    "layui-icon-spread-left",
    "layui-icon-shrink-right",
    "layui-icon-snowflake",
    "layui-icon-tips",
    "layui-icon-note",
    "layui-icon-home",
    "layui-icon-senior",
    "layui-icon-refresh",
    "layui-icon-refresh-1",
    "layui-icon-flag",
    "layui-icon-theme",
    "layui-icon-notice",
    "layui-icon-website",
    "layui-icon-console",
    "layui-icon-face-surprised",
    "layui-icon-set",
    "layui-icon-template-1",
    "layui-icon-app",
    "layui-icon-template",
    "layui-icon-praise",
    "layui-icon-tread",
    "layui-icon-male",
    "layui-icon-female",
    "layui-icon-camera",
    "layui-icon-camera-fill",
    "layui-icon-more",
    "layui-icon-more-vertical",
    "layui-icon-rmb",
    "layui-icon-dollar",
    "layui-icon-diamond",
    "layui-icon-fire",
    "layui-icon-return",
    "layui-icon-location",
    "layui-icon-read",
    "layui-icon-survey",
    "layui-icon-face-smile",
    "layui-icon-face-cry",
    "layui-icon-cart-simple",
    "layui-icon-cart",
    "layui-icon-next",
    "layui-icon-prev",
    "layui-icon-upload-drag",
    "layui-icon-upload",
    "layui-icon-download-circle",
    "layui-icon-component",
    "layui-icon-file-b",
    "layui-icon-user",
    "layui-icon-find-fill",
    "layui-icon-loading",
    "layui-icon-loading-1",
    "layui-icon-add-1",
    "layui-icon-play",
    "layui-icon-pause",
    "layui-icon-headset",
    "layui-icon-video",
    "layui-icon-voice",
    "layui-icon-speaker",
    "layui-icon-fonts-del",
    "layui-icon-fonts-code",
    "layui-icon-fonts-html",
    "layui-icon-fonts-strong",
    "layui-icon-unlink",
    "layui-icon-picture",
    "layui-icon-link",
    "layui-icon-face-smile-b",
    "layui-icon-align-left",
    "layui-icon-align-right",
    "layui-icon-align-center",
    "layui-icon-fonts-u",
    "layui-icon-fonts-i",
    "layui-icon-tabs",
    "layui-icon-radio",
    "layui-icon-circle",
    "layui-icon-edit",
    "layui-icon-share",
    "layui-icon-delete",
    "layui-icon-form",
    "layui-icon-cellphone-fine",
    "layui-icon-dialogue",
    "layui-icon-fonts-clear",
    "layui-icon-layer",
    "layui-icon-date",
    "layui-icon-water",
    "layui-icon-code-circle",
    "layui-icon-carousel",
    "layui-icon-prev-circle",
    "layui-icon-layouts",
    "layui-icon-util",
    "layui-icon-templeate-1",
    "layui-icon-upload-circle",
    "layui-icon-tree",
    "layui-icon-table",
    "layui-icon-chart",
    "layui-icon-chart-screen",
    "layui-icon-engine",
    "layui-icon-triangle-d",
    "layui-icon-triangle-r",
    "layui-icon-file",
    "layui-icon-set-sm",
    "layui-icon-reduce-circle",
    "layui-icon-add-circle",
    "layui-icon-404",
    "layui-icon-about",
    "layui-icon-up",
    "layui-icon-down",
    "layui-icon-left",
    "layui-icon-right",
    "layui-icon-circle-dot",
    "layui-icon-search",
    "layui-icon-set-fill",
    "layui-icon-group",
    "layui-icon-friends",
    "layui-icon-reply-fill",
    "layui-icon-menu-fill",
    "layui-icon-log",
    "layui-icon-picture-fine",
    "layui-icon-face-smile-fine",
    "layui-icon-list",
    "layui-icon-release",
    "layui-icon-ok",
    "layui-icon-help",
    "layui-icon-chat",
    "layui-icon-top",
    "layui-icon-star",
    "layui-icon-star-fill",
    "layui-icon-close-fill",
    "layui-icon-close",
    "layui-icon-ok-circle",
    "layui-icon-add-circle-fine"
]
