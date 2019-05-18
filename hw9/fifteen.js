$(document).ready(function () {
    game();
});

game = function () {
    var r;
    var d;
    var puzzleArea = document.getElementById('puzzlearea');
    var divs = puzzleArea.getElementsByTagName("div");

    var resetGame = function () {
        r = 300;
        d = 300;
        for (var i = 0; i < divs.length; i++) {
            var div = divs[i];

            // calculate x and y for this piece
            var x = ((i % 4) * 100);
            var y = (Math.floor(i / 4) * 100);

            // set basic style and background
            div.className = "puzzlepiece";
            div.style.left = x + 'px';
            div.style.top = y + 'px';
            div.style.backgroundImage = 'url("background.jpg")';
            div.style.backgroundPosition = -x + 'px ' + (-y) + 'px';
            updatePieces();
        }
    }

    resetGame();

    document.getElementById("shufflebutton").onclick = doShaffleGame;

    function doShaffleGame() {
        resetGame();
        for (var i = 0; i < 15; i++) {
            var x = i;
            while (x == i)
                x = Math.floor(Math.random() * 15) + 0;
            var div1 = divs[i];
            var tempX = div1.style.left;
            var tempY = div1.style.top;
            if (x == 15){
                div1.style.left = r;
                div1.style.top = d;
                r = tempX;
                d = tempY;
            }else{
                var div2 = divs[x];
                div1.style.left = div2.style.left;
                div1.style.top = div2.style.top;
                div2.style.left = tempX;
                div2.style.top = tempY;
            }
            updatePieces();
        }
    }

    $("div div").click(function () {
        var divEl = $(this);
        var x = parseInt(divEl.css("left"));
        var y = parseInt(divEl.css("top"));
        if (((x - 100) == r) && y == d)
            makeAMove(divEl, -100, 0);
        else if (((y - 100) == d) && x == r)
            makeAMove(divEl, 0, -100);
        else if (((x + 100) == r) && y == d)
            makeAMove(divEl, 100, 0);
        else if (((y + 100) == d) && x == r)
            makeAMove(divEl, 0, 100);
        updatePieces();
    });

    function updatePieces() {
        $("div div").each(function () {
            var x = parseInt($(this).css("left"));
            var y = parseInt($(this).css("top"));
            $(this).removeClass("movablepiece");
            if (isMoveable(x, y))
                $(this).addClass("movablepiece");
        });
    }

    function isMoveable(x, y){
        var res = false;
        if (((x - 100) == r) && y == d)
            res = true;
        else if (((y - 100) == d) && x == r)
            res = true;
        else if (((x + 100) == r) && y == d)
            res = true;
        else if (((y + 100) == d) && x == r)
            res = true;
        return res;
    }

    function makeAMove(element, xPos, yPos) {
        var x = parseInt(element.css("left")) + xPos + "px";
        var y = parseInt(element.css("top")) + yPos + "px";
        r -= xPos;
        d -= yPos;
        element.css("left", x);
        element.css("top", y);
    }
};