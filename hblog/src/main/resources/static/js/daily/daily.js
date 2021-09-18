document.write("<script language=javascript src='../../api/daily/daily.js'></script>");
$(function () {
    if(getdaily() != null && getdaily().status == 200){
        var code =  ''
        var rec = getdaily()
        rec.data.forEach(ele => {
            var imgcode = ''
            if(ele.pictureaddress != null){
                ele.pictureaddress.split(',').forEach(ela => {
                    imgcode+= "<a href='"+ela+"' download=\"\"><img src='"+ela+"' class='ms-1 me-1'></a>"
                });
            }else{
                imgcode = ''
            }
            code += "<div class='card shadow'>" +
            "<div class='card-header'>"+ele.time+"</div>" +
            "<div class='card-body'>" +
            "<blockquote class='blockquote mb-0'>" +
            "<p>"+ele.content+"</p>" +
            "<div class='picture'>" +imgcode+"</div></blockquote></div></div>"
        });
    }else{
        code = "<div class='card shadow'>" +
        "<div class='card-header'></div>" +
        "<div class='card-body'>" +
        "<blockquote class='blockquote mb-0'>" +
        "<p>数据未找到</p>" +
        "<div class='picture'>" +
        "<a href=''><img src='img/null.jpg' class='ms-1 me-1'></a>" +
        "<a href=''><img src='img/null.jpg' class='ms-1 me-1'></a>" +
        "<a href=''><img src='img/null.jpg' class='ms-1 me-1'></a>" +
        "</div></blockquote></div></div>"
        var prompt = "<div id='prompt' class='text-center alert alert-danger alert-dismissible fade show position-absolute top-50 start-50 translate-middle' role='alert'>"+
        "<strong>Sorry</strong> 服务器出错,请联系管理员"+
        "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>"
        $(".daily").append(prompt)
    }
    $(".daily .daily_nr").append(code)
    setTimeout(function (){
        $("#prompt").remove()
    }, 3000);
});
