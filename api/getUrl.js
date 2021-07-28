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