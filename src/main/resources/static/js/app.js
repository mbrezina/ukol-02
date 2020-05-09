"use strict";

//var elementVyrok = document.querySelector("#vyrok");
//elementVyrok.innerText = "Testing if it works";
let obrazekJidla = document.querySelector(".obrazek_jidla")
let popis_Jidla = document.querySelector("#popisJidla");
let nazevJidla = document.querySelector("#nazevJidla");


function nactiJidlo() {
    var httpKlient = new XMLHttpRequest();
    httpKlient.onload = hotovo;
    httpKlient.onerror = chyba;
    httpKlient.open("GET", "nahodny", true);
    httpKlient.send();
}

function hotovo() {
    console.log("toto je this.response " + this.response);
    console.log("toto je popis: " + this.response["popis"]);
    console.log("toto je název: " + this.response.nazev);

    var jsonData = this.response.clientDataJSON;
    console.log("hodnota z json data value: " + jsonData['popis']);
    console.log("hodnota z json data value: " + jsonData.hasOwnProperty(popis_Jidla));

    popisJidla.innerText = this.response
    console.log("další pokus " + this.response.valueOf("popis"));
    //console.log(this.response);

    console.log("toto je popis: " + this.response.popis);
    nazevJidla.innerText = this.response.nazev;

    obrazekJidla.src = "images/" + this.response.index + ".jpg"

}

function chyba(err) {
    alert("Nastala chyba při komunikaci se serverem: " + err);
}
