function plus(elem) {
    let quantite = elem.parentNode.getElementsByTagName("input");
    let inputVal = quantite[0].value;
    inputVal++;
    quantite[0].value = inputVal;
}

function minus(elem){
    let quantite = elem.parentNode.getElementsByTagName("input");
    let inputVal = quantite[0].value;
    if(inputVal>1) {
        inputVal--;
        quantite[0].value = inputVal;
    }    
}