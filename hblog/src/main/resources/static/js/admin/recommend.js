document.write("<script language=javascript src='../../api/recommend/recommend.js'></script>");
$(function () {
    // 初始化表格
    InitializedData()
    // 新增或添加数据
    $("#determine").click(function(){
        var str = $(".Tips").html()
        if(str == '新增'){
            add()
            empty()
        }else{
            up()
        }
    })
    $("#add").click(function(){
        $(".Tips").html('新增')
    })



});

// 初始数据
function InitializedData() {
    $(".nr_tbody").empty()
    if(getrecommend() != null && getrecommend().status == 200){
        var rec = getrecommend()
        var code =  ''
        rec.data.forEach(ele => {
            code +="<tr><th scope='row'>"+ele.id+"</th>"+
            "<td><strong>"+ele.title+"</strong></td>"+
            "<td>"+ele.introduce+"</td>"+
            "<td>"+ele.address+"</td>"+
            "<td>"+ele.language+"</td><td>"+
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
    if($("#title").val() == "" || $("#introduce").val() =="" || $("#address").val() =="" || $("#language").val() ==""){
        console.log("添加数据")
    }else{
        var formData = new FormData();
        formData.append("file",$("#imgFile")[0].files[0]);
        formData.append("title",$("#title").val()); 
        formData.append("introduce",$("#introduce").val()); 
        formData.append("address",$("#address").val()); 
        formData.append("language",$("#language").val());
        Addrec(formData)
    }
}

//修改
function up(){
    var formData = new FormData();
    formData.append("id",$("#id").val());
    formData.append("title",$("#title").val()); 
    formData.append("introduce",$("#introduce").val()); 
    formData.append("address",$("#address").val()); 
    formData.append("language",$("#language").val()); 
    if(Uprec(formData).status == 200){
        InitializedData()
    }
}

// 删除
function del(id){
    if(delrec(id).status == 200){
        InitializedData()
    }
}

//查询 
function selbyid(id){
    $(".Tips").html('修改')
    var rec = selrecbyidc(id)
    if(rec.status == 200){
        $("#id").val(rec.data.id)
        $("#title").val(rec.data.title)
        $("#introduce").val(rec.data.introduce)
        $("#address").val(rec.data.address)
        $("#language").val(rec.data.language)
    }
        
    
}

// 清空数据
function empty(){
    $("#title").val("")
    $("#introduce").val("")
    $("#address").val("")
    $("#language").val("")
}