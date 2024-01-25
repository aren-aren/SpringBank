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
})();
