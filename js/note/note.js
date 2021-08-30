document.write("<script language=javascript src='../../api/note/note.js'></script>");
$(function () {
    
    if(getnote() != null && getnote().status == 200){
        var rec = getnote()
        var code =  ''
        rec.data.forEach(ele => {
            code +=  "<div class='col'>"+
            "<div class='card shadow'>"+
            "<img src='"+ele.picture+'/'+ele.picturename+"' class='card-img-top'>"+
            "<div class='card-body'>"+
            "<p class='card-text'>"+ele.title+"</p>"+
            "</div></div></div>"
        });
    }else{
        code =  "<div class='col'>"+
        "<div class='card shadow'>"+
        "<img src='img/null.jpg' class='card-img-top' style='height:100%;'>"+
        "</div></div>"
        var prompt = "<div id='prompt' class='text-center alert alert-danger alert-dismissible fade show position-absolute top-50 start-50 translate-middle' role='alert'>"+
        "<strong>Sorry</strong> 服务器出错,请联系管理员"+
        "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>"
        $(".node").append(prompt)
    }
    $(".node .node_nr .row").append(code)
    setTimeout(function (){
        $("#prompt").remove()
    }, 3000);
});