<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>layout</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>


    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css">


</head>
<body class="easyui-layout">
<!-- 使用div元素描述每个区域 -->

<div title="周磊管理系统" style="height: 100px;" data-options="region:'north'"> 北部区域</div>
<div title="系统菜单" style="width: 200px;" data-options="region:'west'">

    <div class="easyui-accordion" data-options="fit:true">
        <div title="panel 1" data-options="iconCls:'icon-save'">
            <a id="btn1" class="easyui-linkbutton">添加一个选项卡</a>
            <script>
                $(function () {
                    $("#btn1").click(
                        function () {
                            var e = $("#mytabs").tabs("exists", "系统管理");

                            if (e) {
                                $("#mytabs").tabs("select", "系统管理")
                            } else {
                                $("#mytabs").tabs("add", {
                                    title: "系统管理",
                                    iconCls: 'icon-edit',
                                    closable: 'true',
                                    content: '<iframe src="https://www.baidu.com" frameborder="0" height="100%" width="100%">'
                                });
                            }


                        }
                    );
                });
            </script>
        </div>

        </iframe>

        <div title="panel 2">
            <ul id="ztree1" class="ztree">
                <script>
                    $(function () {
                        var settings = {};
                        var zNodes = [
                            {"name": "node1", children: [{"name": "child1"}]},
                            {"name": "node2"},
                            {"name": "node3"},
                        ];

                        $.fn.zTree.init($("#ztree1"), settings, zNodes)
                    });
                </script>

            </ul>

        </div>
        <div title="panel 3">
            <ul id="ztree2" class="ztree">
                <script>
                    $(function () {
                        var settings = {
                            data: {
                                simpleData: {
                                    enable: true
                                }
                            }
                        };
                        var zNodes = [
                            {id: "1", "pId": 0, "name": "node1"},
                            {id: "2", "pId": 1, "name": "node1"},
                            {id: "3", "pId": 2, "name": "node1"},
                        ];

                        $.fn.zTree.init($("#ztree2"), settings, zNodes)
                    });
                </script>

            </ul>
        </div>

        <div title="panel 4">

            <ul id="ztree3" class="ztree">
                <script>
                    $(function () {
                        var settings = {
                            data: {
                                simpleData: {
                                    enable: true
                                }
                            },
                            callback: {
                                onClick: function (event, treeId, treeNode) {

                                    if (treeNode.page != undefined) {

                                        var e = $("#mytabs").tabs("exists", treeNode.name);

                                        if (e) {
                                            $("#mytabs").tabs("select", treeNode.name)
                                        } else {
                                            $("#mytabs").tabs("add", {
                                                title: treeNode.name,
                                                iconCls: 'icon-edit',
                                                closable: 'true',
                                                content: '<iframe src="' + treeNode.page + '" frameborder="0" height="100%" width="100%">'
                                            });
                                        }
                                    }


                                }
                            }
                        };

                        var url = '${pageContext.request.contextPath}/json/menu.json';
                        $.post(url, {}, function (data) {
                            $.fn.zTree.init($("#ztree3"), settings, data)

                        }, 'json');

                    });
                </script>

            </ul>

        </div>

    </div>
</div>
<div data-options="region:'center'">
    <a class="easyui-menubutton" data-options="iconCls:'icon-help',menu:'#mm'">控制面板</a>
    <div id="mm">
        <div>修改密码</div>
        <div>联系管理员</div>

        <div class="menu-sep"></div>
        <div>退出</div>
    </div>
    <div id="mytabs" class="easyui-tabs" data-options="fit:true">
        <div title="panel 1" data-options="iconCls:'icon-save'">1111</div>
        <div title="panel 2" data-options="closable:true">2222</div>
        <div title="panel 3">3333</div>
    </div>
</div>
<div title="" style="width: 100px;" data-options="region:'east'"> 背部区域</div>
<div title="" style="height: 50px;" data-options="region:'south'"> 南部区域</div>

<script>
    $(function () {
        // $.messager.alert("标题", "内容", "warning")

        $.messager.show({
            title: "mytitile",
            msg: "hello logou",
            timeout: 4000,
            showType: 'slide'
        })

    });
</script>


</body>
</html>