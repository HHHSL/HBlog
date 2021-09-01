document.write("<script language=javascript src='../api/getAddress.js'></script>");
// 查询日常列表
function getdaily(){
   var result;
   $.ajax({
      async:false,
      url: getUrl()+'/api/daily/sel',
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
}