$(document).ready(function (s) {
    var s = false;
    $("#start").click(function () {
        s = true;
        $(".boundary").css("background-color", "#eeeeee");
        $("#status").html(" Click the \"E\" to win the game.");
    });

    $("#end").click(function () {
        if (s) {
            s = false;
            $("#status").html("You win!");
        }
    });

    $("div .boundary").mouseover(function () {
        if (s) {
            s = false;
            $("div .boundary").css("background-color", "pink");
            $("#status").html("You lost!");
        }
    });
    $(document).on( "mousemove", function(event) {
        if (event.pageX <= $("#start").offset().left){
            if (s) {
                s = false;
                $("div .boundary").css("background-color", "pink");
                $("#status").html("You lost!");
            }
        }
    });
});

