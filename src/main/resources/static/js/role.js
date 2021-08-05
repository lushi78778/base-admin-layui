layui.use(['table', 'form', 'tree'], function () {
    const table = layui.table;
    const form = layui.form;
    const tree = layui.tree;

    //渲染
    tree.render({
        id: 'menus',
        elem: '#menus',
        data: toTree(data),
        showCheckbox: true,
    });

    /* 数据表格列设置 */
    const cols = [[
        {field: 'id', title: 'ID', width: 100, align: 'center'},
        {field: 'name', title: '角色名称', width: 200, align: 'center'},
        {field: 'remark', title: '角色备注', align: 'center'},
        {title: '操作', toolbar: '#action', width: 200, align: 'center'}
    ]]

    //渲染表格
    table.render({
        url: 'role/list',
        method: 'post',
        elem: '#role',
        toolbar: '#toolbar',
        defaultToolbar: ['filter', 'exports'],
        page: true,
        cols: cols,
    })

    //头工具栏事件
    table.on('toolbar(role)', function (obj) {
        if (obj.event === "add") {
            const roleForm = $("#role-form");
            $(roleForm)[0].reset();
            $(roleForm).removeClass("layui-hide");
            layer.open({
                type: 1,
                area: '500px',
                title: "添加角色",
                content: roleForm,
                end: function () {
                    $(roleForm).addClass("layui-hide");
                }
            })
            return false;
        }
    });

    //监听行工具事件
    table.on('tool(role)', async function (obj) {
        if (obj.event === 'edit') {
            form.val("save", obj.data)
            const roleForm = $("#role-form");
            $(roleForm).removeClass("layui-hide");
            layer.open({
                type: 1,
                area: '500px',
                title: "修改角色",
                content: roleForm,
                end: function () {
                    $(roleForm).addClass("layui-hide");
                }
            })
            return false;
        }
        if (obj.event === 'delete') {
            const params = {
                id: obj.data.id
            }
            const res = $.post("role/delete", params);
            console.log(res)
            obj.del();
            return false;
        }
    });

    //表单提交
    form.on('submit(save)', async function (data) {
        const role = data.field;
        role.menu = [];
        const menus = tree.getChecked('menus');
        menus.map((menu, index) => {
            role.menu[index] = menu.id
        })
        const res = await $.post("role/save", role);
        console.log(res)
        layer.closeAll()
        table.reload("role")
    })
})

const data = [
    {
        "id": 1,
        "pid": 0,
        "name": "系统首页",
        "path": "dashboard",
        "icon": "layui-icon-home",
        "children": []
    },
    {
        "id": 2,
        "pid": 0,
        "name": "系统设置",
        "path": "",
        "icon": "layui-icon-set",
        "children": []
    },
    {
        "id": 3,
        "pid": 2,
        "name": "菜单管理",
        "path": "menu",
        "icon": "layui-icon-spread-left",
        "children": []
    },
    {
        "id": 4,
        "pid": 2,
        "name": "角色管理",
        "path": "role",
        "icon": "layui-icon-user",
        "children": []
    },
    {
        "id": 5,
        "pid": 2,
        "name": "用户管理",
        "path": "user",
        "icon": "layui-icon-username",
        "children": []
    }
];

function toTree(menus, pid = 0) {
    let tree = [];
    menus.map(menu => {
        if (menu.pid === pid) {
            menu.title = menu.name
            tree.push(findChildren(menus, menu))
        }
    })
    return tree;
}

function findChildren(menus, parent) {
    menus.map(child => {
        if (child.pid === parent.id) {
            child.title = child.name
            parent.children.push(findChildren(menus, child))
        }
    })
    return parent;
}