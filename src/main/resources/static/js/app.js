"use strict";

let obrazekJidla = document.querySelector("#obrazekJidla")
let popisJidla = document.querySelector("#popisJidla");
let nazevJidla = document.querySelector("#nazevJidla");
let tlacitko = document.querySelector("#tlacitko");
let uvod = document.querySelector("#uvod");

function nactiJidlo() {
    var httpKlient = new XMLHttpRequest();
    httpKlient.onload = hotovo;
    httpKlient.onerror = chyba;
    httpKlient.open("GET", "nahodny", true);
    httpKlient.send();
}

function hotovo() {
    var Eten = JSON.parse(this.response);
    nazevJidla.innerText = Eten.nazev;
    nazevJidla.classList.add("display-3");
    popisJidla.innerText = Eten.popis;
    obrazekJidla.src = "images/" + Eten.index + ".jpg";
    obrazekJidla.classList.add("obrazek_jidla");
    tlacitko.innerHTML = "Chci víc jídla";
    tlacitko.classList.remove("btn-warning");
    tlacitko.classList.add("btn-success");
    uvod.innerHTML = "";

}

function chyba(err) {
    alert("Nastala chyba při komunikaci se serverem: " + err);
}
