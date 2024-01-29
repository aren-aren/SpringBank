const getCardList = () =>{
    const pNum = document.getElementById("productNum").innerText;
    const replyList = document.getElementById("replyList");

    console.log(pNum);

    fetch(`/reply/list?productNum=${pNum}&page=${replyList.getAttribute("data-page")}`)
    .then(response=>response.text())
    .then(result => {
        if(result.trim() == ''){
            document.getElementById("moreReplyBtn").classList.add("d-none");
        }

        $(replyList).append(result);
    })
}

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
     })
     
     console.log("fmfkmfkmreg");

    const replyAdd = document.getElementById("replyAdd");

    if(replyAdd != null){
        replyAdd.addEventListener("click",()=>{
            console.log("replyAdd start")
            const replyForm = document.getElementById("replyForm");
            const data = new FormData(replyForm);
            fetch('/reply/add',{
                method : "POST",
                body : data
            }).then(response => response.text())
            .then(result => {
                if(result.trim() > 0){
                    document.getElementById("replyList").innerHTML = "";
                    replyList.setAttribute("data-page", 1);
                    getCardList();
                    // document.getElementById("replyContents").value = "";
                    // document.querySelector("input[type=radio]:checked").checked = false;
                    document.getElementById("moreReplyBtn").classList.remove("d-none");
                    replyForm.reset();
                }
            });
        })
    }

    const moreReplyBtn = document.getElementById("moreReplyBtn");
    moreReplyBtn.addEventListener("click", ()=>{
        const replyList = document.getElementById("replyList");
        replyList.setAttribute("data-page", Number(replyList.getAttribute("data-page")) + 1);
        getCardList();
    })
})();

