$(function () {
    for(var i = 1;i <= 6; i++ ){
        var code =  "<div class='col'>"+
                    "<div class='card shadow'>"+
                    "<img src='img/hhhsl.jpg' class='card-img-top'>"+
                    "<div class='card-body'>"+
                    "<p class='card-text'>Some quick example text to build on the card</p>"+
                    "</div></div></div>"
        $(".node .node_nr .row").append(code)
    }
    console.log("getUrl()"+getUrl())        
});