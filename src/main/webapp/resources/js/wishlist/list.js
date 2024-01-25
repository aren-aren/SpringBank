(() => {
    const checkAll = document.getElementById("checkAll");
    const checks = document.querySelectorAll(".checks");
    const delAllBtn = document.getElementById("delAllBtn");
    const delBtns = document.querySelectorAll(".delBtn");
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

    delAllBtn.addEventListener("click", ()=>{
        const checkeds = document.querySelectorAll(".checks:checked");
        const checkedValues = [...checkeds].map(e=>e.value);
        console.log(checkedValues);

        $.ajax({
            url : "delete",
            method : "POST",
            traditional : true,
            data : {
                productNum : checkedValues
            },
            success : result => {
                console.log("success");
                console.log(result);

                if(Number(result.trim()) > 0){
                    checkeds.forEach(checked => {
                        checked.parentElement.parentElement.remove();
                        count = 0;
                        delAllBtn.classList.add("d-none");
                    })
                }
            },
            error : response => {
                console.log("error");
                console.log(response);
            }
        })
    })

    delBtns.forEach(delBtn => {
        delBtn.addEventListener("click", event=>{
            const pNum = event.target.getAttribute("data-pNum");
            $.ajax({
                url : "delete",
                method : "POST",
                traditional : true,
                data : {
                    productNum : pNum
                },
                success : result => {
                    console.log("success");
                    console.log(result);
    
                    if(Number(result.trim()) > 0){
                        event.target.parentElement.parentElement.remove();
                    }
                },
                error : response => {
                    console.log("error");
                    console.log(response);
                }
            })
        })
    })
})();