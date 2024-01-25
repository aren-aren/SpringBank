let btn = document.getElementById("btn");
let btn2 = document.getElementById("btn2");

btn2.addEventListener("click", ()=>{
    const title = document.getElementById("title").value;
    const content = document.getElementById("content").value;

    fetch('/notice/add', {
        method : "POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:`noticeTitle=${title}&noticeContents=${content}`
    }).then(response => response.text())
    .then(response => console.log(response))
})

btn.addEventListener("click", ()=>{
    console.log("fetch 시작");
    fetch("/notice/list", {
        method : "GET"
    }).then((response)=>response.text())
    .then((res)=>{
        document.getElementById("result").innerHTML = res;
    })
    console.log("fetch 끝");
})

