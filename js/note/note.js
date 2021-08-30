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
    }
    $(".node .node_nr .row").append(code)
});