$(function(){
  $(document).scroll(function() {
    if(scrollheighe() >= elementposition(".home1") && scrollheighe() <= elementposition(".home2")){
      $(".home2").css("opacity","1")
      $(".home2 img").addClass("shadow animate__animated animate__backInLeft")
    }else if(b_element(".home3")){
      $(".home3").css("opacity","1")
    }else if(b_element(".home4")){
      $(".home4").css("opacity","1")
    }else{
      $(".home2").css("opacity","0")
      $(".home3").css("opacity","0")
    }
  });
  $(window).scrollTop(0)
});
