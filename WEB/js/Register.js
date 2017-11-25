function doRegister(){
    console.log(1);
    if(($("#RegisterID").val() != "") && ($("#RegisterPW").val() == $("#RegisterPWChk").val()) && ($("#Regi+sterPW").val() != "") && ($("#RegisterPWChk").val() !="")){
        alert("1");
        $.ajax({
            url : "account/register",
            type : "POST",
            data : {
                id : $("#RegisterID").val(),
                password : $("#RegisterPW").val(),
            },
            success : function(data, status){
                alert("회원가입에 성공하셨습니다 !");
                location.href="./Login.html";
            },
            error : function(xhr){
                alert("회원가입에 실패하셨습니다 ㅠ_ㅠ");
                location.reload();
            }
        });  
    }
    else if($("#RegisterID").val() == "")
    {
        alert("아이디를 입력해주세요.");
    }
    else if($("#RegisterPW").val() == "")
    {
        alert("비밀번호를 입력해주세요.");
    }
    else if($("#RegisterPWChk").val() == "")
    {
        alert("비밀번호 확인 창을 입력해주세요.");
    }
    else if($("#RegisterPW").val() != $("#RegisterPWChk").val()){
        alert("비밀번호 확인이 되지않았습니다.");
    }
    
}
$("#RegisterSubmit").on("click",function(){
    doRegister();
})
