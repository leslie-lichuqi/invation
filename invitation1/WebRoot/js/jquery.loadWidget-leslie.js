(function($){
	
	function init(type,params,el){
		opt={
			title:'信息提示',
			message:'',
			btn:'确定',
			calback:null,
			time:1000,
			src:null
		}
		$.extend(opt, params);
		switch (type){
			case 'alert':
				$("body").append('<div id="alertDiv" ><div class="wrap"><p class="alertTitle">'+opt.title+'</p><p class="alertContent">'+opt.message+'</p><p class="alertBtn">'+opt.btn+'</p></div></div>');
				$("#alertDiv").find(".alertBtn").click(function(){
					$("#alertDiv").remove();
					if(opt.calback){
						opt.calback();
					};
				});
				break;
			case 'load':
				var src = opt.src ==null?"http://www.yuwangtianxia.com:9099/ywtx/res/css/img/n_loading.gif":opt.src;
				$("body").append('<div id="loadingDiv" ><img src="'+src+'"/><p>'+opt.message+'</p></div>');
				break;
			case 'confirm':	
				$("body").append('<div id="alertDiv" ><div class="wrap"><p class="alertTitle">'+opt.title+'</p><p class="alertContent">'+opt.message+'</p><div><p class="confirmBtn">确定</p><p class="cancelBtn">取消</p><div style="clear:both"></div></div></div></div>');
				$("#alertDiv").find(".confirmBtn").click(function(){
					$("#alertDiv").remove();
					if(opt.calback){
						opt.calback(true);
					}
				});
				$("#alertDiv").find(".cancelBtn").click(function(){
					$("#alertDiv").remove();
					if(opt.calback){
						opt.calback(false);
					}
				});
				break;
			case 'message':
				$("body").append('<div id="messageDiv" ><p>'+opt.message+'</p></div>');
				self.setTimeout(function(){
					$("#messageDiv").remove();
					if(opt.calback){
						opt.calback();
					}
				},opt.time);
				break;
			case 'loading':
				var src = opt.src ==null?"http://www.yuwangtianxia.com:9099/ywtx/res/css/img/n_loading.gif":opt.src;
				$img = $("<img>",{"src":src,"style":"position: relative;top: 5px;left: -20px;"});
				el.empty();
				el.css({"padding": "20px 0","font-size": "24px","color": "#808080","text-align": "center"}).text(opt.message).prepend($img);
				break;
			default:
				break;
		}
		
	}
	
	
	$.fn.loadWidget = function(action,params){
		if(action=='init'){
			init('loading',$.extend({'message':"正在加载"},params),this);
		}else if(action=='hide'){
			this.hide();
		}else if(action=='show'){
			this.show();
		}
	};
	
	lAlert = function(params,calback){
		init('alert',$.extend(params,{'calback':calback}));
	}
	
	lLoading = function(action,params){
		if(action=='show'){
			init('load',$.extend({'message':"正在加载"},params));
		}else if(action=='hide'){
			$("#loadingDiv").remove();
		}
	}
	
	lConfirm = function(params,calback){
		init('confirm',$.extend(params,{'calback':calback}));
	}
	
	lMessage = function(params,time,calback){
		init('message',$.extend($.extend({'message':"正在加载"},params),{'time':time,'calback':calback}));
	}
})(jQuery);