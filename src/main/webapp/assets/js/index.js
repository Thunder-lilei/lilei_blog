$(document).ready(function() {
		let message = GetQueryString('message');
		if(message!=="success" && message!==null)
		{alert(message)}
		
		(function(){
			$.get('/lilei_blog/note/putpages',function(data){
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
				let blogs = document.getElementById("blogs");
				$.each($.parseJSON(list), function(index, item) {
					let newa = document.createElement("a");
					newa.href = "article.html?"+"id="+item.noteid+"";
					let titleimg = document.createElement("img");
					titleimg.src = item.image;
					newa.appendChild(titleimg);
					let newbr = document.createElement("hr");
					let introduction = document.createElement("span");
					introduction.innerHTML = "作者："+item.author;
					introduction.innerHTML += "简介："+item.introduction;
					
					blogs.appendChild(newa)
					blogs.appendChild(introduction);
					blogs.appendChild(newbr);
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