<%--
  Created by IntelliJ IDEA.
  User: Chentyit
  Date: 2019/8/6
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Search</title>
    <link href="${pageContext.request.contextPath}/staticResource/css/init.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/staticResource/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        var path = "${pageContext.request.contextPath}";
        // 通过判断 PC 端和移动端加载不同的 CSS
        function browserRedirect() {
            var sUserAgent = navigator.userAgent.toLowerCase();
            if (/ipad|iphone|midp|rv:1.2.3.4|ucweb|android|windows ce|windows mobile/.test(sUserAgent)) {
                //跳转移动端页面
                document.write('<link href="' + path + '/staticResource/css/search_phone.css" rel="stylesheet">');
            } else {
                //跳转pc端页面
                document.write('<link href="' + path + '/staticResource/css/search_pc.css" rel="stylesheet">');
            }
        }
        browserRedirect();
    </script>
</head>
<body>
    <div class="point">
        <ul class="menu">
            <li>
                <a href="#NOP">
                    <img src="${pageContext.request.contextPath}/staticResource/images/rank.png">
                </a>
                <p>搜索排名</p>
            </li>
            <li>
                <a href="#NOP">
                    <img src="${pageContext.request.contextPath}/staticResource/images/login.png">
                </a>
                <p>登录</p>
            </li>
        </ul>
    </div>

    <div class="search-box">
        <input class="search-txt" type="text" placeholder="Type to search"/>
        <a class="search-btn" href="#">
            <i class="fas fa-search"></i>
        </a>
    </div>

    <script type="text/javascript">
        $(".search-btn").click(function() {
            // 获取 input 里面的值
            var getVal = $(".search-txt");
            // 控制台打印值
            console.log("input", getVal.val());
            // ajax 请求后台数据
            getGarInfo(getVal.val());
            // 将 input 的值置空
            getVal.val("");
        });

        function getGarInfo(garName) {
            console.log("ajax", garName);
            $.ajax({
                "type": "post",
                "contentType" : "application/json",
                "url": path + "/garbage/search?garName=" + garName,
                "async": true,
                "success": function (res) {
                    console.log("res", res);
                }
            })
        }
    </script>
</body>
</html>
