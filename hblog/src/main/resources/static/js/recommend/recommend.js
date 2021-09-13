document.write("<script language=javascript src='../../api/recommend/recommend.js'></script>");
$(function () {
    InitializedData()
});

// 初始数据
function InitializedData() {
    if(getrecommend() != null && getrecommend().status == 200){
        var rec = getrecommend()
        var code =  ''
        rec.data.forEach(ele => {
            code +=  "<div class='col animate__animated animate__flipInY'>"+
            "<div class='card'>"+
            "<a href='"+ele.address+"'>"+
            "<img src='"+ele.pictureaddress+"' class='card-img-top'>"+
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
        
        var prompt = "<div id='prompt' class='text-center alert alert-danger alert-dismissible fade show position-absolute top-50 start-50 translate-middle' role='alert'>"+
        "<strong>Sorry</strong> 服务器出错,请联系管理员"+
        "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>"
        $(".r_nr").append(prompt)
    }
    $(".r_nr .container .row").append(code)
    setTimeout(function (){
        $("#prompt").remove()
    }, 3000);
}