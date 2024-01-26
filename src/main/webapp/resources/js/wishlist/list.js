const initPage = () => {
    const checkAll = document.getElementById("checkAll");
    const checks = document.querySelectorAll(".checks");
    const delAllBtn = document.getElementById("delAllBtn");
    const delBtns = document.querySelectorAll(".delBtn");
    const tableAndPager = document.getElementById("tableAndPager");
    const nowPageNum = document.getElementById("nowPageNum");
    const addBtn = document.getElementById("addBtn");
    let count = 0;

    checkAll.addEventListener("click", () => {
        checks.forEach(e => {
            e.checked = checkAll.checked;
        })
        count = checkAll.checked ? checks.length : 0;

        if(count > 0 ){
            delAllBtn.classList.remove("d-none");
        } else {
            delAllBtn.classList.add("d-none");
        }
    })

    checks.forEach(check => {
        check.addEventListener("click", () => {
            count += check.checked ? 1 : -1;
            checkAll.checked = (count == checks.length);
            if(count > 0 ){
                delAllBtn.classList.remove("d-none");
            } else {
                delAllBtn.classList.add("d-none");
            }
        })
    })

    addBtn.addEventListener("click", ()=>{
        const deleteForm = document.getElementById("deleteForm");
        let formData = new FormData(deleteForm);
        
    })

    delAllBtn.addEventListener("click", ()=>{
        const checkeds = [...document.querySelectorAll(".checks:checked")];
        deleteWithJquery(checkeds, checkeds.map(e=>e.value));
        //deleteWithFetch(checkeds, checkeds.map(e=>e.value));
    })

    delBtns.forEach(delBtn => {
        delBtn.addEventListener("click", event=>{
            deleteWithJquery([event.target], event.target.getAttribute("data-pNum"));
            //deleteWithFetch([event.target], event.target.getAttribute("data-pNum"));
        })
    })

    function deleteWithFetch(targets, values){
        console.log("delete Fetch Start");
        let param = "productNum=" + values.join(",");
        fetch('delete',{
            method : "POST",
            body : `page=${nowPageNum.value}&${param}`
        }).then(response => response.text())
        .then(result => {
            targets.forEach(target => {
                target.parentElement.parentElement.remove();
            })

            tableAndPager.innerHTML = result;
            initPage();
        })
    }

    function deleteWithJquery(targets, values){
        console.log("delete Jquery Start");
        $.ajax({
            url : "delete",
            method : "POST",
            traditional : true,
            data : {
                page : nowPageNum.value,
                productNum : values
            },
            success : result => {
                targets.forEach(target => {
                    target.parentElement.parentElement.remove();
                })

                tableAndPager.innerHTML = result;
                initPage();
            },
            error : response => {
                console.log("error");
                console.log(response);
            }
        })
    }
}

initPage();