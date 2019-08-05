$(document).ready(function () {
    $("#card_pin_id").keyup(function (event) {
        if (event.keyCode === 13) {
            var card_pin_id = $('#card_pin_id').val();
            var arr = {number: 123, pin: card_pin_id};
            $.ajax({
                type: 'POST',
                url: '/card-pin',
                contentType: 'application/json',
                data: JSON.stringify(arr),
                success: function () {
                    $('#results').html(data);
                },
                error: function (xhr, str) {
                    alert('Возникла ошибка: ' + xhr.responseCode);
                }
            });
        }
    });
});
