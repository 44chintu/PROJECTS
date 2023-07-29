const settingsEle = document.querySelector("#settingsIcon");
const contentEle = document.querySelector(".settings-content");
const primary = document.querySelector(".primary-container");
const secondary = document.querySelector(".secondary-container");
const inputDOB = document.querySelector("#inputdob");
const addDOBButton = document.querySelector("#dobButton");
let DOB;
let settingsEleOpen = false;
const yearEle = document.querySelector("#year");
const monthEle = document.querySelector("#month");
const dayEle = document.querySelector("#day");
const hourEle = document.querySelector("#hour");
const minuteEle = document.querySelector("#minute");
const secondEle = document.querySelector("#second");


const settingsClicked = ()=>{
    if(settingsEleOpen){
        contentEle.classList.add("hide");
    }
    else{
        contentEle.classList.remove("hide");
    }
    settingsEleOpen = !settingsEleOpen;
};


const updateAge = (DOB)=>{
    const currentDate = new Date();
    const dateDiff = currentDate - DOB;
    const year = Math.floor(dateDiff / (1000 * 60 * 60 * 24 * 365));
    const month = Math.floor((dateDiff / (1000 * 60 * 60 * 24 * 365)) % 12);
    const day = Math.floor(dateDiff / (1000 * 60 * 60 * 24)) % 30;
    const hour = Math.floor(dateDiff / (1000 * 60 * 60)) % 24;
    const minute = Math.floor(dateDiff / (1000 * 60)) % 60;
    const second = Math.floor(dateDiff / 1000) % 60;

    yearEle.innerHTML = makeTwoDigitNumber(year);
    monthEle.innerHTML = makeTwoDigitNumber(month);
    dayEle.innerHTML = makeTwoDigitNumber(day);
    hourEle.innerHTML = makeTwoDigitNumber(hour);
    minuteEle.innerHTML = makeTwoDigitNumber(minute);
    secondEle.innerHTML = makeTwoDigitNumber(second);
};

const makeTwoDigitNumber = (number)=>{
    return number > 9 ? number : `0${number}`;
}

const addDOBButtonClicked = ()=>{
    const dateString = inputDOB.value;
    DOB = dateString ? new Date(dateString) : null;
    if(DOB){
        primary.classList.add("hide");
        secondary.classList.remove("hide");
        updateAge(DOB);
        setInterval(()=> {
            updateAge(DOB),1000
        });
    }
    else{
        secondary.classList.add("hide");
        primary.classList.remove("hide");
    }
};

settingsEle.addEventListener('click',settingsClicked); //Settings clicked for adding new dob
addDOBButton.addEventListener('click',addDOBButtonClicked); //Added new dob and display and update the live timer