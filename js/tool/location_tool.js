// 滑动高度
function scrollheighe(){
    return parseInt($(window).scrollTop()) 
}
// 获取元素位置
function elementlocation(element){
    return parseInt($(element).offset().top)
}
// 获取元素高度
function elementheight(element){
    return $(element).height()
}
// 获取窗口高度
function windowheight(){
    return $(window).height()
}
// 获取窗口宽度
function windowwidth(){
     return $(window).width()
 }
// 元素中部定位
function elementposition(element){
    return parseInt(elementlocation(element)+elementheight(element)/2)
}
//判断元素是否在中部
function b_element(element){
    return scrollheighe() > elementlocation(element)-windowheight()*0.2 && scrollheighe() < elementlocation(element)+windowheight()*0.1
}