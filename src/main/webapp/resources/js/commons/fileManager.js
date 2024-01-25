
{/* <div class="input-group mb-3">
<input type="file" class="form-control" name="attachs" accept="image/*">
<button class="btn btn-outline-danger">X</button>
</div> */}

/* JS */
const addBtn = document.getElementById("addBtn");
const fileDiv = document.getElementById("fileList");
const addNotice = document.getElementById("addNotice");
const childNum = fileDiv.children.length;

addBtn.addEventListener("click", event=>{
    event.preventDefault();

    if(fileDiv.children.length == childNum + 5){
        return;
    }

    fileDiv.appendChild(getFileDiv());

    if(fileDiv.children.length == childNum + 5){
        addBtn.classList.add("disabled");
        addNotice.classList.remove("d-none");
    }
})

let getFileDiv = () => {
    let div = document.createElement("div");
    div.classList.add("input-group");
    
    let input = document.createElement("input");
    let typeFile = document.createAttribute("type");
    typeFile.value="file";
    let nameAttach = document.createAttribute("name");
    nameAttach.value="attachs";
    let acceptImg = document.createAttribute("accept");
    acceptImg.value="image/*";
    input.setAttributeNode(typeFile);
    input.setAttributeNode(nameAttach);
    input.setAttributeNode(acceptImg);
    input.classList.add("form-control");
    input.addEventListener("change",  event => {
        let a = event.target.value.split(".");
        let image = /png|jpg|jpeg/;

        console.log(a[a.length-1]);
        if(!(image.test(a[a.length-1]))){
            event.target.value=null;
            alert("사진 파일만 첨부 가능합니다.");
        }
    })

    let btn = document.createElement("button");
    let btnType = document.createAttribute("type");
    let Xtext = document.createTextNode("X");
    btnType.value = "button";
    btn.setAttributeNode(btnType);
    btn.appendChild(Xtext);
    btn.classList.add("btn", "btn-outline-danger");
    btn.addEventListener("click", ()=>{
        div.remove();
        addBtn.classList.remove("disabled");
        addNotice.classList.add("d-none");
    });

    div.appendChild(input);
    div.appendChild(btn);

    return div;
}

/* JQuery */

// const childNum = $('#fileList').children().length;
// let indexCount = 0;
// $('#addBtn').click(event=>{
//     event.preventDefault();
//     if($('#fileList').children().length == childNum + 5){
//         return;
//     }
    
//     let element = i => `<div id="div-${i}" class="input-group">
//                             <input type="file" class="form-control" name="attachs" accept="image/*">
//                             <button type="button" id="btn-${i}" data-index="${i}" class="btn btn-outline-danger">X</button>
//                         </div>`
    
//     $('#fileList').append(element(indexCount));
//     $(`#btn-${indexCount}`).click(event=>{
//         let idx = $(event.target).attr('data-index');
//         $(`#div-${idx}`).remove();
//         $('#addBtn').removeClass("disabled");
//         $('#addNotice').addClass("d-none");
//     })
//     indexCount++;

//     if($('#fileList').children().length == childNum + 5){
//         $('#addBtn').addClass("disabled");
//         $('#addNotice').removeClass("d-none");
//     }
// })