document.write("<script language=javascript src='../api/getAddress.js'></script>");
// 查询笔记列表
function getnote(){
   var result;
   $.ajax({
      url: getUrl()+'/api/note/sel',
      type:'get',
      success:function (callback) {
          result = callback
      }
  });
  return result
}

// // 添加笔记
// function Addnote(data){
//     var result;
//     $.ajax({
//        async:false,
//        url: getUrl()+'/api/note/add',
//        type:'post',
//        cache: false, 
//        processData: false,
//        contentType: false,
//        data: data,
//        success:function (callback) {
//            result = callback
//        }
//    });
//    return result
//   }
//   //  根据id获取文章
//  function selnotebyidc(data){
//     var result;
//     $.ajax({
//        async:false,
//        url: getUrl()+'/api/note/sel/'+data,
//        type:'get',
//        success:function (callback) {
//            result = callback
//        }
//    });
//    return result
//   }
//   // 修改文章
// function Upnote(data){
//     var result;
//     $.ajax({
//        async:false,
//        url: getUrl()+'/api/note/up',
//        type:'post',
//        cache: false, 
//        processData: false,
//        contentType: false,
//        data: data,
//        success:function (callback) {
//            result = callback
//        }
//    });
//    return result
//   }
//   // 删除文章
// function delnote(data){
//     var result;
//     $.ajax({
//        async:false,
//        url: getUrl()+'/api/note/del/'+data,
//        type:'get',
//        success:function (callback) {
//            result = callback
//        }
//    });
//    return result
//   }