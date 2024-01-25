(function () {
    const update = document.getElementById("update");
    const del = document.getElementById("delete");
    const frm = document.getElementById("submitForm");

    const imgItem = document.querySelector(".carousel-item");

    if (imgItem != null) {
        imgItem.classList.add("active");
    }

    update.addEventListener("click", event => {
        event.preventDefault();
        frm.setAttribute("action", "./update");
        frm.setAttribute("method", "get");
        frm.submit();
    })

    del.addEventListener("click", event => {
        event.preventDefault();
        frm.setAttribute("action", "./delete");
        frm.setAttribute("method", "post");
        frm.submit();
    })

    const addWishBtn = document.getElementById("addWishBtn");
    addWishBtn.addEventListener("click",()=>{
        const pNum = document.querySelector("h6#productNum").innerText;
        fetch(`/wishlist/add?productNum=${pNum}`,{
            method : "GET", 
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            }
        }).then(response => response.text())
        .then(response => {
            console.log(response);
            if(response.trim()==='1'){
                if(confirm("위시리스트 페이지로 이동하시겠습니까?"))
                    location.href="/wishlist/list";
            } else {
                alert("실?패")
            }
        })


    //     $.ajax({
    //         url : "/wishlist/add",
    //         method : "GET",
    //         data : {
    //             productNum : $("h6#productNum").text()
    //         },
    //         success : function(response){
    //             console.log("success");
    //             console.log(response);
    //         },
    //         error : function(response){
    //             console.log("error");
    //             console.log(response);
    //         }
    //     })
     })
})();