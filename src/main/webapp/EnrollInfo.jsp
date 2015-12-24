<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--走失人群信息登记-->
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="description"
          content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/common.css" rel="stylesheet" type="text/css">
    <link href="css/email.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.9.1.js" type="text/javascript"></script>
    <script src="js/date.js" type="text/javascript"></script>
    <script src="js/iscroll.js" type="text/javascript"></script>
    <script src="js/emailAutoComplete.js" type="text/javascript"></script>
    <script src="js/showfunc.js" type="text/javascript"></script>
    <script type="text/javascript">
        function checktele(){
            var televal=document.getElementById("tele").value;
            re=/^1\d{10}$/;
            if(!re.test(televal))
            {
                alert("请填写正确的联系方式！");
            }
        }
        $(function(){
            $('#endTime').date({theme:"datetime"});
        });
        var ratioval="男";
        function sexchange(a)
        {
            ratioval=a;
        }
        function check(){
            var name=document.getElementById("name").value;
            var age=document.getElementById("age").value;
            var sex=ratioval;
            var date=document.getElementById("endTime").value;
            var local=document.getElementById("local").value;
            var tele=document.getElementById("tele").value;
            var email=document.getElementById("email").value;
            var imgcount=document.getElementById("img").childElementCount;
            if(name=="")
            {
                alert("请填写姓名！");
                return false;
            }
            if(age=="")
            {
                alert("请填写年龄！");
                return false;
            }
            if(sex=="")
            {
                alert("请选择性别！");
                return false;
            }
            if(date=="")
            {
                alert("请选择日期！");
                return false;
            }
            if(local=="")
            {
                alert("请填写走失详细地址！");
                return false;
            }if(tele=="")
            {
                alert("请填写您的联系方式！");
                return false;
            }if(email=="")
            {
                alert("请填写您的邮箱！");
                return false;
            }if(imgcount==0)
            {
                alert("请选择照片！");
                return false;
            }
        }
    </script>
</head>
<body>
<div class="div1">
    <div class="image"><img src="images/icon.png"></div>
    <div class="optext"><a>我要回家信息登记</a></div>
</div>
<form enctype="multipart/form-data" action="find.form" method="post" onsubmit="return check()">
<div class="div3 borderstyle">
    <div class="infodet">
        <a><img src="images/name1.png"></a>
        <div class="lb">姓名</div>
        <input type="text" id="name" name="name" class="txt" placeholder="填写您的姓名">
    </div>
    <div class="infodet">
        <a><img src="images/age.png"></a>
        <div class="lb">年龄</div>
        <input type="text" id="age" name="age" class="txt" placeholder="请填写年龄" >
    </div>
    <div class="infodet">
        <a><img src="images/sex.png"></a>
        <div class="lb">性别</div>
        <input type="radio" name="rd" class="radiotype" value='男'><div class="radiotxt">男</div>
        <input type="radio" name="rd" class="radiotype" value='女'><div class="radiotxt">女</div>
    </div>
    <div class="infodet">
        <a><img src="images/cal1.png"></a>
        <div class="lb">走失日期</div>
        <input id="endTime" name="endTime" class="kbtn txt" placeholder="填写走失时间" />
    </div>
    <div class="infodet1">
        <a><img src="images/loc1.png"></a>
        <div class="lb">走失地点</div>
        <div class="selectdiv">
            <select id="s_province" name="s_province"></select>
            <select id="s_city" name="s_city"></select>
            <input id="local" name="locatxt" class="txt" placeholder="填写详细走失地点" />
        </div>
    </div>
    <script class="resources library" src="js/area.js" type="text/javascript"></script>
    <script>
        //初始化地区选择
        _init_area();
    </script>
    <div class="infodet1">
        <a><img src="images/det1.png"></a>
        <div class="lb">特征描述</div>
        <textarea class="detail" id="detail1" name="detail1" placeholder="请输入您的特征（如身体特殊特征、有无胎记、胎记位置、穿着等）"></textarea>
    </div>
    <div class="infodet1"  id="infodetail2">
        <a><img src="images/det3.png"></a>
        <div class="lb">其他描述</div>
        <textarea class="detail" id="detail2" name="detail2" placeholder="请输入您走失之前的生活环境、家庭情况等易于记忆的特征"></textarea>
    </div>
</div>
<div id="datePlugin"></div>
<div class="div4 borderstyle">
    <div class="infodet">
        <a><img src="images/tele.png"></a>
        <div class="lb">联系电话</div>
        <input type="text" id="tele" name="tele" class="txt" placeholder="请填写您的联系电话">
    </div>
    <div class="infodet" id="d-email" >
        <a><img src="images/email.png"></a>
        <div class="lb">联系邮箱</div>
        <input type="text" id="email" name="email" class="inputElem" placeholder="请填写您的联系邮箱">
    </div>
</div>
    <div class="div4 borderstyle">
        <div class="infodet">
            <a><img src="images/img1.png"></a>
            <div class="lb1">请选择1张照片</div>
        </div>
        <div id="img_div">
            <img id="img_show" class="img_show"/>
            <div id="show_div"  style="float: left;">
                <div id="img"></div>
            </div>
            <div class="fileinput-button" id="updiv">
                <input type="file" name="uploadfile" id="img_up"/>
            </div>
        </div>
    </div>
    <script src="js/uploadPreview.js"></script>
    <script>
        $(function(){
            new uploadPreview({ UpBtn: "img_up", DivShow: "img_div", ImgShow: "img_show"});
        });
    </script>
    <div class="div5">
        <input type="submit" class="save" value="确认信息并生成卡片">
    </div>
</form>
</body>
</html>
