let AnimalsArray = [];
let KeepersArray = [];
let EnclosuresArray = [];

function getAnimalsData(){
    var requestURL = 'http://localhost:8080/animals/allAnimals';
    var request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.setRequestHeader('Access-Control-Allow-Headers', '*');
    request.setRequestHeader('Access-Control-Allow-Origin', '*');
    request.setRequestHeader('Content-Type', 'application/json');
    
    request.responseType = 'json'
    request.send();
   
    request.onload = function() {
       
        AnimalsArray = request.response;

    }
}

function updateAnimalNotes(){

    let json = getNotesData();

    for(i = 1; i <= json.length; i++){
        let url = "http://localhost:8080/animals/animal/" + i;
        let xhr = new XMLHttpRequest();
        xhr.open("PUT", url, true);
        xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
        
        xhr.send(json[i-1]);
    }
    saveSuccess();
}

function getAnimalsArray(){

    return AnimalsArray;

}


function getKeepersData(){
    var requestURL = 'http://localhost:8080/keepers/allKeepers';
    var request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.setRequestHeader('Content-Type', 'application/json');
    request.setRequestHeader('Access-Control-Allow-Origin', '*');
    request.responseType = 'json'
    request.send();
   
    request.onload = function() {
       
        KeepersArray = request.response;

    }
}

function getKeepersArray(){

    return KeepersArray;

}

function getEnclosureData(){
    var requestURL = 'http://localhost:8080/enclosures/allEnclosures';
    var request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.setRequestHeader('Content-Type', 'application/json');
    request.setRequestHeader('Access-Control-Allow-Origin', '*');
    request.responseType = 'json'
    request.send();
   
    request.onload = function() {
       
        EnclosuresArray = request.response;

    }
}

function getEnclosuresArray(){

    return EnclosuresArray;

}
function getAllData(){

    getAnimalsData();
    getKeepersData();
    getEnclosureData();

}


function createTableFromJSON(JSONArray) {

    var col = [];
    for (var i = 0; i < JSONArray.length; i++) {
        for (var key in JSONArray[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    var table = document.createElement("table");

    var tr = table.insertRow();                   

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      
        th.innerHTML = col[i];
        if(th.innerHTML == "speices"){
            th.innerHTML = "species";
        }
        tr.appendChild(th);
    }

    for (var i = 0; i < JSONArray.length; i++) {

        tr = table.insertRow();

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell();
            tabCell.innerHTML = JSONArray[i][col[j]];
            if(col[j] == "notes"){

                tabCell.outerHTML = "<input value = '" + JSONArray[i][col[j]] + "' id = 'notes" + i + "' />"
            }
            if(col[j] == "enclosureID"){
                for(k = 0; k < EnclosuresArray.length; k++){
                    if(EnclosuresArray[k].id == JSONArray[i][col[j]]) {

                         tabCell.innerHTML = EnclosuresArray[k].name;

                    }
                }
            }
            if(col[j] == "keeperID"){
                for(k = 0; k < KeepersArray.length; k++){
                    if(KeepersArray[k].id == JSONArray[i][col[j]]) {

                         tabCell.innerHTML = KeepersArray[k].name;

                    }
                }
            }
        }
    }
    
    var divContainer = document.getElementById("textArea");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
    
}

function getNotesData() {

    let notesJSON = [];
    let temp = "";

    for(i = 0; i < AnimalsArray.length; i++) {

       temp = AnimalsArray[i]; 

       temp.notes = document.getElementById('notes' + i).value;
       notesJSON.push(JSON.stringify(temp));

    }
    
    return notesJSON;
   
}

function saveSuccess() {

    document.getElementById("Notification").innerHTML = "Save Successful!";

}

