/**
 * Created by IntelliJ IDEA.
 * User: Elena Shvets
 * Date: 09.02.16.
 */
$(document).ready(function () {

    $.ajax({
        url: "/cart/info",
        dataType: 'JSON',
        type: 'GET',
        success: function (response) {
            $('#cartQuantity').html(response.quantity);
            $('#cartCost').html(response.cost);
        }
    });

    $('.add2card').on("click", function (event) {

        var productId = $(this).data('productId');

        $.ajax({
            url: "/cart/" + productId,
            dataType: 'JSON',
            type: 'GET',
            success: function (response) {
                $('#cartQuantity').html(response.quantity);
                $('#cartCost').html(response.cost);
            }
        });
    });

    $('.removeFromCart').on("click", function (event) {

        var productId = $(this).data('productId');

        $.ajax({
            url: "/cart/" + productId,
            type: 'POST',
            success: function (response) {
                document.location.reload();
            }
        });
    });

});