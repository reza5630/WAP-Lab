window.addEventListener("error", handleError, true);

function handleError(evt) {
    if (evt.message) { // Chrome sometimes provides this
        console.log("error: "+evt.message +" at linenumber: "+evt.lineno+" of file: "+evt.filename);
        alert("error: "+evt.message +" at linenumber: "+evt.lineno+" of file: "+evt.filename);
    } else {
        console.log("error: "+evt.type+" from element: "+(evt.target || evt.srcElement) + evt.message)
        alert("error: "+evt.type+" from element: "+(evt.target || evt.srcElement)+ evt.message);
    }
}

function gogogo() {
    alert("Yay, it works!");
}