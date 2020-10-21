$(document).ready(function() {
		let message = GetQueryString('message');
		if(message!=="success" && message!==null)
		{alert(message)}
		
		(function(){
			$.get('/lilei_blog/note/gettimeline',function(data){
				let message = '';
				let list = [];
				$.each(data, function(index,item) {
					if(index=="message")
					{message = item}
					if(index=="list")
					{list = JSON.stringify(item)}
				});
				switch(message)
				{
					case "success":
					break;
					default :
					alert(message);
				}
				let timeline = document.getElementById("timeline");
				let hr = document.createElement("hr");
				timeline.appendChild(hr);
				$.each($.parseJSON(list), function(index, item) {
					let newli = document.createElement("li");
					let newtime = document.createElement("span");
					newtime.setAttribute("class","am-u-sm-4 am-u-md-2 timeline-span");
					newtime.innerHTML = item.time;
					newli.appendChild(newtime);
					let newtitle = document.createElement("span");
					newtitle.setAttribute("class","am-u-sm-8 am-u-md-6");
					let newa = document.createElement("a");
					newa.innerHTML = item.title;
					newa.href = "article.html?"+"id="+item.noteid+"";
					newtitle.appendChild(newa);
					newli.appendChild(newtitle);
					let newcategory = document.createElement("span");
					newcategory.setAttribute("class","am-u-sm-4 am-u-md-2 am-hide-sm-only");
					newcategory.innerHTML = "分类";
					newli.appendChild(newcategory);
					let newauthor = document.createElement("span");
					newauthor.setAttribute("class","am-u-sm-4 am-u-md-2 am-hide-sm-only");
					newauthor.innerHTML = item.author;
					newli.appendChild(newauthor);
					
					timeline.appendChild(newli);
				});
				
			});
		})()
})

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