$(function(){
	$(".inputBox").click(function(){
		$(".invitation-container").addClass("selected");
	});
	
	$(".invitation-container .bg").click(function(){
		$(".invitation-container").removeClass("selected");
	});
	
	$(".submit-btn").click(saveEvent);
});


function saveEvent(){
	if($("[name=vNAME]").val()==""){
		lAlert({message:"请输入正确的名字！"});
		return;
	}
	if($("[name=vWEIXIN]").val()==""){
		lAlert({message:"请输入微信！"});
		return;
	}
	if($("[name=vPHONE]").val()==""||!/^[0-9]{11}$/.test($("[name=vPHONE]").val())){
		lAlert({message:"请输入正确的手机号码！"});
		return;
	}
	if($("[name=vAREA]").val()==""){
		lAlert({message:"请输入区域！"});
		return;
	}
	$(".submit-btn").unbind("click");
	lLoading("show",{message:"正在加载"});
	$.post("api/invitationHandler.jsp",$("#invitation-form").serialize(),function(r){
		lLoading("hide");
		console.log(r);
		if(r.indexOf("操作成功")>=0){
			$(".app-content").hide();
			$("#name").text($("[name=vNAME]").val());
			$("#weixin").text($("[name=vWEIXIN]").val());
			$(".success-container").show();
		}else if(r.indexOf("该号码已报名")>=0){
			lAlert({message:"该号码已报名！"});
			$(".submit-btn").bind("click",saveEvent);
		}
		
	});
}
