<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cart History - Ananas</title>
    <link rel="stylesheet" href="./assets/css/base.css" />
    <link rel="stylesheet" href="./assets/css/main.css" />
    <link rel="stylesheet" href="./assets/css/cartHistory.css" />
    <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    </head>
    <body>
    <jsp:include page="Header.jsp"></jsp:include>   
        
     <div class="container">
      <div class="cart_area section_padding_100 clearfix">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="cart-table clearfix">
                <table class="table table-responsive">
                  <thead>
                    <tr>
                      <th>Product</th>
                      <th>Size</th>
                      <th>Price</th>
                      <th>reAdd</th>
                      
                    </tr>
                  </thead>
                  <tbody>
                <c:forEach items="${orders}" var="o">     
                    <tr>
                      <td class="cart_product_img d-flex align-items-center">
                        <a href="detail?id=${o.getPrdId()}"><img src="${o.getPrdImg()}" alt="Product" /></a>
                        <h6>${o.getPrdName()}</h6>
                        
                      </td>
                      <td class="size"><span>${o.getPrdSize()}</span></td>
                      <td class="unitPrice" value = "20"><span>${o.getPrdPrice()}đ</span></td>
                      <td class="qty">
                        <div class="quantity">
                            <a href="readdcart?ordId=${o.getOrdId()}&prdId=${o.getPrdId()}&prdSize=${o.getPrdSize()}"><i class="fas fa-cart-plus"></i></a> 
                        </div>
                      </td>
                      
                    </tr>
                </c:forEach>    
                  </tbody>
                </table>
              </div>
              <c:if test="${orders.size()==0}"> 
                  <strong><h2 style="text-align: left;margin-top: 32px;margin-bottom: 32px;">Cart empty!</h2></strong>
                 </c:if> 
              <div class="cart-footer d-flex mt-30">
                <div class="back-to-shop w-50">
                  <a href="products">Continue shooping</a>
                </div>
                <div class="update-checkout w-50 text-right">
                  <a href="deleteallcart?did=1">clear history</a>
                  <a href="historycart">Update</a>
                </div>
              </div>
            </div>
          </div>

          <div class="footerHis">
            
          </div>
        </div>
      </div>
    </div>
         
   <jsp:include page="Footer.jsp"></jsp:include>
   
    <script src="./assets/js/main.js"></script>
 </body>
</html>