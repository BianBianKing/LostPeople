<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--志愿者上传照片-->
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
        $(function(){
            $('#endTime').date({theme:"datetime"});
        });
        var ratioval="男";
        function sexchange(a)
        {
            ratioval=a;
        }

        function check(){
            var date=document.getElementById("endTime").value;
            var local=document.getElementById("local").value;
            var tele=document.getElementById("tele").value;
            var imgcount=document.getElementById("img").childElementCount;
            if(date=="")
            {
                alert("请选择发现日期！");
                return false;
            }
           else if(local=="")
            {
                alert("请填写发现详细地址！");
                return false;
            }
           else if(tele=="")
            {
                alert("请填写您的联系方式！");
                return false;
            }
           else if(imgcount==0)
            {
                alert("请选择照片！");
                return false;
            }
            else{
                return true;
            }
        }
        function func(){
            var date=document.getElementById("endTime").value;
            var local=document.getElementById("local").value;
            var tele=document.getElementById("tele").value;
            var imgcount=document.getElementById("img").childElementCount;
            if(date!=""&&local!=""&&tele!=""&&imgcount!=0)
            {
                return true
            }
            else{
                return false;
            }
        }
        function show() {

            var valid=func();
            if(valid==true){
                document.getElementById("loading").style.display = "";
                document.getElementById("info").style.display="none";
            }
        }
    </script>
</head>

<body>
<div class="div1">
    <div class="image"><img src="images/icon.png"></div>
    <div class="optext"><a>铺就回家的路</a></div>
</div>
<form id="form1" enctype="multipart/form-data" action="volunteer.form" method="post" onsubmit="return check()">
    <div id="loading" style="width: 90%;height: 100%;margin:100px auto;text-align: center;display: none;">
        <div>正在努力寻找中，请耐心等待！</div>
        <img src="images/loading.gif" style="margin-top: 50px;">
    </div>
    <div id="info">
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
        <div class="div3 borderstyle">
            <div class="infodet">
                <a><img src="images/cal1.png"></a>
                <div class="lb">发现日期</div>
                <input id="endTime" name="endTime" class="kbtn txt" placeholder="填写发现时间" />
            </div>
            <div class="infodet1">
                <a><img src="images/loc1.png"></a>
                <div class="lb">发现地点</div>
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
            <div class="infodet">
                <a><img src="images/tele.png"></a>
                <div class="lb">联系电话</div>
                <input type="text" id="tele" name="tele" class="txt" placeholder="请填写联系方式" >
            </div>

        </div>
        <div class="div5">
            <input type="submit" class="save" value="确认上传信息" onclick="show()">
        </div>
        <div id="datePlugin"></div>
    </div>
</form>
</body>
<script>

</script>
</html>