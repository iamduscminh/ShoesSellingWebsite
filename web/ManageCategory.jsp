<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Manager</title>
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link rel="stylesheet" href="./assets/css/main.css" />
        <link rel="stylesheet" href="./assets/css/manager.css" />
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="main"> 
            <div class="cart-footer d-flex mt-30">
                <div class="back-to-shop w-50">
                  <a href="createcategory">Create Category</a>
                  <a href="manage">Back to menu</a>
                </div>
          </div>  
        <table class="table">
            <thead>
                <tr>
                    <th>Category Id</th>
                    <th>Category Name</th>
                    
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${prdCates}" var="c">     
                <tr>
                    <td class="">${c.ctgId}</td>
                    <td>
                        <h4>${c.ctgName}</h4>
                    </td>
                      <td class="">
                            <a href="deletecategory?ctgid=${c.ctgId}"><i style="font-size: 19px; text-align: center" class="fas fa-trash-alt"></i></a> 
                      </td>
                      <td class="">
                            <a href="updatecategory?ctgid=${c.ctgId}"><i style="font-size: 19px; text-align: center" class="fas fa-edit"></i></a> 
                      </td>
                    </tr>
                </c:forEach>    
                  </tbody>
                </table>
                      
        </div>
    </body>
</html>
