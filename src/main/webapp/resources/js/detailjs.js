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
                alert("등록 성공");
            } else {
                alert("실?패")
            }
        })
    })
})();