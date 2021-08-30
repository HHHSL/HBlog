document.write("<script language=javascript src='../../api/recommend/recommend.js'></script>");
$(function () {
    if(getrecommend() != null && getrecommend().status == 200){
        var rec = getrecommend()
        var code =  ''
        rec.data.forEach(ele => {
            code +=  "<div class='col animate__animated animate__flipInY'>"+
            "<div class='card'>"+
            "<a href='"+ele.address+"'>"+
            "<img src='"+ele.picture+'/'+ele.picturename+"' class='card-img-top'>"+
            "<div class='card-body'>"+
            "<h5 class='card-title'>"+ele.title+"</h5>"+
            "<p class='card-text'>"+ele.introduce+"</p>"+
            "<span class='badge bg-secondary'>语言:"+ele.language+"</span>"+
            "</div></a></div></div>"
        });
    }else{
        code =  "<div class='col animate__animated animate__flipInY'>"+
        "<div class='card'>"+
        "<a href='#'>"+
        "<img src='img/null.jpg' class='card-img-top'style='height:100%;'> "+
        "</a></div></div>"
    }
    $(".r_nr .container .row").append(code)
});