(function(){
    let sortBy = document.getElementById("sortBy");
    if(sortBy != null){
        sortBy.addEventListener("change", event=> {
            const path = event.target.getAttribute("data-url");
            let param = path + "&sortBy=" + event.target.value;
            location.href = param;
        })
    }

    const sortSelect = document.getElementById("sortBy");
    sortSelect.childNodes.forEach(op => {
        if(op == null){
            return;
        }

        if(op.value === sortSelect.getAttribute("data-sort")){
            op.selected = true;
        }
    })
    
    const kinds = document.getElementById("kindBy");
    kinds.childNodes.forEach(ki => {
        if(ki == null){
            return;
        }

        const kindVal = document.getElementById("kindBy");

        if(ki.value === kindVal.getAttribute("data-kind")){
            ki.selected = true;
        }
    })
})();