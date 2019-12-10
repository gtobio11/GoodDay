var date = new Date();

var dateYear = date.getFullYear();
var dateMonth = date.getMonth() + 1;
var dateDate = date.getDate();

$("#HWInputDeadline").append("<input type = 'date' id='HWDeadline' value='"+dateYear + "-" + dateMonth + "-" + dateDate + "' name='date'>");

$("#HWFade").on("click",function(){
    $("#HWUploadWindow").toggleClass("fade-out");
    $("#HWUploadWindow").toggleClass("fade-in")
})
$("#HWFade-out").on("click",function(){
    $("#HWUploadWindow").toggleClass("fade-out");
})

$("form#HWUploadForm").submit(function(event){
    event.preventDefault();
    
    var formData = new FormData($(this)[0]);

    $.ajax({
        type : "POST",
        url : "/homework",
        data : formData,
        contentType : false,
        processData : false,
        success : function(){
            $("HWUploadWindow").toggleClass("fade-out");
        },
        error : function(){
            alert("과제 업로드에 실패하였습니다.");
        }
    })
})

function getHWList(){
    $.ajax({
        url : "/homework",
        type : "GET",
        success : function(data){
            var parsedData = JSON.parse(data).result;
            parsedData.foreach(function(data){
                makeHWList(data,$('#HWList'));
            });
        }
    });
}
function makeHWList(data, target){
    if(data.hurry>=4){
        var newCard = $('<div/>',{
            "class" : "HWListLoad " + "HWListHurry"
        });
    }
    else if(data.hurry<=3){
        var newCard = $('<div/>',{
            "class" : "HWListLoad " + "HWListNotHurry"
        });
    }
    newCard.append($('<div/>',{
        "class" : "HWListTitle",
        text : data.title
    }));
    newCard.append($('<div/>',{
        "class" : "HWListContent",
        text : data.content
    }));
    newCard.append($('<div/>',{
        "class" : "HWListDeadline",
        text : "마감일 " + data.deadline
    }));
    newCard.on('click',function(){
        $("#HWPopUp").toggleClass("fade-out");
        $("#HWPopUp").toggleClass("fade-in");
        var HWBtnGroup = "<a href='/download/" + data.Filenum + "' class='HWDownloadBtn'>지금 할래~</a>";
        var HWTitle;
        if(data.hurry == 1){
            HWTitle = "<span id='HWPopUpDetailTitle'>아직은 여유로워~</span>";
            HWBtnGroup = "<a href='/download/" + data.Filenum + "' class='HWDownloadBtn2'>지금 할래~</a><button id='HWPopUpClose'>응 아니야~</button>";
        }
        else if(data.hurry == 2){
            HWTitle = "<span id='HWPopUpDetailTitle'>내일 해도 될거같아~</span>";
            HWBtnGroup = "<a href='/download/" + data.Filenum + "' class='HWDownloadBtn2'>지금 할래~</a><button id='HWPopUpClose'>응 아니야~</button>";
        }
        else if(data.hurry == 3){
            HWTitle = "<span id='HWPopUpDetailTitle'>오늘 하는게 좋을것 같아~</span>";
            HWBtnGroup = "<a href='/download/" + data.Filenum + "' class='HWDownloadBtn2'>지금 할래~</a><button id='HWPopUpClose'>응 아니야~</button>";
        }
        else if(data.hurry == 4){
            HWTitle = "<span id='HWPopUpDetailTitle'>오늘 무조건 해야되 !</span>";
        }
        else if(data.hurry == 5){
            HWTitle = "<span id='HWPopUpDetailTitle'>창밖으로 떨어져 ~</span>"
        }
        $("#HWPopUpTitle").append(HWTitle);
        $("#HWPopUpAcc").append(HWBtnGroup);
    })
    $("#HWList").append(newCard);
}
$("#HWPopUpClose").on("click",function(){
    $("#HWPopUp").toggleClass("fade-out");
    $("#HWPopUp").toggleClass("fade-in");
});
