/* JS */
(() => {
    const checkAll = document.getElementById("checkAll");
    const checks = document.querySelectorAll(".checks");
    let count = 0;

    checkAll.addEventListener("click", () => {
        checks.forEach(e => {
            e.checked = checkAll.checked;
        })
        count = checkAll.checked ? checks.length : 0;
    })

    checks.forEach(check => {
        check.addEventListener("click", () => {
            count += check.checked ? 1 : -1;
            checkAll.checked = (count == checks.length);
        })
    })

    const joinBtn = document.querySelector("#joinBtn")
    const essentials = document.querySelectorAll(".essential");
    joinBtn.addEventListener("click", e => {
        e.preventDefault();

        for (let esse of essentials) {
            if (!esse.checked) {
                alert("필수 동의 사항에 체크해주세요");
                esse.focus();
                return;
            }
        }

        location.href = "join";
    })
})();

/* JQuery */
// $('#checkAll').click(()=>{
//     $('.checks').prop('checked',$('#checkAll').prop("checked"));
// });

// $('.checks').click(()=>{
//     let bool = true;
//     $('.checks').each((index, item)=>{
//         bool &= item.checked;
//     })
//     $('#checkAll').prop('checked', bool)
// })

// $('#joinBtn').click(e=>{
//     e.preventDefault();
//     let flag = true;
//     $('.essential').each((index, item)=>{
//         if(!item.checked){
//             alert("필수 동의 사항에 체크해주세요");
//             item.focus();
//             flag = false;
//             return false;
//         }
//     })

//     if(flag) location.href = "join";
// })