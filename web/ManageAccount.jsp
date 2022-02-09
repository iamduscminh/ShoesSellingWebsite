<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="util.HtmlHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Management</title>
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link rel="stylesheet" href="./assets/css/main.css" />
        <link rel="stylesheet" href="./assets/css/manager.css" />
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
          Integer pageindex = (Integer)request.getAttribute("pageindex");
          Integer totalpage = (Integer)request.getAttribute("totalpage");
        %>
        <jsp:include page="Header.jsp"></jsp:include>
        <div class="main">
        <div id="nav__searchbox" class="nav__searchbox">
            <form action="mnaccsearch" method="post" class="input-group search-bar" role="search">
                <input
                    type="text"
                    name="query"
                    value=""
                    autocomplete="off"
                    placeholder="Tìm kiếm..."
                    class="input-group-field"
                    />
                <button type="submit" class="btn">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>    
        <div class="cart-footer d-flex mt-30">
                <div class="back-to-shop w-50">
                  <a href="manageaccount">Reload List</a>
                  <a href="manage">Back to menu</a>
                </div>
        </div>    
            
        <table class="table">
            <thead>
                <tr>
                    <th>Account ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${accounts.size()==0}">
            <h3>${mess}</h3>
            </c:if>
                <c:forEach items="${accounts}" var="a">     
                <tr>
                      <td class=""><span>${a.accId}</span></td>
                      <td class=""><span>${a.username}</span></td>
                      <td class=""><span>${a.password}</span></td>
                      <td class=""><span>${a.firstName}</span></td>
                      <td class=""><span>${a.lastName}</span></td>
                      <td class=""><span>${a.isRole() ? "User" : "Admin"}</span></td>
                      <td class="">
                            <a href="deleteaccount?accid=${a.accId}"><i style="font-size: 19px; text-align: center" class="fas fa-trash-alt"></i></a> 
                      </td>
                      <td class="">
                            <a href="updateaccount?accid=${a.accId}"><i style="font-size: 19px; text-align: center" class="fas fa-edit"></i></a> 
                      </td>
                    </tr>
                </c:forEach>    
                  </tbody>
                </table>
             
        <c:if test="${requestScope.pageindex !=null}" >
          <div class="category-right-bottom">
            <div class="section pagenav">
              <nav class="clearfix relative nav_pagi w_100">
                <ul class="row pagination clearfix">
                  <li class="page-item disabled">
                    <a class="page-link" href="#"><i class="fa fa-angle-left"></i></a>
                  </li>
                  
                    <%=HtmlHelper.pager(10, pageindex, totalpage) %> 
                   
                  <li class="page-item hidden-xs">
                      <a class="page-link"><i class="fa fa-angle-right"></i></a>
                  </li>
                </ul>
              </nav>
             
            </div>
          </div>
        </c:if>   
        </div>
    </body>
</html>
