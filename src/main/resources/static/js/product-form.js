document.addEventListener("DOMContentLoaded", function () {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "/login";
        return;
    }


    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function (event) {
            const price = parseFloat(document.querySelector('#price').value);
            const amount = parseInt(document.querySelector('#amount').value);

            if (price < 0 || amount < 0) {
                alert("Preço e quantidade devem ser valores positivos.");
                event.preventDefault();
            }
        });
    }
});
