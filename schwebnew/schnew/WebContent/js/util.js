function ww4(date){  
	var y = date.getFullYear();  
	var m = date.getMonth()+1;  
	var d = date.getDate();  
	return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
}  
function w4(s){  
    var reg=/[\u4e00-\u9fa5]/  //利用正则表达式分隔   
    var ss = (s.split(reg));  
    var y = parseInt(ss[0],10);  
    var m = parseInt(ss[1],10);  
    var d = parseInt(ss[2],10);  
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){  
        return new Date(y,m-1,d);  
    } else {  
        return new Date();  
    }  
}  