$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: '/balance/'+localStorage.getItem('cardNumberId'),
        contentType: 'application/json',
        dataType: 'json',
        headers: {"Authorization": localStorage.getItem('token')},
        success: function (data) {
            $("#LabelID").text(data.number);
            $("#LabelID").text(data.isBlocked);
            $("#LabelID").text(data.money);
        },
        error: function (xhr, str) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
});