document.addEventListener('DOMContentLoaded', function () {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "/login";
        return;
    }

    const deleteLinks = document.querySelectorAll('.delete');
    deleteLinks.forEach(link => {
        link.addEventListener('click', function (event) {
            const confirmar = confirm("Tem certeza que deseja excluir este produto?");
            if (!confirmar) {
                event.preventDefault();
            }
        });
    });

    const goToFormBtn = document.getElementById("go-to-product-form");
    if (goToFormBtn) {
        goToFormBtn.addEventListener("click", function () {
            window.location.href = "/products/form";
        });
    }
});
