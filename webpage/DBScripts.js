let AnimalsArray = [];
let KeepersArray = [];
let EnclosuresArray = [];

let testData = [
    {
        "test1": "1",
        "test2": "2",
        "test3": "3",
        "test4": "4",
        "test5": "5"
    },
    {
        "test1": "1",
        "test2": "2",
        "test3": "3",
        "test4": "4",
        "test5": "5"
    },
    {
        "test1": "1",
        "test2": "2",
        "test3": "3",
        "test4": "4",
        "test5": "5"
    }
]

function getTestData() {

    return testData;

}

function getAnimalsData(){
    var requestURL = 'http://192.168.1.200:8080/animals/allAnimals';
    var request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.setRequestHeader('Content-Type', 'application/json');
    request.setRequestHeader('Access-Control-Allow-Origin', '*');
    request.responseType = 'json'
    request.send();
   
    request.onload = function() {
       
        AnimalsArray = request.response;

    }
}

function getAnimalsArray(){

    return AnimalsArray;

}


function getKeepersData(){
    var requestURL = 'http://192.168.1.200:8080/keepers/allKeepers';
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
    var requestURL = 'http://192.168.1.200:8080/enclosures/allEnclosures';
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

function getEnclosureArray(){

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

    var tr = table.insertRow(-1);                   

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    for (var i = 0; i < JSONArray.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = JSONArray[i][col[j]];
        }
    }
    
    var divContainer = document.getElementById("textArea");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}