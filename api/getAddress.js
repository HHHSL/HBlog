function getUrl(){
    var result;
    $.ajax({
        async:false,    // 这个需要写上
        url:"../api/address.json",
        type:'get',
        dataType:'json',
        success:function (callback) {
            result = callback.url;   // 赋值给刚才定义的值
        }
    });
   return result    
}