// 查询日常列表
function getdaily(){
   var result;
   $.ajax({
      url: '/api/daily/sel',
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
}

// 添加笔记
function Adddaily(data){
    var result;
    $.ajax({
       async:false,
       url: '/api/daily/add',
       type:'post',
       cache: false, 
       processData: false,
       contentType: false,
       data: data,
       success:function (callback) {
           result = callback
       }
   });
   return result
  }
  //  根据id获取文章
 function seldailybyidc(data){
    var result;
    $.ajax({
       async:false,
       url: '/api/daily/sel/'+data,
       type:'get',
       success:function (callback) {
           result = callback
       }
   });
   return result
  }
  // 修改文章
function Updaily(data){
    var result;
    $.ajax({
       async:false,
       url: '/api/daily/up',
       type:'post',
       cache: false, 
       processData: false,
       contentType: false,
       data: data,
       success:function (callback) {
           result = callback
       }
   });
   return result
  }
  // 删除文章
function deldaily(data){
    var result;
    $.ajax({
       async:false,
       url: '/api/daily/del/'+data,
       type:'get',
       success:function (callback) {
           result = callback
       }
   });
   return result
  }