document.write("<script language=javascript src='../api/getAddress.js'></script>");
// 查询推荐文章列表
function getrecommend(){
   var result;
   $.ajax({
      async:false,
      url: getUrl()+'/api/recommend/sel',
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
}

// 添加文章
function Addrec(data){
  var result;
  $.ajax({
     async:false,
     url: getUrl()+'/api/recommend/add',
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
// 修改文章
function Uprec(data){
    var result;
    $.ajax({
       async:false,
       url: getUrl()+'/api/recommend/up',
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
function delrec(data){
   var result;
   $.ajax({
      async:false,
      url: getUrl()+'/api/recommend/del/'+data,
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
 }
//  根据id获取文章
 function selrecbyidc(data){
   var result;
   $.ajax({
      async:false,
      url: getUrl()+'/api/recommend/sel/'+data,
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
 }
