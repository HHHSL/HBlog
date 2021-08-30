document.write("<script language=javascript src='../../api/daily/daily.js'></script>");
$(function () {
    
    if(getdaily() != null && getdaily().status == 200){
        var code =  ''
        var rec = getdaily()
        rec.data.forEach(ele => {
            code += "<div class='card shadow'>" +
            "<div class='card-header'>"+ele.time+"</div>" +
            "<div class='card-body'>" +
            "<blockquote class='blockquote mb-0'>" +
            "<p>"+ele.content+"</p>" +
            "<div class='picture'>" +
            "<a href='"+ele.picture+'/'+ele.picturename+"'><img src='"+ele.picture+'/'+ele.picturename+"' class='ms-1 me-1'></a>" +
            "</div></blockquote></div></div>"
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
    }
    $(".daily .daily_nr").append(code)
});
