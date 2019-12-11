"use strict"
let timer = null
let speed = 250

window.onload = function() {
    document.getElementById("animation").onchange = changeAnimation
    document.getElementById("fontsize").onchange = changeFontsize
    document.getElementById("turbo").onchange = activateTurboMode
    document.getElementById("start").onclick = startAnimation
    document.getElementById("stop").onclick = stopAnimation
}

function changeAnimation() {
    document.getElementById("text-area").value = ANIMATIONS[document.getElementById("animation").value]
    if(ANIMATIONS[document.getElementById("animation").value] === "")
        document.getElementById("start").disabled = true
    else
        document.getElementById("start").disabled = false
}

function changeFontsize() {
    document.getElementById("text-area").style.fontSize = document.getElementById("fontsize").value
}

function activateTurboMode() {
    if(document.getElementById("turbo").checked)
        speed = 50
    else
        speed = 250
}

function startAnimation() {
    document.getElementById("start").disabled = true
    document.getElementById("stop").disabled = false
    document.getElementById("animation").disabled = true


    let images = ANIMATIONS[document.getElementById("animation").value].split("=====")
    runAnimation(images)
}

function runAnimation(images, index = 0){
    document.getElementById("text-area").value = images[index % images.length]
    timer = setTimeout(runAnimation, speed, images, ++index)
}

function stopAnimation() {
    if(timer)   clearTimeout(timer)
    document.getElementById("stop").disabled = true
    document.getElementById("start").disabled = false
    document.getElementById("animation").disabled = false

    document.getElementById("text-area").value = ANIMATIONS[document.getElementById("animation").value]
}