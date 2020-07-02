//----------------------------------------------------------------------------------------------------------------------
//wrapped functions
(function () {
    //------------------------------------------------------------------------------------------------------------------
    //usestrict
    "use strict";
    //------------------------------------------------------------------------------------------------------------------
    //global imports of elements and ids
    const inputuser = document.getElementById("username");
    const inputpw = document.getElementById("password");
    const submitbutton = document.getElementById("submitbutton");
//----------------------------------------------------------------------------------------------------------------------

    async function checklogin()
    {
        const send_pw = inputpw.value.trim().toLowerCase();
        const send_user = inputuser.value.trim().toLowerCase();
        const data = {username:send_user, password:send_pw};
        const content = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        };

        fetch('/authenticate',content)
            .then(response => response.json())
            .then(data =>
            {
                console.log(data)
                console.log(typeof(data))
                if(data.code===200)
                {
                    document.getElementById("error-msg").classList.add("d-none")
                    window.location.href='/search', true;
                }
                else
                {
                    document.getElementById("error-msg").classList.remove("d-none")
                }
            }
            )
            .catch(err => {
                window.location.href='/error'
            });
    }

//----------------------------------------------------------------------------------------------------------------------
    //listeners
    (function () {
        // adding all the needed even listeners
        submitbutton.addEventListener("click", checklogin);
    })();
})();
//----------------------------------------------------------------------------------------------------------------------