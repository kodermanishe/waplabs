
var timer = null;

var rudyTimer = (function () {
    rudy = function(){
        document.getElementById("output").innerHTML += "Rudy!";
    }
    return {
        execute: function () {
            if (timer == null) {
                this.timer = setInterval(rudy, 1000);
            } else {
                clearInterval(timer);
                timer = null;
            }
        }
    }
})();
