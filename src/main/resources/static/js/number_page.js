$(document).ready(function () {
    $("#card_number_id").keyup(function (event) {
        if (event.keyCode === 13) {
            var card_number_id = $('#card_number_id').val();
            var arr = {number: card_number_id, pin: ""};
            $.ajax({
                url: "/card-number",
                type: "POST",
                contentType: 'application/json',
                data: JSON.stringify(arr),
                success: function (response) {
                    localStorage.cardNumberId=card_number_id;
                    window.location = 'pin.html';
                },
                error: function (xhr) {
                    alert("sdsfdfffffd");
                }
            });
        }
    });
});
