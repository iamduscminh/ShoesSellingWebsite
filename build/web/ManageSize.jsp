<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="util.HtmlHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Size Manager</title>
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
            <form action="mnsizesearch" method="post" class="input-group search-bar" role="search">
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
                  <a href="createsize">Create Size</a>
                  <a href="managesize">Reload List</a>
                  <a href="manage">Back to menu</a>
                </div>
        </div>    
            
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Size</th>
                    <th>Amount</th>
                    
                    <th>Delete</th>
                   
                </tr>
            </thead>
            <tbody>
            <c:if test="${products.size()==0}">
            <h3>${mess}</h3>
            </c:if>
                <c:forEach items="${sizes}" var="s">     
                <tr>
                    <td class=""><span>${s.prdId}</span></td>
                    <td class=""><span>${s.prdSize}</span></td>
                    <td class=""><span>${s.prdAmount}</span></td>
                    <td class="">
                        <a href="deletesize?prdid=${s.prdId}&prdsize=${s.prdSize}&prdamount=${s.prdAmount}"><i style="font-size: 19px; text-align: center" class="fas fa-trash-alt"></i></a> 
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
