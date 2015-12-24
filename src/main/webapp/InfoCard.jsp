<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--信息卡片-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>关爱走失人群，让温暖传递下去！</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        textarea{
            height: 46px;
            border: 0px;
            width: 60%;
        }
    </style>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.poptrox.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $('#gallery').poptrox({
                usePopupCaption: true
            });
        });
    </script>
</head>
<body>
<div class="div1">
    <div class="image"><img src="images/icon.png"></div>
    <div class="optext1">
        <div class="lbname">${ Info.name}</div>
        <div class="lbother">${ Info.sex}，${ Info.age}岁</div>
    </div>
</div>
<div class="div4 borderstyle">
    <div class="infodet">
        <a><img src="images/img1.png"></a>
        <div class="lb1">照片（可点击放大） </div>
    </div>
    <div id="wrapper">
        <div id="gallery">
            <!--读取图片,只选了一个测试图片-->
            <c:if test="${empty Info.photo1}">
            <a href="images/icon.png"><img src="images/icon.png" title="kk"></a>
            </c:if>
            <c:if test="${not empty Info.photo1}">
            <a href="${Info.photo1 }"><img src="${Info.photo1 }" title="kk"></a>
            </c:if>
            <c:if test="${not empty Info.photo2}">
            <a href="${Info.photo2 }"><img src="${Info.photo2 }" title="kk"></a>
            </c:if>
            <c:if test="${not empty Info.photo3}">
            <a href="${Info.photo3 }"><img src="${Info.photo3 }" title="kk"></a>
            </c:if>
        </div>
    </div>
</div>
<div class="div3 borderstyle">
    <div class="infodet">
        <a><img src="images/name1.png"></a>
        <div class="lb">走失日期</div>
        <input id="LostTime" class="kbtn txt" value="${time}" readonly/>
    </div>
    <div class="infodet">
        <a><img src="images/loc1.png"></a>
        <div class="lb">走失地点</div>
        <input type="text" id="locatxt" class="txt" value="${Info.lostLocation}"readonly>
    </div>
    <div class="infodet1">
        <a><img src="images/det1.png"></a>
        <div class="lb">特征描述</div>
        <textarea id="detail1" class="detail" readonly>${Info.characteristic}</textarea>
    </div>
    <c:if test="${not empty Info.remark}">
    <div class="infodet1"  id="infodetail2">
        <a><img src="images/det3.png"></a>
        <div class="lb">其他描述</div>
        <textarea id="detail2" class="detail" readonly>${Info.remark}</textarea>
    </div>
     </c:if>
</div>
<div class="div4">
    <div class="altertxt">
        <div class="image"><img src="images/alert1.png"></div>
        <div class="alertInfo" id="alert1"style="display: ${volunteer};"><a>请点击右上角将名片分享至朋友圈，让更多人帮助寻找！</a></div>
        <div class="alertInfo" id="alter2" style="display: ${lost};"><a>您登记的信息已上传，当有寻家儿童与您上传信息匹配后，我们会给您登记的邮箱发送信息，请及时关注！</a></div>
        <div class="alertInfo" id="alter3" style="display: ${find};"><a>您登记的信息已上传，当有寻亲家属与您上传信息匹配后，我们会给您登记的邮箱发送信息，请及时关注！</a></div>
    </div>
    <div style="width: 100%;text-align: center; ">
        <input type="button" class="alertbtn1" id="btnfind" style="display: ${button};" value="我找到了相似的人" onclick="window.location.href='volunteer.htm'">
    </div>

    <div style="display: none;" id="btnedit">
        <div style="width: 50%;float: left;">
            <input type="button" class="alterbtn2" value="编辑">
        </div>
        <div style="width: 50%;float: right;">
            <input type="button" class="alterbtn2" value="已找到">
        </div>
    </div>
</div>


</body>
</html>