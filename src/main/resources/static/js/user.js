layui.use(['table', 'form', 'upload'], function () {
    const table = layui.table;
    const form = layui.form;
    const upload = layui.upload;

    /* 数据表格列设置 */
    const cols = [[
        {field: 'id', title: 'ID', width: 100, align: 'center'},
        {field: 'username', title: '用户名', align: 'center'},
        {field: 'gender', title: '性别', width: 80, align: 'center'},
        {field: 'phone', title: '电话', align: 'center'},
        {field: 'email', title: '邮箱', align: 'center'},
        {
            field: 'avatar', title: '头像', width: 100, align: 'center', templet: function (d) {
                return "<img class='avatar' src='img/" + d.avatar + "'/>"
            }
        },
        {
            field: 'role', title: '角色', align: 'center', templet: function (d) {
                return d.role[0].name
            }
        },
        {title: '操作', toolbar: '#action', width: 200, align: 'center'}
    ]]

    //渲染表格
    table.render({
        url: 'user/list',
        method: 'post',
        elem: '#user',
        toolbar: '#toolbar',
        defaultToolbar: ['filter', 'exports'],
        page: true,
        cols: cols,
    })

    //头工具栏事件
    table.on('toolbar(user)', function (obj) {
        if (obj.event === "add") {
            const userForm = $("#user-form");
            $(userForm)[0].reset();
            $(userForm).removeClass("layui-hide");
            layer.open({
                type: 1,
                area: '500px',
                title: "添加用户",
                content: userForm,
                end: function () {
                    $(userForm).addClass("layui-hide");
                }
            })
            return false;
        }
    });

    //监听行工具事件
    table.on('tool(user)', async function (obj) {
        if (obj.event === 'edit') {
            const user = obj.data;
            user.role = obj.data.role[0].id;
            form.val("save", user)
            const userForm = $("#user-form");
            $(userForm).removeClass("layui-hide");
            layer.open({
                type: 1,
                area: '500px',
                title: "修改用户",
                content: userForm,
                end: function () {
                    $(userForm).addClass("layui-hide");
                }
            })
            return false;
        }
        if (obj.event === 'delete') {
            const params = {
                id: obj.data.id
            }
            const res = $.post("user/delete", params);
            console.log(res)
            obj.del();
            return false;
        }
    });

    //表单提交
    form.on('submit(save)', async function (data) {
        console.log(data.field)
        const res = await $.post("user/save", data.field);
        console.log(res)
        layer.closeAll()
        table.reload("user")
    })

    //图片上传
    upload.render({
        elem: '#test1'
        , url: 'https://httpbin.org/post' //改成您自己的上传接口
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#demo1').attr('src', result); //图片链接（base64）
            });

            element.progress('demo', '0%'); //进度条复位
            layer.msg('上传中', {icon: 16, time: 0});
        }
        , done: function (res) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功的一些操作
            //……
            $('#demoText').html(''); //置空上传失败的状态
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
        //进度条
        , progress: function (n, elem, e) {
            element.progress('demo', n + '%'); //可配合 layui 进度条元素使用
            if (n == 100) {
                layer.msg('上传完毕', {icon: 1});
            }
        }
    });
})