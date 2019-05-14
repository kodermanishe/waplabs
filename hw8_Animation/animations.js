/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = initP;
function initP() {
    document.getElementById("stop").onclick = stopAnimation;
    document.getElementById("start").onclick = startAnimation;
    document.getElementById("animType").onchange = changeAnimation;
    document.getElementById("turbo").onclick = setTurbo;
    document.getElementById("size").onchange = changeFontSize;
}

var fr = 0;
var animation = ANIMATIONS["blank"];
var interval = null;
var timer;

function doAnimation(){
    document.getElementById("text").value = animation[fr];
    if (fr + 1 == animation.length)
        fr = 0;
    else
        fr+=1;
}
function stopAnimation() {
    clearInterval(interval);
    interval = null;
    setDisability(false);
    document.getElementById("").value = animation[fr];
}
function startAnimation() {
    setDisability(true);
    if (timer == null)
        timer = 250;
    interval = setInterval(doAnimation, timer);
}
function setDisability(p) {
    document.getElementById("start").disabled = p;
    document.getElementById("stop").disabled = !p;
    document.getElementById("animType").disabled = p;
}
function changeAnimation() {
    fr = 0;
    var e = document.getElementById("animType");
    var animType = e.options[e.selectedIndex].value;
    animation = ANIMATIONS[animType].split("=====\n");
}
function setTurbo() {
    if ( document.getElementById("turbo").checked)
        timer = 50;
    else
        timer = 250;
    if (interval != null){
        clearInterval(interval);
        interval = setInterval(doAnimation, timer);
    }
}
function changeFontSize() {
    var e = document.getElementById("size");
    var fontS = e.options[e.selectedIndex].value;
    document.getElementById("text").style.fontSize = FONTSIZE[fontS];
}


