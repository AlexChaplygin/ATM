$(document).ready(function () {
    $("#card_number_id").keyup(function (event) {
        if (event.keyCode === 13) {
            var card_number_id = $('#card_number_id').val();
            var arr = {number: card_number_id};
            $.ajax({
                url: "/card-number",
                type: "get",
                data: {
                    number: card_number_id
                },
                success: function (response) {
                    window.location = 'pin.html';
                },
                error: function (xhr) {
                    alert("sdsfdfffffd");
                }
            });
        }
    });
});
