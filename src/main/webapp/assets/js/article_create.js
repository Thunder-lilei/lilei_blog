let vditor;
$(document).ready(function() {
		let message = GetQueryString('message');
		if(message!=="success" && message!==null)
		{alert(message)}
		
			window.onload = function() {
				vditor = new Vditor('vditor', {
					//图标
					"icon": "material",
					//最低高度
					"minHeight": 500,
					//字数统计
					"counter": {
						"enable": true,
						"type": "text"
					},
					"preview": {
						"hljs": {
							"style": "github",
							"lineNumber": true
						}
					}
				});
			}
})
function func() {
			$('pre code').each(function(i, block) {
				hljs.highlightBlock(block);
			});
			$.getJSON('/lilei_blog/note/getpage',{page:vditor.getHTML(),title:$("#title").val(),introduction:$("#introduction").val(),imagesrc:$("#imagesrc").val()},function(data){
			let message = '';
			$.each(data, function(index,item) {
				if(index=="message")
				{message = item}
			});
			switch(message)
			{
				case "nosigin":
				window.location.href = "login.html";
				break;
				case "success":
				window.location.href = "index.html";
				break;
				default :
				alert(message);
			}
		});
		}
function GetQueryString(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if(r != null) return decodeURI(r[2]);
			return null;
		}