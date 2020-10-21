$(document).ready(function() {
	const gitalk = new Gitalk({
	  clientID: '',
	  clientSecret: '',
	  repo: 'MyBlog_Talk',      // The repository of store comments,
	  owner: 'Thunder-lilei',
	  admin: ['Thunder-lilei'],
	  id: location.pathname,      // Ensure uniqueness and length less than 50
	  distractionFreeMode: false  // Facebook-like distraction free mode
	})

	gitalk.render('gitalk-container')
	
		let message = GetQueryString('message');
		if(message!=="success" && message!==null)
		{alert(message)}
		
		let id = GetQueryString("id");
//		getnote(id);
		(function(){
			$.getJSON('/lilei_blog/note/putpage',{id:id},function(data){
				let message = '';
				let page = '';
				$.each(data, function(index,item) {
					if(index=="message")
					{message = item}
					if(index=="page")
					{page = JSON.stringify(item)}
				});
				switch(message)
				{
					case "success":
					break;
					default :
					alert(message);
				}
				$.each($.parseJSON(page), function(index, item) {
					if(index==="title"){document.getElementById("article_title").innerHTML = item;}
					if(index==="image"){document.getElementById("article_image").src = item;}
					if(index==="author"){document.getElementById("article_author").innerHTML = item;}
					if(index==="time"){document.getElementById("article_time").innerHTML = formatDate(new Date(item));}
					if(index==="content"){document.getElementById("article_body").innerHTML = item;}
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