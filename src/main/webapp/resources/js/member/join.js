(() => {
    const addrBtn = document.getElementById("findAddress");
    addrBtn.addEventListener("click", () => {
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let addr = ''; // 주소 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("memberAddress").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addrNotice").classList.remove("d-none");
                document.getElementById("memberAddress").focus();
            }
        }).open();
    })

    const userName = document.getElementById("userName");
    const password = document.getElementById("memberPassword");
    const passwordCheck = document.getElementById("memberPasswordCheck");
    const passwordResult = document.getElementById("passwordResult");
    const passwordCheckResult = document.getElementById("passwordCheckResult");
    const userNameResult = document.getElementById("userNameResult");
    const contactForm = document.getElementById("contactForm");

    userName.addEventListener('blur',()=>{
        if(userName.value === ''){
            return;
        }

        /* JS */
        // fetch(`idCheck?userName=${userName.value}`, { 
        //     method : "GET"
        // })
        // .then(response => response.text())
        // .then(response => {
        //     if(response.trim() === '0'){
        //         userNameResult.innerHTML = "중복된 아이디 입니다.";
        //         idCheck = false;
        //         return;
        //     }

        //     userNameResult.innerHTML = "사용 가능합니다.";
        //     idCheck = true;
        // })

        /* JQuery */
        $.ajax({
            url : "./idCheck",
            method : "GET",
            data : {
                userName : $("#userName").val()
            },
            success : function(result){
                console.log("success");
                console.log(result);
            },
            error : function(result){
                console.log("error");
                console.log(result);
            }
        })
    });

    let idCheck = false;

    const userNameValid = () => {
        if (userName.value.length <= 0) {
            userNameResult.innerHTML = "아이디는 필수입력 사항입니다.";
            return false;
        }

        if (userName.value.length <= 1) {
            userNameResult.innerHTML = "아이디는 1글자 이상이어야합니다.";
            return false;
        }

        userNameResult.innerHTML = "";
        return true;
    };

    const passwordValid = () => {
        
        if (password.value.length < 8) {
            passwordResult.innerHTML = '글자 수가 모자랍니다.';
            return false;
        }



        passwordResult.innerHTML = "";
        return true;
    };
    const passwordCheckValid = () => {
        if (password.value != passwordCheck.value) {
            passwordCheckResult.innerHTML = '비밀번호가 다릅니다.';
            return false;
        }
        
        passwordCheckResult.innerHTML = '';
        return true;
    };

    password.addEventListener("blur", passwordValid)
    passwordCheck.addEventListener("blur", passwordCheckValid)

    contactForm.addEventListener("submit", event => {
        if (userNameValid() && passwordValid() && passwordCheckValid() && idCheck) {
            alert("회원 가입")
            return;
        }
        event.preventDefault();
    })
})();