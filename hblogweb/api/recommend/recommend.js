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