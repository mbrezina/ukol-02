"use strict";

var elementVyrok = document.querySelector("#vyrok");
elementVyrok.innerText = "Testing if it works";
let obrazekJidla = document.querySelector(".obrazek-jidla")
let popisJidla = document.querySelector("#popisJidla");
let nazevJidla = document.querySelector("#nazevJidla");


function nactiJidlo() {
    var httpKlient = new XMLHttpRequest();
    httpKlient.onload = hotovo;
    httpKlient.onerror = chyba;
    httpKlient.open("GET", "nahodny", true);
    httpKlient.send();
}

function hotovo() {
    console.log(this.response);
    popisJidla.innerText = this.response.popis;
    nazevJidla.innerText = this.response.nazev;
    obrazekJidla.src = "images/" + this.response.index + ".jpg"

}

function chyba(err) {
    alert("Nastala chyba při komunikaci se serverem: " + err);
}
