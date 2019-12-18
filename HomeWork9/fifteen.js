"use strict"

//adding jQuery lib
var script = document.createElement("script");
script.type = "text/javascript";
script.src = "https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js";
document.head.append(script)

var coordinates = []
var emptyPiece

window.onload = function () {
    init();
    $("#shufflebutton").click(shuffle)
}

function shuffle() {
    console.log("shuffle clicked")
    coordinates.sort(() => Math.random() - 0.5);
    $(".puzzlepiece").each(function (i) {
        $(this).css("left", coordinates[i][0] + 'px')
        $(this).css("top", coordinates[i][1] + 'px')
    })
    // $(".puzzlepiece").hover(checkOptions)
    $(".puzzlepiece").unbind()
    $(".puzzlepiece").mouseenter(addFeatures)
    $(".puzzlepiece").mouseleave(removeFeatures)
}

function addFeatures () {
    if(checkOptions($(this))) {
        console.log("adding features")
        $(this).addClass("testHover")
        $(this).click(swapPiece)
    }
}

function removeFeatures () {
    if(checkOptions($(this))){
        console.log("removing features")
        $(this).removeClass("testHover")
        $(this).unbind("click")
    }
}

function swapPiece(){
    var divId = parseInt($(this).text() - 1)

    var temp = coordinates[divId]
    coordinates[divId] = coordinates[15]
    coordinates[15] = temp

    console.log(" after swapping "+divId+" ("+ coordinates[divId]+") ("+coordinates[15]+")")

    $(this).css("left", coordinates[divId][0] + 'px')
    $(this).css("top", coordinates[divId][1] + 'px')
}

function checkOptions(piece){
	let myJsBug = parseInt(piece.position().top)

	if(myJsBug%2) {
		++myJsBug
		console.log("js bug detected. new top value "+myJsBug)
	}
	if(
        ((parseInt(piece.position().left) == coordinates[15][0] - 100 ||
        parseInt(piece.position().left) == coordinates[15][0] + 100) &&
		myJsBug == coordinates[15][1]) ||

        ((myJsBug == coordinates[15][1] - 100 ||
		myJsBug == coordinates[15][1] + 100) &&
        parseInt(piece.position().left) == coordinates[15][0]) ){

        return true

	}

	console.log("empty left "+coordinates[15][0]+" empty top "+coordinates[15][1])
	console.log("piece left "+parseInt(piece.position().left)+" piece top "+parseInt(piece.position().top))
	console.log(parseInt(piece.text())+" is not neighbour")
	return false

}

function init(){
    $("#puzzlearea div").each(function(i){

        // calculate x and y for this piece
        var x = ((i % 4) * 100);
        var y = (Math.floor(i / 4) * 100);

        // set basic style and background
        $(this).addClass("puzzlepiece");
        $(this).css("left", x + 'px');
        $(this).css("top", y + 'px');
        $(this).css("backgroundImage",'url("background.jpg")');
        $(this).css("backgroundPosition", -x + 'px ' + (-y) + 'px');

        // store x and y for later
        coordinates.push([x, y])
    })
    coordinates.push([300, 300])
}