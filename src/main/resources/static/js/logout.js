document.addEventListener("DOMContentLoaded", function () {
    const logoutLink = document.getElementById("logout-link");

    if (logoutLink) {
        logoutLink.addEventListener("click", function () {
            localStorage.removeItem("token");
            window.location.href = "/login";
        });
    }
});
