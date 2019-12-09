interval = null

window.onload = function () {
    document.getElementById("buttonClicked").onclick = buttonClicked
    document.getElementById("boxChecked").onclick = boxChecked
    document.getElementById("stopThisMadness").onclick = stopThisMadness
    document.getElementById("convertLatin").onclick = translateLatin
    document.getElementById("convertMalkovitch").onclick = translateMalkovitch
}

function boxChecked() {
    alert("boxChecked!")
    if (document.getElementById("boxChecked").checked === true) {
        document.body.style.backgroundImage = "url('http://www.cs.washington.edu/education/courses/190m/CurrentQtr/labs/6/hundred-dollar-bill.jpg')";
        document.getElementById("textbook").style.fontWeight = 'bold'
        document.getElementById("textbook").style.color = 'green'
        document.getElementById("textbook").style.textDecoration = 'underline'
    } else {
        document.body.style.backgroundImage = 'none'
        document.getElementById("textbook").style.fontWeight = 'normal'
        document.getElementById("textbook").style.color = 'black'
        document.getElementById("textbook").style.textDecoration = 'none'
    }
}

function buttonClicked() {
    alert("buttonClicked!")
    interval = setInterval(function () {
        let currentSize = document.getElementById("textbook").style.fontSize;
        if (currentSize =='') currentSize = 14; //default font size
        console.log(currentSize)
        document.getElementById("textbook").style.fontSize = parseFloat(currentSize) + 2 + "pt";
    }, 500)

}

function stopThisMadness() {
    if (interval != null) {
        clearInterval(interval)
    }
	document.getElementById("textbook").style.fontSize = '14pt'
	document.getElementById("textbook").style.fontWeight = 'normal'
    document.getElementById("textbook").style.color = 'black'
    document.getElementById("textbook").style.textDecoration = 'none'
	document.getElementById("textbook").value = "At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies."
}


const VOWELS = ['a', 'e', 'i', 'o', 'u'];

function translateLatin() {
    let message = document.getElementById("textbook").value
    console.log(message)
    document.getElementById("textbook").value = message.split(' ').map(translateWord).join(' ');
}

function translateWord(word) {
    for(var i = 0; i < word.length; i++) {
        if(VOWELS.indexOf(word[i]) !== -1) break;
        if(word.slice(i, i+2) === 'qu') i += 1;
    };
    return word.slice(i) + word.slice(0, i) + 'ay';
}

function translateMalkovitch() {
    let message = document.getElementById("textbook").value
    console.log(message)
    document.getElementById("textbook").value = message.split(' ').map(wordToMalkovitch).join(' ');
}

function wordToMalkovitch(word) {
    if(word.length>4)
        return 'Malkovitch'
    else
        return word
}