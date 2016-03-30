/**
 * Created by elena on 13.03.16.
 */
$(document).ready(function() {

    // init option in select
    if (found=document.location.href.match(/sort=([^&$]+)/i)) {
        $('#catalogSort').val(found[1]);
    }
    // reload page with new sort order
    $('#catalogSort').on('change', function() {
        document.location.href = replaceUrlParam(document.location.href, 'sort', $(this).val());
    });

});

function replaceUrlParam(url, paramName, paramValue){
    var pattern = new RegExp('\\b('+paramName+'=).*?(&|$)')
    if(url.search(pattern)>=0){
        return url.replace(pattern,'$1' + paramValue + '$2');
    }
    return url + (url.indexOf('?')>0 ? '&' : '?') + paramName + '=' + paramValue
}
