


var uploadPreview = function(setting) {

    var _self = this;

    _self.IsNull = function(value) {
        if (value == undefined || value == null || value == "" || value.length == 0) {
            return true;
        }
        return false;
    }
    _self.DefautlSetting = {
        UpBtn: "",
        DivShow: "",
        ImgShow: "",
        Width: 60,
        Height: 60,
        ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
        ErrMsg: "选择文件错误,图片类型必须是(gif,jpeg,jpg,bmp,png)中的一种",
        callback: function() { }
    };

    _self.Setting = {
        UpBtn: _self.IsNull(setting.UpBtn) ? _self.DefautlSetting.UpBtn : setting.UpBtn,
        DivShow: _self.IsNull(setting.DivShow) ? _self.DefautlSetting.DivShow : setting.DivShow,
        ImgShow: _self.IsNull(setting.ImgShow) ? _self.DefautlSetting.ImgShow : setting.ImgShow,
        Width: _self.IsNull(setting.Width) ? _self.DefautlSetting.Width : setting.Width,
        Height: _self.IsNull(setting.Height) ? _self.DefautlSetting.Height : setting.Height,
        ImgType: _self.IsNull(setting.ImgType) ? _self.DefautlSetting.ImgType : setting.ImgType,
        ErrMsg: _self.IsNull(setting.ErrMsg) ? _self.DefautlSetting.ErrMsg : setting.ErrMsg,
        callback: _self.IsNull(setting.callback) ? _self.DefautlSetting.callback : setting.callback
    };

    _self.getObjectURL = function(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
            return url;

    }
    _self.Bind = function() {
        document.getElementById(_self.Setting.UpBtn).onchange = function() {
            var showdiv=document.getElementById("show_div");
            var img=document.getElementById("img");
            showdiv.removeChild(img);
            if (this.value) {
                if (!RegExp("\.(" + _self.Setting.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert(_self.Setting.ErrMsg);
                    this.value = "";
                    return false;
                }
                if (navigator.userAgent.indexOf("MSIE") > -1) {
                    try {
                        //var imgdiv=document.getElementById("img_div");
                        var idiv=document.createElement('div');
                        idiv.id="img";
                        //idiv.className="";
                        showdiv.appendChild(idiv);
                        if(_self.getObjectURL(this.files[0])!=null)
                        {
                            var imgshow=document.createElement('img');
                            imgshow.src= _self.getObjectURL(this.files[0]);
                            imgshow.id="img_0";
                            imgshow.className="img_show";
                            idiv.appendChild(imgshow);
                        }
                        /*for(var i=0;i<3;i++)
                        {
                            var idiv=document.createElement('div');
                            idiv.id="idiv_"+i;
                            idiv.className="idiv"
                            imgdiv.appendChild(idiv);
                            if(_self.getObjectURL(this.files[i])!=null)
                            {
                                var imgshow=document.createElement('img');
                                imgshow.src= _self.getObjectURL(this.files[i]);
                                imgshow.id="img_"+i;
                                imgshow.className="img_show";
                                idiv.appendChild(imgshow);
                            }
                        }*/
                    } catch (e) {
                        var div = document.getElementById(_self.Setting.DivShow);
                        this.select();
                        top.parent.document.body.focus();
                        var src = document.selection.createRange().text;
                        document.selection.empty();
                        document.getElementById(_self.Setting.ImgShow).style.display = "none";
                        div.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                        div.style.width = _self.Setting.Width + "px";
                        div.style.height = _self.Setting.Height + "px";
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                    }
                } else {
                        //alert(document.getElementById('"ImgShow"+ i'));
                    /*var imgdiv=document.getElementById("img_div");
                    for(var i=0;i<3;i++)
                    {
                        var idiv=document.createElement('div');
                        idiv.id="idiv_"+i;
                        idiv.className="idiv"
                        imgdiv.appendChild(idiv);
                        if(_self.getObjectURL(this.files[i])!=null)
                        {
                            var imgshow=document.createElement('img');
                            imgshow.src= _self.getObjectURL(this.files[i]);
                            imgshow.id="img_"+i;
                            imgshow.className="img_show";
                            idiv.appendChild(imgshow);
                        }
                        document.getElementById("updiv").style.display="none";
                    }*/
                    //var imgdiv=document.getElementById("img_div");
                    var idiv=document.createElement('div');
                    idiv.id="img";
                    //idiv.className="";
                    showdiv.appendChild(idiv);
                    if(_self.getObjectURL(this.files[0])!=null)
                    {
                        var imgshow=document.createElement('img');
                        imgshow.src= _self.getObjectURL(this.files[0]);
                        imgshow.id="img_0";
                        imgshow.className="img_show";
                        idiv.appendChild(imgshow);
                    }
                }
                _self.Setting.callback();
            }
        }
    }
    _self.Bind();
}