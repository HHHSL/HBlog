// function getUrl() {//获取发送给后台的地址
//     var result = ''
//     $.ajax({
//         url : 'api/address.json',
//         type : "get",
//         async : false,
//         success : function(data) {
//             result = data.url
//             return result;
//         }
//     });
//     return result
// }
function getUrl() {
    var result = ''
    $.ajax({
        url : 'api/address.json',
        type : "get",
        async : false,
        success : function(data) {
            result = data.url
            return result;
        }
    });
    return result
}
