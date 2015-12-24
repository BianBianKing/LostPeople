<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--家属登记走失者信息-->
<!DOCTYPE html>
<html>
<head>
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
        function selectfunc(){
            var val=document.getElementById("selecttype").value;
            if(val=="1")
            {
                document.getElementById("infodetail2").style.display="";
            }
            if(val=="0")
            {
                document.getElementById("infodetail2").style.display="none";
            }
        }
        $(function(){
            $('#endTime').date({theme:"datetime"});
        });
    </script>
</head>
<body>
<form enctype="multipart/form-data" action="lost.form" method="post">
    <div class="div1">
        <div class="image"><img src="images/icon2.png"></div>
        <div class="optext"><a>等你回家信息登记</a></div>
    </div>
    <div class="div2 borderstyle">
        <a><img src="images/time.png"></a>
        <div class="lab">走失时长</div>
        <select id="selecttype" name="selecttype" class="selectbox" onclick="selectfunc()">
            <option value="0" selected>即时</option>
            <option value="1">非即时</option>
        </select>
    </div>
    <div class="div3 borderstyle">
        <div class="infodet">
            <a><img src="images/name1.png"></a>
            <div class="lb">姓名</div>
            <input type="text" id="name" name="name" class="txt" placeholder="填写走失者姓名" >
        </div>
        <div class="infodet">
            <a><img src="images/age.png"></a>
            <div class="lb">年龄</div>
            <input type="text" id="age" name="age" class="txt" placeholder="请填写年龄">
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
        <div class="infodet">
            <a><img src="images/loc1.png"></a>
            <div class="lb">走失地点</div>
            <input type="text" id="locatxt" name="locatxt" class="txt" placeholder="填写走失地点"/>
        </div>
        <div class="infodet1">
            <a><img src="images/det1.png"></a>
            <div class="lb">特征描述</div>
            <textarea class="detail" id="detail1" name="detail1" placeholder="请输入走失者特征（如身体特殊特征、有无胎记、胎记位置、穿着等）"></textarea>
        </div>
        <div class="infodet1"style="display: none;" id="infodetail2">
            <a><img src="images/det3.png"></a>
            <div class="lb">其他描述</div>
            <textarea class="detail" id="detail2" name="detail2" placeholder="请输入走失者走失之前的生活环境、家庭情况等易于记忆的特征"></textarea>
        </div>
    </div>
    <div id="datePlugin"></div>
    <div class="div4 borderstyle">
        <div class="infodet">
            <a><img src="images/tele.png"></a>
            <div class="lb">联系电话</div>
            <input type="text" id="tele" name="tele" class="txt" placeholder="请填写家属联系电话" onblur="checktele()">
        </div>
        <div class="infodet" id="d-email">
            <a><img src="images/email.png"></a>
            <div class="lb">联系邮箱</div>
            <input type="text" id="email" name="email" class="inputElem" placeholder="请填写家属联系邮箱">
        </div>
    </div>
    <div class="div4 borderstyle">
        <div class="infodet">
            <a><img src="images/img1.png"></a>
            <div class="lb1">请选择照片，最多3张</div>
        </div>
        <div id="img_div">
            <img id="img_show" class="img_show"/>
			<div class="fileinput-button" id="updiv">
				<input type="file" name="uploadfile" id="img_up" multiple="multiple"/>
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
