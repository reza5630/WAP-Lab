$(document).ready(function(){
    $("#searchBtn").click(search)
})

function search () {
    let inputValue = $("#lookupInput").val();
    console.log(inputValue);
    $.ajax({
        url: "http://localhost:8080/Try_war_exploded/SearchServlet",
        type: 'GET',
        data: {"searchString": inputValue},
        success: function (data) {
            $('#result').html(data);
        }
    })
}