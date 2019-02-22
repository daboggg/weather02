$(document).ready(function () {

    $('#input_city').focus();
    $('#input_city').autocomplete({
        source: '/search',
        delay: 500,
        minLength: 1
    });

    $('#period_id').buttonset()

    $("#pogoda_form").validate({
        rules: {
            input_city: {
                remote: 'check_city'
            }
        },
        messages: {
            input_city: {
                remote: "Введите название города или широту и долготу в" +
                    "виде: 00.0*****, 00.0*****"

            }
        }
    });

    /*============================================================================*/


});
