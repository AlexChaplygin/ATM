function getMoney() {
    var money = $("#getmoney").val();
    $.ajax({
        type: 'GET',
        url: '/withdrawal/' + localStorage.getItem('cardNumberId') + '/' + money,
        contentType: 'application/json',
        dataType: 'json',
        headers: {"Authorization": localStorage.getItem('token')},
        success: function (data) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        },
        error: function (xhr, str) {
            alert('Возникла ошибка: ' + xhr.responseCode);
        }
    });
}
