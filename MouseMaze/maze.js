$(document).ready( function () {
    $("#start").click(start)
})
function start () {
    $(".boundary").removeClass("youlose");
    $(".boundary").mouseenter(gameOver)
    $("#maze").mouseleave(gameOver)
    $("#end").mouseenter(gameWin)
    $("#status").text("Reach \"E\" to win the game")
}

function gameOver () {
    $("#status").text("Click the \"S\" to begin.")
    $(".boundary").addClass("youlose");
    reset()
    alert("You lose! :[")
}

function gameWin() {
    $("#status").text("Click the \"S\" to begin.")
    reset()
    alert("You win! :]")
}

function reset() {
    $("#end").unbind("mouseenter")
    $(".boundary").unbind("mouseenter")
    $("#maze").unbind("mouseleave")
}