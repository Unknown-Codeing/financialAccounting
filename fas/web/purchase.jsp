<%-- 
    Document   : purchase
    Created on : 28-Aug-2023, 6:15:14 pm
    Author     : SWATANTRA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet" %>

<c:if  test="${ process eq 'purchase'}">
    <div id="dataLoader">

    </div> 
    <div class="d-flex justify-content-around">
        <button id="newbtn"  type="button" onclick="newTransaction()"   class="btn btn-warning" style="width: 68px" data-bs-target="#"  >New</button>
        <button id="editbtn" type="button" onclick="editTransaction()"   class="btn btn-warning" style="width: 68px" data-bs-target="#" >Edit</button>
        <button id="deletebtn" type="button" onclick="deleteTransaction('purchase')"   class="btn btn-warning" style="width: 68px" data-bs-target="#" >Delete</button>
        <button id="viewbtn" type="button" onclick="viewAllpurchase()"   class="btn btn-warning" style="width: 68px" data-bs-target="#" >View</button>

        <!--<input type="hidden"   onclick="newsales()" disabled   class="btn btn-warning" style="width: 68px" data-bs-target="#" >-->
    </c:if>

    <c:if test="${process eq 'Purchaselast' or process eq 'EditViewData' }">
        <%
            ResultSet result = (ResultSet) request.getAttribute("result");
            if (result.next()) {

        %>
        <form >

            <div id="useridDiv" class="form-group">
                <label for="name">User Id:</label>
                <input type="text" disabled id="userid" class="form-control"  name="id" value="<%=result.getInt("no")%>">
            </div><br/>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" disabled  class="form-control" id="name" name="name" value="<%=result.getString("name")%>">
            </div><br/>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" disabled class="form-control" id="email" name="address" value="<%=result.getString("email")%>">
            </div><br/>
            <div class="form-group">
                <label for="email">Email address:</label>
                <input type="email" disabled class="form-control" id="phone" name="email" value="<%=result.getString("phone")%>">
            </div><br/>
          
            <div class="form-group">
                <label for="city">COurse:</label>
                <input type="text" disabled class="form-control" id="course" name="city" value="<%=result.getString("course")%>">
            </div><br/>
            <%
                }
            %>
            <input id="submitNew" onclick="return AddTransaction('purchase')" type="button" style="display: none" value="Submit"> 
            <input id="submitUpdate" onclick="return UpdateTransaction('purchase')" type="button" style="display: none" value="edit submit"> 

        </form>

    </c:if>
            <c:if test="${process eq 'salesupdate' or process eq 'AddTransaction' or process eq 'deleteSales'}">
        <input type="hidden" value="${status}" id="UpdateDelete">
    </c:if>


    <c:if test="${process eq 'AllPurchase'}">

        <table class="table table-striped table-dark success">

            <thead>
                <tr>
                    <th>#</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>phone number</th>
                    <th>city</th>
                    <th>course</th>
                    <th>Edit/Delete</th>

                </tr>
            </thead> 
            <tbody>
                <%
                    ResultSet rs = (ResultSet) request.getAttribute("result");
                    int tmp = 0;
                    while (rs.next()) {

                %>

                <tr >

                    <td>  <%=++tmp%></td>
                    <td><%=rs.getString("name")%></td>
                    <td><%=rs.getString("email")%></td>
                    <td><%=rs.getString("phone")%></td>
                    <td><%=rs.getString("city")%></td>
                    <td><%=rs.getString("course")%></td>



                    <td><button type="button" onclick=" dataToInput(this,'purchase')" rowid="<%=rs.getString("no")%>"  class="btn btn-warning" style="width: 68px" data-bs-target="#" >View</button></td>
                </tr>
                <%
                    }
                %>

            </tbody>
        </table>
    </c:if>
