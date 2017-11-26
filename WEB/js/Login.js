function doLogin(){
    console.log(1);
    $.ajax({
        url : "/account/login",
        type : "POST",
        data : {
            id : $('#LoginID').val(),
            pw : $('#LoginPW').val()
        },
        success : function(data, status){
            location.href = "./index.html";
        },
        error : function(xhr) {
            alert("로그인에 실패했습니다.");
            location.reload();
        }
    });
}
$("#LoginSubmit").on('click',function(){
    doLogin();
});
$("#GoRegister").on('click',function(){
    location.href="./Register.html";
})
$("#LoginPW").keydown(function(key) {
    if(key.keyCode == 13){
        doLogin();
    }
})