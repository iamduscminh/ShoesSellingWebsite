
<%@page import="util.HtmlHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        
        <title>Shoes</title>
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link rel="stylesheet" href="./assets/css/main.css" />
        <link rel="stylesheet" href="./assets/css/category.css" />
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    </head>
    <body>
         <%
          
          Integer pageindex = (Integer)request.getAttribute("pageindex");
          Integer totalpage = (Integer)request.getAttribute("totalpage");
      %>
        <jsp:include page="Header.jsp"></jsp:include>
        <div class = "main">
             <!-- Category -->
    <section class="category">
      <div class="category__container">
        <div class="category__top">
          <a href="home">Home</a>
          <a href="products">Shoes</a>
        <c:if test="${topNavSelect == null}" >
            <a href="#"><strong>All</strong></a>
        </c:if> 
          <a href="#"><strong>${topNavSelect}</strong></a>
        </div>
      </div>
      <div class="row category__container">
        <div class="category-left">
          <ul>
            <li class="category-left-li">
              <label>STATUS  <i class="fas fa-caret-down"></i></label>
              <ul>
                <c:forEach items="${statuses}" var="s" varStatus="loop"> 
                    <li><a href="category?stid=${loop.index}">${s}</a></li>
                </c:forEach>
<!--                <li><a href="">Limited Edition </a></li>
                <li><a href="">Online Only</a></li>
                <li><a href="">Sale off</a></li>
                <li><a href="">Best Seller</a></li>
                <li><a href="">New Arrival</a></li>-->
              </ul>
            </li>
            <li class="category-left-li">
              <label>FORM  <i class="fas fa-caret-down"></i></label>
              <ul>
                <li><a href="category?fid=low">Low</a></li>
                <li><a href="category?fid=mid">Mid</a></li>
                <li><a href="category?fid=high">High</a></li>
              </ul>
            </li>
            <li class="category-left-li">
              <label>CATEGORY  <i class="fas fa-caret-down"></i></label>
              <ul>
                
                <c:forEach items="${prdCates}" var="c"> 
                    <li><a href="category?cid=${c.getCtgId()}">${c.getCtgName()}</a></li>
                </c:forEach>
              </ul>
            </li>
            <li class="category-left-li">
              <label>COLLECTION  <i class="fas fa-caret-down"></i></label>
              <ul>
                <c:forEach items="${collections}" var="c"> 
                    <li><a href="category?cltid=${c.getCltId()}&cltname=${c.getCltName()}">${c.getCltName()}</a></li>
                </c:forEach>
              </ul>
            </li>
            <li class="category-left-li">
              <label>PRICE  <i class="fas fa-caret-down"></i></label>
              <ul>
                <li><a href="category?pid=1">400k - 499k</a></li>
                <li><a href="category?pid=2">500k - 599k</a></li>
                <li><a href="category?pid=3">> 600k</a></li>

              </ul>
            </li>
          </ul>
        </div>
        <div class="category-right">
          <div class="row category-right-top">
            <div class="category-right-top-item"><p>${mess}</p></div>
            <div class="category-right-top-item">
             
            </div>
            <div class="category-right-top-item">
            
            </div>
          </div>
            
          <div class="category-right__content row">
                       
          <c:forEach items="${products}" var="p">    
            
                 
              
            <div class="category-right__item">
              <div class="ProductCard">
                <a data-component="" href="detail?id=${p.prdId}" class="ProductCardLink"
                  ><div class="ProductCardHeader">
                    <div class="ProductCardImageContainer">
                      <img
                        alt=""
                        class="ProductCardImagePrimary"
                        width="280"
                        height="280"
                        src="${p.prdImgv}"
                      />
                    </div>
                <meta
                    itemprop="image"
                    content="${p.prdImgv}"
                />
                <meta
                    itemprop="image"
                    content="${p.get2ndImgSrc()}"
                />      
                  </div>
                  <div class="ProductCardInfo">
                    <div class="ProductCardInfoClamp">
                      <p class="ProductCardBrandName">${p.prdName}</p>
                      <p class="ProductCardColor"></p>
                    </div>
                    <div class="PriceBrief">
                      <p class="Price">${p.prdPrice}đ</p>
                    </div>
                  </div>
                </a>
              </div>
            </div>
            </c:forEach>   
          </div>
           
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
      </div>
    </section>
 </div>
         <jsp:include page="Footer.jsp"></jsp:include>
         <script src="./assets/js/main.js"></script>

    </body>
</html>
