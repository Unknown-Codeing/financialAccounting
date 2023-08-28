/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function validationEmpty(elementId, elementName) {
    var value = document.getElementById(elementId).value.trim();
    if (value === '') {
        alert(elementName + " can'not be Empty!");
        document.getElementById(elementId).focus();
        return false;
    }
    return true;
}

function ajaxCall(method, url, data, destination, ishtml) {
    var xhttp = new XMLHttpRequest();
    // event
    xhttp.onload = function () {
        if (ishtml) {
            document.getElementById(destination).innerHTML = this.responseText;
        } else {
            document.getElementById(destination).value = this.responseText;
        }
    };
    xhttp.open(method, url, false);

    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
    xhttp.send(data);
}

//first time sales(process.jsp) just for down nav bar
function SalesLoader() {
    ajaxCall('POST', 'processController', 'process=sales', 'loader', 'html');
    lastsales();
}
// for last data
function lastsales() {
    ajaxCall('POST', 'processController', 'process=saleslast', 'dataLoader', 'html');
    disabelMaker();
}
// for bottom view button
function viewAllSales() {
    ajaxCall('POST', 'processController', 'process=Allsales', 'dataLoader', 'html');
    document.getElementById("newbtn").style.display = "none";
    document.getElementById("editbtn").style.display = "none";
    document.getElementById("deletebtn").style.display = "none";
}
//for table row data into input box
function dataToInput(element, miniProcess) {
    rowid = element.getAttribute('rowid');
    ajaxCall('POST', 'processController', 'process=EditViewData' + '&rowid=' + rowid + '&miniProcess=' + miniProcess, 'dataLoader', 'html');
    document.getElementById("newbtn").style.display = "block";
    document.getElementById("editbtn").style.display = "block";
    document.getElementById("deletebtn").style.display = "block";
}

//for update
function editTransaction() {

    disabelopner();
    btn = document.getElementById("submitUpdate").style.display = "block";
    btn = document.getElementById("submitNew").style.display = "none";
    document.getElementById("newbtn").disabled = true;
    document.getElementById("deletebtn").disabled = true;
    document.getElementById("viewbtn").disabled = true;
}

function UpdateTransaction(miniprocess) {

    var result = validationEmpty('name', 'Username')
            && validationEmpty('email', 'Email')
            && validationEmpty('phone', 'Phone number')
            && validationEmpty('course', 'Course');
    if (result) {
        var userid = document.getElementById("userid").value;
        var name = document.getElementById("name").value;
        var email = document.getElementById('email').value;
        var phone = document.getElementById('phone').value;
        var course = document.getElementById('course').value;

        var data = 'userid=' + userid + '&name=' + name + '&email=' + email + '&phone=' + phone + '&course=' + course + '&process=salesupdate' + '&miniProcess=' + miniprocess;

        ajaxCall('POST', 'processController', data, 'dataLoader', 'html');

        if (document.getElementById("UpdateDelete").value > 0) {
            alert("dataUpdated");
        }
//        SalesLoader();
        if (miniprocess === 'sales') {
            lastsales();
        } else {
            lastPurchase();
        }
        disabelMaker();
        document.getElementById("newbtn").disabled = false;
        document.getElementById("deletebtn").disabled = false;
        document.getElementById("viewbtn").disabled = false;
    }
    return false;
}
// for insert
function newTransaction() {
    document.getElementById("useridDiv").style.display = "none";
    document.getElementById("submitUpdate").style.display = "none";
    document.getElementById("submitNew").style.display = "block";
    var userid = document.getElementById("userid").value;
    var name = document.getElementById("name").value = "";
    var email = document.getElementById('email').value = "";
    var phone = document.getElementById('phone').value = "";

    var course = document.getElementById('course').value = "";
    disabelopner();
    document.getElementById("editbtn").disabled = true;
    document.getElementById("deletebtn").disabled = true;
    document.getElementById("viewbtn").disabled = true;

}

function AddTransaction(miniprocess) {
    var result = validationEmpty('name', 'Username')
            && validationEmpty('email', 'Email')
            && validationEmpty('phone', 'Phone number')
            && validationEmpty('course', 'Course');
    if (result) {

        var name = document.getElementById("name").value;
        var email = document.getElementById('email').value;
        var phone = document.getElementById('phone').value;
        var course = document.getElementById('course').value;

        data = 'name= ' + name + '&email=' + email + '&phone=' + phone + '&course=' + course + '&process=AddTransaction' + '&miniProcess=' + miniprocess;

        ajaxCall('POST', 'processController', data, 'dataLoader', 'html');

        if (document.getElementById("UpdateDelete").value > 0) {
            alert("dataInserted");
        }

        if (miniprocess === 'sales') {
            lastsales();
        } else {
            lastPurchase();
        }
    }
    document.getElementById("editbtn").disabled = false;
    document.getElementById("deletebtn").disabled = false;
    document.getElementById("viewbtn").disabled = false;
    document.getElementById("useridDiv").style.display = "block";
    return false;
}

function deleteTransaction(miniProcess) {
    var userid = document.getElementById("userid").value;
    var result = confirm("do you Want to delete this ?");

    if (result) {
        data = 'userid=' + userid + '&process=deleteSales' + '&miniProcess=' + miniProcess;
        ajaxCall('POST', 'processController', data, 'dataLoader', 'html');
        if (document.getElementById("UpdateDelete").value > 0) {
            alert("data deleted!");
        }
        if (miniProcess === 'sales') {
            lastsales();
        } else {
            lastPurchase();
        }
    }
}

//--------------------------purchase
function PurchaseLoader() {
    ajaxCall('POST', 'processController', 'process=purchase', 'loader', 'html');
    lastPurchase();
}
function lastPurchase() {
    ajaxCall('POST', 'processController', 'process=Purchaselast', 'dataLoader', 'html');
    disabelMaker();
}
function viewAllpurchase() {
    ajaxCall('POST', 'processController', 'process=AllPurchase', 'dataLoader', 'html');
}









function disabelopner() {
    var name = document.getElementById("name").disabled = false;
    var email = document.getElementById('email').disabled = false;
    var phone = document.getElementById('phone').disabled = false;
    var course = document.getElementById('course').disabled = false;
}
function disabelMaker() {
    var name = document.getElementById("name").disabled;
    var email = document.getElementById('email').disabled;
    var phone = document.getElementById('phone').disabled;
    var course = document.getElementById('course').disabled;
}
function cancelBTN() {
    document.getElementById("editbtn").disabled = false;
    document.getElementById("deletebtn").disabled = false;
    document.getElementById("viewbtn").disabled = false;
    document.getElementById("newbtn").disabled = false;
    lastsales();
}