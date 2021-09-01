document.write("<script language=javascript src='../api/getAddress.js'></script>");
// 查询笔记列表
function getnote(){
   var result;
   $.ajax({
      async:false,
      url: getUrl()+'/api/note/sel',
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
}