const update = document.getElementById("update");
const del = document.getElementById("delete");
const frm = document.getElementById("submitForm");

const imgItem = document.querySelector(".carousel-item");

if(imgItem != null){
	imgItem.classList.add("active");
}

update.addEventListener("click", event=> {
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