document.writeln("<nav class=\'navbar navbar-expand-lg navbar-light bg-light sticky-top\'>");
document.writeln("        <div class=\'container\'>");
document.writeln("            <a class=\'navbar-brand\' href=\'index.html\'>HHHSL</a>");
document.writeln("            <button class=\'navbar-toggler\' type=\'button\' data-bs-toggle=\'collapse\'");
document.writeln("                data-bs-target=\'#navbarSupportedContent\' aria-controls=\'navbarSupportedContent\' aria-expanded=\'false\'");
document.writeln("                aria-label=\'Toggle navigation\'>");
document.writeln("                <span class=\'navbar-toggler-icon\'></span>");
document.writeln("            </button>");
document.writeln("            <div class=\'collapse navbar-collapse\' id=\'navbarSupportedContent\'>");
document.writeln("                <ul class=\'navbar-nav me-auto mb-2 mb-lg-0\'>");
document.writeln("                    <li class=\'nav-item\'>");
document.writeln("                        <a class=\'nav-link active\' aria-current=\'page\' href=\'index.html\'>Home</a>");
document.writeln("                    </li>");
document.writeln("                    <li class=\'nav-item\'>");
document.writeln("                        <a class=\'nav-link\' href=\'recommend.html\'>推荐</a>");
document.writeln("                    </li>");
document.writeln("                    <li class=\'nav-item\'>");
document.writeln("                        <a class=\'nav-link \' href=\'note.html\' tabindex=\'-1\' aria-disabled=\'true\'>笔记</a>");
document.writeln("                    </li>");
document.writeln("                    <li class=\'nav-item\'>");
document.writeln("                        <a class=\'nav-link \' href=\'daily.html\' tabindex=\'-1\' aria-disabled=\'true\'>日常</a>");
document.writeln("                    </li>");
document.writeln("                </ul>");
document.writeln("                <form class=\'d-flex\'>");
document.writeln("                    <input class=\'form-control me-2\' type=\'search\' placeholder=\'搜一搜\' aria-label=\'搜一搜\' id=\'finput\'>");
document.writeln("                    <button class=\'btn btn-outline-dark\' type=\'submit\' style=\'width: 68px;\'>Go</button>");
document.writeln("                </form>");
document.writeln("            </div>");
document.writeln("        </div>");
document.writeln("    </nav>");
$(function(){
    // 导航栏输入框获得焦点
    $("#finput").focus(function(){
      $("#finput").css("border-color","rgb(118, 118, 118)");
      $("#finput").css("box-shadow","0 0 0 0.1rem rgb(118, 118, 118)");
    });
    // 导航栏输入框失去焦点时触发
    $("#finput").blur(function(){
      $("#finput").css("border-color","black");
      $("#finput").css("box-shadow","0 0 0 0 rgba(0,0,0,.3)");
      $("#finput").css("border","1px solid #ced4da");
    });
})