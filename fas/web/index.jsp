<%-- 
    Document   : index
    Created on : 25-Aug-2023, 9:00:38 pm
    Author     : SWATANTRA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">     
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="SalesLoader()">sales</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="PurchaseLoader()">Purchase</a>
                </li>
              
            </ul>
          
        </div>
        <div class="w-50 ms-5 ps-5" id="loader"></div>
        <script src="common.js"></script>
    </body>
</html>
