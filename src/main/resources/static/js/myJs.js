

$(document).ready(function () {
    $('.table .eBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (user, status) {
            $('.myForm #id').val(user.id)
            $('.myForm #email').val(user.email)
            $('.myForm #login').val(user.login)
            $('.myForm #password').val(user.password)
            $('.myForm #role').val(user.role)
        });

        $('.myForm #exampleModal').modal();
    });
});