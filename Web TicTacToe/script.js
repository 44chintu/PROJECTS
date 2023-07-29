console.log("Welcome to TicTacToe");
let music = new Audio("music.mp3");
let mark = new Audio("mark.mp3");
let gameovermusic = new Audio("win.mp3");
let turn = "X";
let gameover = false;

//Changing the Turn of players
const changeTurn = () =>{
    return turn === "X" ? "0" : "X";
}

//Checking the winning conditions everytime player marks
const checkWin = () =>{
    let boxtexts = document.getElementsByClassName("box");
    Array.from(boxtexts).forEach(e =>{

        //Rows
        if((boxtexts[0].innerText === boxtexts[1].innerText) && (boxtexts[0].innerText === boxtexts[2].innerText) && (boxtexts[0].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[0].innerText +" has Won";
            gameover = true;
        }
        else if((boxtexts[3].innerText === boxtexts[4].innerText) && (boxtexts[3].innerText === boxtexts[5].innerText) && (boxtexts[3].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[3].innerText +" has Won";
            gameover = true;
        }
        else if((boxtexts[6].innerText === boxtexts[7].innerText) && (boxtexts[6].innerText === boxtexts[8].innerText) && (boxtexts[6].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[6].innerText +" has Won";
            gameover = true;
        }
        
        //Columns
        else if((boxtexts[0].innerText === boxtexts[3].innerText) && (boxtexts[0].innerText === boxtexts[6].innerText) && (boxtexts[0].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[0].innerText +" has Won";
            gameover = true;
        }

        else if((boxtexts[1].innerText === boxtexts[4].innerText) && (boxtexts[1].innerText === boxtexts[7].innerText) && (boxtexts[1].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[1].innerText +" has Won";
            gameover = true;
        }

        else if((boxtexts[2].innerText === boxtexts[5].innerText) && (boxtexts[2].innerText === boxtexts[8].innerText) && (boxtexts[2].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[2].innerText +" has Won";
            gameover = true;
        }

        //Diagonals
        else if((boxtexts[0].innerText === boxtexts[4].innerText) && (boxtexts[0].innerText === boxtexts[8].innerText) && (boxtexts[0].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[0].innerText +" has Won";
            gameover = true;
        }

        else if((boxtexts[2].innerText === boxtexts[4].innerText) && (boxtexts[2].innerText === boxtexts[6].innerText) && (boxtexts[2].innerText !== "")){
            document.getElementsByClassName("info")[0].innerText = "Player "+ boxtexts[0].innerText +" has Won";
            gameover = true;
        }
    })

}

const checkDraw = () =>{
    if((boxtexts[0]!= '') && (boxtexts[1]!= '') && (boxtexts[2]!= '') && (boxtexts[3]!= '') && (boxtexts[4]!= '') && (boxtexts[5]!= '') && (boxtexts[6]!= '') && (boxtexts[7]!= '') && (boxtexts[8]!= '') && (boxtexts[9]!= '')){
            document.getElementsByClassName("info")[0].innerText = "Game Tied!!!!  Reset To Play Again";
            gameover = true;
        }
}

//Adding Event listener and marking
let boxes = document.getElementsByClassName("box");
Array.from(boxes).forEach(element =>{
    element.addEventListener('click',()=>{
        if(element.innerText === ""){
            mark.play();
            element.innerHTML = turn;
            turn = changeTurn();
            checkWin();
            if(!gameover){
                document.getElementsByClassName("info")[0].innerText = "Turn of "+turn;
            }
            else{
                document.getElementById("image").style.display = "flex";
                gameovermusic.play();
            }
        }    
    })
})

let reset = document.querySelector("#reset");
reset.addEventListener('click',()=>{
    let boxes = document.getElementsByClassName("box");
    Array.from(boxes).forEach(e =>{
        e.innerText = "";
        gameover = false;
        document.getElementById("image").style.display = "none";
        document.getElementsByClassName("info")[0].innerText = "Turn of "+turn;
    })
})


