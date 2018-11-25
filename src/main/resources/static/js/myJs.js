

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


    $(".ajax-link").click(function () {
        var info = $(this).attr("href") + "#content";
        $("#content").hide("fast", loadContent);

        function loadContent() {
            $("#content").load(info, "", function () {
                $("#content").show("normal");
            })
        }
    });

    // function doAjax() {
    //     $.ajax({
    //         url: 'checkStrength',
    //         data: ({password : $('#password').val()}),
    //         success: function (data) {
    //             $('#strengthValue').html(data);
    //         }
    //     });
    // };
});