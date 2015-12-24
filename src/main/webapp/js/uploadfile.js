jQuery(function () {
    var $ = jQuery,
    //图片缩略图容器
        $list = $('#fileList'),
        $selectimg= $('#selectfile'),
    //缩略图压缩程度
    // ratio = window.devicePixelRatio || 1,
    //缩略图大小
        thumbnailWidth = 80,
        thumbnailHeight = 80,
    //Web Uploader实例
        uploader;
    uploader = WebUploader.create({
        //自动上传。
        auto: false,
        pick: '#filePicker',
        //单次上传最多图片数
        fileNumLimit: 3,
        //允许选择的图片格式
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    // 当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
        //创建新添加图片
        var $li = $(
                    '<div id="' + file.id + '" class="file-item">' +
                    '<img>' +
                    '</div>'
            ),

            $img = $li.find('img');
        //将新添加图片放入缩略图容器
        $list.append($li);
        // 创建缩略图
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }
            $img.attr('src', src);
        }, thumbnailWidth, thumbnailHeight);
        //选择文件的按钮消失
        $selectimg.css('display','none');
    });

});