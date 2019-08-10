$(document).ready(function () {
    $("#card_pin_id").keyup(function (event) {
        if (event.keyCode === 13) {
            var card_pin_id = $('#card_pin_id').val();
            var card_number_id = localStorage.cardNumberId;
            var arr = {number: card_number_id, pin: card_pin_id};
            $.ajax({
                type: 'POST',
                url: '/login',
                contentType: 'application/json',
                data: JSON.stringify(arr),
                success: function (data, textStatus, jqXHR) {
                    localStorage.token = jqXHR.getResponseHeader('token');
                    window.location = 'operations_list.html';
                },
                error: function (xhr, str) {
                    alert('Возникла ошибка: ' + xhr.responseJSON.message);
                }
            });
        }
    });
});
