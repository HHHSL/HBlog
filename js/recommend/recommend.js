document.write("<script language=javascript src='../../api/recommend/recommend.js'></script>");
$(function () {
    for(var i = 1;i <= 6; i++ ){
        var code =  "<div class='col animate__animated animate__flipInY'>"+
                    "<div class='card'>"+
                    "<a href='#'>"+
                    "<img src='img/hhhsl.jpg' class='card-img-top'>"+
                    "<div class='card-body'>"+
                    "<h5 class='card-title'>Card title</h5>"+
                    "<p class='card-text'>This is a longer card with supporting</p>"+
                    "<span class='badge bg-secondary'>语言:java</span>"+
                    "</div></a></div></div>"
        $(".r_nr .container .row").append(code)
    }
    a()
});