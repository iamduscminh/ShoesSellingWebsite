<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${prdDetail.prdName}</title>
    <link rel="stylesheet" href="./assets/css/base.css" />
    <link rel="stylesheet" href="./assets/css/main.css" />
    <link rel="stylesheet" href="./assets/css/product.css" />
    <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>   
     <div class="product__container">
      <div class="col-xs-12 col-sm-12 col-md-12 category__container">
        <div class="category__top">
          <a href="home">Home</a>
          <a href="products">Shoes</a>
          <a href="#"><strong>${prdDetail.prdName}</strong></a>
        </div>
      </div>
      <!-- Product content -->
      <div class="col-xs-12 col-sm-12 col-md-7 g">
        <div class="wrapper-img">
          <div class="prd-main-img">
            <img class="main-img" src="${prdImgs[0]}" />
          </div>
          <div class="prd-detail-img">
            <div class="prd-detail-img__item" style="width: 160px">
              <img src="${prdImgs[0]}" />
            </div>
            <div class="prd-detail-img__item" style="width: 160px">
              <img src="${prdImgs[1]}" />
            </div>
            <div class="prd-detail-img__item" style="width: 160px">
              <img src="${prdImgs[2]}" />
            </div>
            <div class="prd-detail-img__item" style="width: 160px">
              <img src="${prdImgs[3]}" />
            </div>
          </div>
        </div>
      </div>
      <div class="col-xs-12 col-sm-12 col-md-5 prd-detail-right">
    <form name="input" action="cart" method="post">    
        <h4>${prdDetail.prdName}</h4>
        <h6 class="detail1">
          <span class="pull-left">Mã sản phẩm: <strong>${prdDetail.prdId}</strong></span>
          <c:if test="${prdDetail.prdStatus!=null}">  
            <span class="pull-right">Tình trạng: <strong>${prdDetail.prdStatus}</strong></span>
          </c:if>
        </h6>
        <h5 class="detail1">
          <span class="saleprice">${prdDetail.prdPrice} đ</span>
        </h5>
        <div class="divider"></div>
        <h6 class="detail1">
          ${prdDetail.prdDescription}
        </h6>
        <div class="divider"></div>
        <div class="color">
          <ul class="nav tree">
            <li class="cb-color-fixed">
              <label data-link=""
                ><span class="bg-color" style="background-color: #656344"></span>
              </label>
            </li>
          </ul>
        </div>
        <div class="divider"></div>
        
        <!--  -->
        <div class="prd-option-user-number clearfix">
          <div class="col-xs-12 col-sm-6 col-md-6">
            <h5>SIZE</h5>
            <select
              id="pickSize"
              class="selectpicker"
              name="prdSize"
            >
              <option selected="">&nbsp;</option>
            <c:forEach items="${sizes}" var="s">    
              <option>${s}</option>
            </c:forEach>
            </select>
          </div>
          <div class="col-xs-12 col-sm-6 col-md-6">
            ${cartMess}
          </div>
        </div>
        <!--  -->
        <c:if test="${sessionScope.account.isRole()}">
        <div class="grp-btn1">
         <input type="hidden" name="prdId" value="${prdDetail.prdId}">
         <input type="submit" class="btn btn-addcart clearfix"
            id="addProductToCart" value="THÊM VÀO GIỎ HÀNG" >
          
          <a
            href="#"
            data-idproduct="26314"
            class="btn btn-like addToWishList clearfix"
          >
            <i class="far fa-heart"></i>
          </a>
        </div>
       </form>   
        
        <div class="grp-btn2">
          <a
            href="loadcart"  
            data-url-cart="loadcart"
            id="pickOrder"
            data-ananas-validations=""
            class="btn btn-checkout"
            >THANH TOÁN</a
          >
        </div>
        </c:if> 
      </div>
    </div>
        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="./assets/js/product.js"></script>
    </body>
</html>
