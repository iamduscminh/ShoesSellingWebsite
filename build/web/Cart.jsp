<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Giỏ Hàng - Ananas</title>
    <link rel="stylesheet" href="./assets/css/base.css" />
    <link rel="stylesheet" href="./assets/css/main.css" />
    <link rel="stylesheet" href="./assets/css/cart.css" />
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
                      <th>Shoe</th>
                      <th>Size</th>
                      <th>Price</th>
                      <th>Quantity</th>
                      <th>Total</th>
                      <th>Delete</th>
                    </tr>
                  </thead>
                  <tbody>
              <c:if test="${orders.size()!=0}">
                <c:forEach items="${orders}" var="o">      
                    <tr>
                      <td class="cart_product_img d-flex align-items-center">
                        <a href="detail?id=${o.getPrdId()}"><img src="${o.getPrdImg()}" alt="Product" /></a>
                        <h6>${o.getPrdName()}</h6>
                        
                      </td>
                      <td class="size"><span>${o.getPrdSize()}</span></td>
                      <td class="unitPrice" value="${o.getPrdPrice()}"><span>${o.getPrdPrice()}</span>đ</td>
                      <td class="qty">
                        <div class="quantity">
                          <span
                            class="qty-minus"
                            
                            ><i class="fa fa-minus" aria-hidden="true"></i
                          ></span>
                          <input
                            type="number"
                            class="qty-text"
                            id="qty"
                            step="1"
                            min="1"
                            max="${o.getMaxQuantity()}"
                            name="quantity"
                            value="${o.getPrdQuantity()}"
                          />
                          <span
                            class="qty-plus"
                            
                            ><i class="fa fa-plus" aria-hidden="true"></i
                          ></span>
                        </div>
                      </td>
                      <td class="totalPrice-row"><span>${o.getPrdPrice()}</span>đ</td>
                      <td class="total_price"><span><a href="deletecart?dltId=${o.getOrdId()}">
                             <i style="font-size: 19px; text-align: center" class="far fa-times-circle"></i></a></span>
                      </td>

                    </tr>

                </c:forEach> 
                </c:if>     
                  </tbody>
                </table>
              </div>
                <c:if test="${orders.size()==0}"> 
                  <strong><h2 style="text-align: left;margin-top: 32px;margin-bottom: 32px;">Cart empty...Add something for you!</h2></strong>
                 </c:if> 
              <div class="cart-footer d-flex mt-30">
                  
                <div class="back-to-shop w-50">
                  <a href="products">Continue shooping</a>
                </div>
                <div class="update-checkout w-50 text-right">
                  <a href="deleteallcart?did=0">clear all cart</a>
                  <a href="loadcart">Update cart</a>
                  <a href="historycart">history cart</a>
                </div>
              </div>
            </div>
          </div>

          <div class="row mb-50">
            <div class="col-12 col-md-12 col-lg-12">
              <div class="cart-total-area mt-70">
                <div class="cart-page-heading">
                  <h5>Cart total</h5>
                  <p>Final info</p>
                </div>

                <ul class="cart-total-chart">
                  <li><span>Subtotal</span> <span  class="totalPrice-all">0</span></li>
                  <li><span>Shipping</span> <span>Free</span></li>
                  <li>
                    <span><strong>Total</strong></span> <strong><span class="totalPrice-all">0</span>đ</strong>
                  </li>
                </ul>
                <a href="handlecart" class="btn karl-checkout-btn">Proceed to checkout</a>
                <h2 style="margin-top: 35px;">${successMess}</h2>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
         
   <jsp:include page="Footer.jsp"></jsp:include>
   <script>
    quantityMinus = document.getElementsByClassName("qty-minus");
    quantityPlus = document.getElementsByClassName("qty-plus");
    
    const totalRows = document.querySelectorAll(".totalPrice-row span"); 
    const totalAlls = document.querySelectorAll(".totalPrice-all");
    var totalAll = 0;
    [...totalRows].forEach((item, index) =>{
      totalAll += (Number)(item.innerHTML); 
    })
    totalAlls[0].innerHTML = totalAll;
    totalAlls[1].innerHTML = totalAll;  

    [...quantityMinus].forEach((item,index) =>
      item.addEventListener("click", function (e) {
        const effect = document.getElementsByClassName('qty-text')[index]; 
      const qty = effect.value;
      const totalRow = document.querySelectorAll(".totalPrice-row span")[index];
      const Price = document.getElementsByClassName("unitPrice")[index].getAttribute("value");
      
      if( !isNaN( qty ) && qty <2 ) return;
      const total =(Number)(Price) * (Number(qty)-1); 
      totalRow.innerHTML = total;
      const totalRows = document.querySelectorAll(".totalPrice-row span"); 
      const totalAlls = document.querySelectorAll(".totalPrice-all");
      var totalAll = 0;
      [...totalRows].forEach((item, index) =>{
        totalAll += (Number)(item.innerHTML); 
      })
      totalAlls[0].innerHTML = totalAll;
      totalAlls[1].innerHTML = totalAll;  
      effect.value--;
      })
    );

   [...quantityPlus].forEach((item, index) =>
    item.addEventListener("click", function (e) {
    const effect = document.getElementsByClassName("qty-text")[index];
    const qty = effect.value;
    const max = effect.getAttribute("max");
    const totalRow = document.querySelectorAll(".totalPrice-row span")[index];
    const Price = document.getElementsByClassName("unitPrice")[index].getAttribute("value");

    if (!isNaN(qty) && qty > max - 1) return;
    var total =(Number)(Price) * (Number(qty)+1); 
    totalRow.innerHTML = total;
    const totalRows = document.querySelectorAll(".totalPrice-row span"); 
    const totalAlls = document.querySelectorAll(".totalPrice-all");
    var totalAll = 0;
    [...totalRows].forEach((item, index) =>{
      totalAll += (Number)(item.innerHTML); 
    })
    totalAlls[0].innerHTML = totalAll;
    totalAlls[1].innerHTML = totalAll;
    effect.value++;
    })
  );
   </script>
    <script src="./assets/js/main.js"></script>
 </body>
</html>
