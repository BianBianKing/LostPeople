<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--志愿者上传信息后返回的是否匹配成功的信息-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title></title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <title></title>
</head>
<body style="text-align: center;">
    <div class="result">
        <img src="images/icon.png">
    </div>
    <div class="resultnote">提示信息</div>
    <div class="resulttxt" id="txt">感谢您帮助走走失者寻找回家的路。</div>
    <div class="resulttxt" id="succ"style="display: ${success};">您上传的照片与走失者匹配成功，请您联系家属：${result.phone },${result.name }</div>
    <div class="resulttxt" id="fail" style="display: ${fail};">非常遗憾，您上传的照片未与走失者匹配成功。</div>
</body>
</html>