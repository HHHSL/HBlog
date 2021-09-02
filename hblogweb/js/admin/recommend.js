document.write("<script language=javascript src='../../api/recommend/recommend.js'></script>");
$(function () {
    $("#add").click(function(){
        console.log("aasadasd")
    })
    console.log(getrecommend())
    InitializedData()
});

// 初始数据
function InitializedData() {
    if(getrecommend() != null && getrecommend().status == 200){
        var rec = getrecommend()
        var code =  ''
        rec.data.forEach(ele => {
            code +="<tr><th scope='row'>"+ele.id+"</th>"+
            "<td><strong>"+ele.title+"</strong></td>"+
            "<td>"+ele.introduce+"</td>"+
            "<td>"+ele.address+"</td>"+
            "<td>"+ele.language+"</td><td>"+
            "<button type='button' class='btn btn-outline-success btn-sm m-1'>修改</button>"+
            "<button type='button' class='btn btn-outline-danger btn-sm m-1'>删除</button></tr>"
        });
    }else{
        code +="<tr><th scope='row'>null</th>"+
            "<td>null</td>"+
            "<td>null</td>"+
            "<td>null</td>"+
            "<td>null</td><td>"+
            "<button type='button' class='btn btn-outline-success btn-sm m-1'>修改</button>"+
            "<button type='button' class='btn btn-outline-danger btn-sm m-1'>删除</button></tr>"
        
        var prompt = "<div id='prompt' class='text-center alert alert-danger alert-dismissible fade show position-absolute top-50 start-50 translate-middle' role='alert'>"+
        "<strong>Sorry</strong> 服务器出错,请联系管理员"+
        "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>"
        $(".admin_rec").append(prompt)
    }
    $(".nr_tbody").append(code)
    setTimeout(function (){
        $("#prompt").remove()
    }, 3000);
}
