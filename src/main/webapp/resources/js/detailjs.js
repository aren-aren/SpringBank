const getCardList = () =>{
    const pNum = document.getElementById("productNum").innerText;
    const replyList = document.getElementById("replyList");

    console.log(pNum);

    getReplyList(pNum, replyList.getAttribute("data-page"));

    // fetch(`/reply/list?productNum=${pNum}&page=${replyList.getAttribute("data-page")}`)
    // .then(response=>response.text())
    // .then(result => {
    //     if(result.trim() == ''){
    //         document.getElementById("moreReplyBtn").classList.add("d-none");
    //     }

    //     $(replyList).append(result);
    // })
}

const getReplyList = (productNum, page) => {
    fetch(`/reply/list?productNum=${productNum}&page=${page}`, {
        method : "GET"
    }).then(r => r.json())
    .then(r => {
        if(r.length == 0){
            document.getElementById("moreReplyBtn").classList.add("d-none");
            return;
        }
        const uname = replyList.getAttribute("data-user-name");

        r.forEach(reply => {
            document.getElementById("replyList").append(getCard(reply, (uname == reply.userName)));
        })
    })
}

const getCard = (reply, islogined) => {
    const card = document.createElement("div");
    card.classList.add("card");

    const cardBody = document.createElement("div");
    cardBody.classList.add("card-body");

    const cardTitle = document.createElement("div");
    cardTitle.classList.add("card-title");

    const cardUserName = document.createTextNode(reply.userName);
    const jumsu = document.createElement("p");
    jumsu.classList.add("float-end");
    const jumsuText = document.createTextNode("별점 : " + reply.replyJumsu);
    jumsu.append(jumsuText);
    
    cardTitle.append(cardUserName);
    cardTitle.append(jumsu);

    const content = document.createElement("p");
    content.classList.add("card-text", "fs-5");
    content.append(document.createTextNode(reply.replyContents));

    if(islogined){
        const btn = document.createElement("button");
        btn.classList.add("btn","btn-outline-danger","border-0","btn-sm");
        btn.innerText = "X";
        btn.addEventListener("click", ()=>console.log("delClicked!!"));
        cardTitle.append(btn);
    }

    const replyDate = document.createElement("span");
    replyDate.classList.add("float-end","fs-6");
    replyDate.append(document.createTextNode(dateFormatting(reply.replyDate)))

    cardBody.append(cardTitle);
    cardBody.append(content);
    cardBody.append(replyDate);

    card.append(cardBody);
    return card;
}

const dateFormatting = ms => {
    let date = new Date(ms);
    return `${date.getFullYear()}년 ${date.getMonth()+1}월 ${date.getDate()}일`;
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

    getCardList();

})();

