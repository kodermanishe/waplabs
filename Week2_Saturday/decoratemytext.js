
window.onload=setEvents;
function setEvents() {
    document.getElementById("bigger").onclick = resize;
    document.getElementById("check").onchange = styleText;
    document.getElementById("atinlay").onclick = atinlay;
    document.getElementById("malkovitch").onclick = malkovitch;
}

function decorateText() {
    var elem = document.getElementById("textAr");
    var fontsize = window.getComputedStyle(elem).fontSize;
    elem.style.fontSize = (parseFloat(fontsize) + 2) + "pt";
}
function resize() {
    setInterval(decorateText, 500);
}
function styleText() {
    var elem = document.getElementById("textAr");
    if (document.getElementById("check").checked ){
        elem.style.fontWeight = "bold";
        elem.style.color = "green";
        elem.style.textDecoration = "underline";
        document.body.style.backgroundImage
            = "url(http://www.cs.washington.edu/education/courses/190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg)";
    }else {
        elem.style.fontWeight = "normal";
        elem.style.color = "black";
        elem.style.textDecoration = "none";
        document.body.style.backgroundImage = "none";
    }
}
function malkovitch() {
    var elem = document.getElementById("textAr");
    var txt = elem.value;
    var txts = txt.split(" ");
    var res = "";
    for (var i = 0; i < txts.length; i++){
        if (res != "")
            res += " ";
        res += (txts[i].length >= 5 )? "Malkovitch" : txts[i]
    }
    elem.value = res;
}
function atinlay() {
    var elem = document.getElementById("textAr");
    var txt = elem.value;
    var txts = txt.split(" ");
    var res = "";
    for (var i = 0; i < txts.length; i++){
        if (res != "")
            res += " ";
        res += atinlayTxt(txts[i]);
    }
    elem.value = res;
}

function atinlayTxt(str) {
    var res = str;
    if ((/^[aeiou]$/i).test(str.charAt(0))){
        res += "ay";
    }else {
        res = res.substr(1) + res.charAt(0) + "ay";
    }
    return res;
}