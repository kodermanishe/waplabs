timer = null;

function rudy() {
    document.getElementById("output").innerHTML += "Rudy!";
}
var rudyTimer = (function() {
    if (timer === null) {
        timer = setInterval(rudy, 1000);
    } else {
        clearInterval(timer);
        timer = null;
    }
})();
