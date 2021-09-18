document.write("<script language=javascript src='../../api/daily/daily.js'></script>");
$(function () {
    InitializedData()
    $("#determine").click(function(){
        var str = $(".Tips").html()
        if(str == '新增'){
            add()
        }else{
            up()
        }
    })

    $("#add").click(function(){
        $("#content").val("")
        $("#file").val(null)
        $(".Tips").html('新增')
    })

});

// 初始数据
function InitializedData() {
    $(".nr_tbody").empty()
    var rec = getdaily()
    if(rec != null && rec.status == 200){
        var code =  ''
        rec.data.forEach(ele => {
            code +="<tr><th scope='row'>"+ele.id+"</th>"+
            "<td><strong>"+ele.content+"</strong></td>"+
            "<td>"+ele.time+"</td>"+
            "<td>"+
            "<button type='button' class='btn btn-outline-success btn-sm m-1' onclick='selbyid("+ele.id+")' data-bs-toggle='modal' data-bs-target='#staticBackdrop'>修改</button>"+
            "<button type='button' class='btn btn-outline-danger btn-sm m-1' onclick='del("+ele.id+")'>删除</button></tr>"
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

//添加
function add(){
    var formData = new FormData();
    formData.append("file",$("#imgFile")[0].files[0]);
    formData.append("content",$("#content").val());
    Adddaily(formData)
}

//修改
function up(){
    var formData = new FormData();
    formData.append("file",$("#imgFile")[0].files[0]);
    formData.append("id",$("#id").val());
    formData.append("content",$("#content").val());
    if(Updaily(formData).status == 200){
        InitializedData()
    }
}

// 删除
function del(id){
    if(deldaily(id).status == 200){
        InitializedData()
    }
}

//查询
function selbyid(id){
    $(".Tips").html('修改')
    var rec = seldailybyidc(id)
    if(rec.status == 200){
        $("#id").val(rec.data.id)
        $("#content").val(rec.data.content)
    }
}
