$(function () {
    for (var i = 1; i <= 4; i++) {
        var code = "<div class='card shadow'>" +
            "<div class='card-header'>06-07</div>" +
            "<div class='card-body'>" +
            "<blockquote class='blockquote mb-0'>" +
            "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>" +
            "<div class='picture'>" +
            "<a href=''><img src='img/hhhsl.jpg' class='ms-1 me-1'></a>" +
            "<a href=''><img src='img/hhhsl.jpg' class='ms-1 me-1'></a>" +
            "<a href=''><img src='img/hhhsl.jpg' class='ms-1 me-1'></a>" +
            "<a href=''><img src='img/hhhsl.jpg' class='ms-1 me-1'></a>" +
            "<a href=''><img src='img/hhhsl.jpg' class='ms-1 me-1'></a>" +
            "<a href=''><img src='img/hhhsl.jpg' class='ms-1 me-1'></a>" +
            "</div></blockquote></div></div>"
        $(".daily .daily_nr").append(code)
    }
    console.log("getUrl()" + getUrl())
});