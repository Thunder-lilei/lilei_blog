$(document).ready(function() {
		let message = GetQueryString('message');
		if(message!=="success" && message!==null)
		{alert(message)}
		
		let id = GetQueryString("id");
		getnote(id);
		
})

function getnote(id)
{
	$.getJSON('/lilei_blog/note/getnote',{id:id},function(data){
			let note = '';
			let message = '';
			$.each(data, function(index,item) {
				if(index=="message")
				{message = item}
				if(index=="note")
				{note = JSON.stringify(item)}
			});
			if(message!=="success" && message!=null)
			{alert(message)}
			
//			alert(note)
			let noteid = "";
			let title = "";
			let time = "";
			let introduction = "";
			let author = "";
			let content = "";
			$.each($.parseJSON(note), function(index, item) {
				if(index == "noteid")
				{noteid = item;}
				if(index == "title")
				{title = item;}
				if(index == "time")
				{time = formatDate(new Date(item));}
				if(index == "introduction")
				{introduction = item;}
				if(index == "author")
				{author = item;}
				if(index == "content")
				{content = item;}
			});
			alert(noteid+title+time+introduction+author+content)
		});
}

function GetQueryString(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if(r != null) return decodeURI(r[2]);
			return null;
		}

function formatDate(now) {
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	if(month<=9){
		month="0"+month+"";
	}
	var date = now.getDate();
	if(date<=9){
		date="0"+date+"";
	}
	var hour = now.getHours();
	if(hour<=9){
		hour="0"+hour+"";
	}
	var minute = now.getMinutes();
	if(minute<=9){
		minute="0"+minute+"";
	}
	var seconds = now.getSeconds();
	if(seconds<=9){
		seconds="0"+seconds+"";
	}	
	return year + "-" + month + "-" + date + "T" + hour + ":" + minute + ":"+seconds;
}