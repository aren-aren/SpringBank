/*!
* Start Bootstrap - Personal v1.0.1 (https://startbootstrap.com/template-overviews/personal)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-personal/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

$(document).ready(()=>{
$("#summernoteContents").summernote();
    	document.querySelectorAll("input[name=attachs]")
    		.forEach(file => file.addEventListener("change", event=> {
    						let a = event.target.value.split(".");
    						let image = /png|jpg|jpeg/;
    						
    						console.log(a[a.length-1]);
    						if(!(image.test(a[a.length-1]))){
    							event.target.value=null;
    						}
    					})
    				)
})