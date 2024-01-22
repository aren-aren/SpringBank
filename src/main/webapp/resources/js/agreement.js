/* JS */
// const checkAll = document.getElementById("checkAll");
// const checks = document.querySelectorAll(".checks");

// checkAll.addEventListener("click", ()=>{
//     checks.forEach(e=>{
//         e.checked = checkAll.checked;
//     })
// })

// checks.forEach(check=>{
//     check.addEventListener("click", ()=>{
//         let bool = true;
//         checks.forEach(ch=>{
//             bool &= ch.checked;
//         });
//         checkAll.checked = bool;
//     })
// })


/* JQuery */
$('#checkAll').click(()=>{
    $('.checks').prop('checked',$('#checkAll').prop("checked"));
});

$('.checks').click(()=>{
    let bool = true;
    $('.checks').each((index, item)=>{
        bool &= item.checked;
    })
    $('#checkAll').prop('checked', bool)
})