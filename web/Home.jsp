
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Ananas-DiscoverYOU</title>

        <link rel="stylesheet" href="./assets/css/base.css" />
        <link rel="stylesheet" href="./assets/css/main.css" />
        <script src="https://kit.fontawesome.com/bc95aa25ab.js" crossorigin="anonymous"></script>
    </head>
    <body>
      <div class="main" id="main">

    <jsp:include page="Header.jsp"></jsp:include>     

      <!-- Main Slider -->
      <div class="slider">
        
        <ul class="slider-dots">
          <li class="slider-dot-item active" data-index="0"></li>
          <li class="slider-dot-item" data-index="1"></li>
          <li class="slider-dot-item" data-index="2"></li>
        </ul>
        <div class="slider-wrapper">
          <div class="slider-main">
            <div class="slider-item">
              <img src="./assets/img/Track-6_Suede_Moonphase_slide2.jpg" alt="" />
            </div>
            <div class="slider-item">
              <img src="./assets/img/Vintas-Temperate_slide1.jpg" alt="" />
            </div>
            <div class="slider-item"><img src="./assets/img/Hi-im-Mule_slide3.jpg" alt="" /></div>
          </div>
        </div>
       
      </div>
      <!-- End Slider -->
      <!-- ----------Section------------- -->
      <!-- section1 -->
      <div class="product-container section_base">
        <div class="content_sec clearfix">
          <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <div class="home_banner banner_img">
              <div
                class="image bg_img_module headingcol lazyload"
                title="CLASSIC"
                style="
                  background-image: url('./assets/img/ananas6-16105323831451950335892.jpg');
                  background-position-x: -110px;
                "
              >
                <a href="./assets/img/ananas6-16105323831451950335892.jpg"></a>
                <h2 class="title-base" title="CLASSIC">
                  <a href="products" class="headline">BEST SELLER</a>
                </h2>
                <span>Bộ sưu tập<br />Những phiên bản bán chạy nhất<br /></span>
                <a href="products" class="btn btn-primary btn-shop-now" title="Xem thêm"
                  >Xem thêm</a
                >
              </div>
            </div>
          </div>
          <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
            <div class="owl-carousel">
              <div class="owl-stage-outer">
                <div id="slider__carousel1" class="owl-stage">
                  <c:forEach items="${productsBestSe}" var="p"> 
                  <div class="owl-item">
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
              </div>
              <i id="prev-btn1" class="fa fa-angle-left prd-slider-btn prd-slider-prev"></i>
              <i id="next-btn1" class="fa fa-angle-right prd-slider-btn prd-slider-next"></i>
            </div>
          </div>
        </div>
      </div>
      <!--  -->
      <!-- section2 -->
      <div class="product-container section_base">
        <div class="content_sec clearfix">
          <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <div class="home_banner banner_img">
              <div
                class="image bg_img_module headingcol lazyload"
                data-src="//bizweb.dktcdn.net/100/140/774/themes/827866/assets/bg_module_2.jpg?1627104606592"
                title="CLASSIC"
                data-was-processed="true"
                style="
                  background-image: url('//bizweb.dktcdn.net/100/140/774/themes/827866/assets/bg_module_2.jpg?1627104606592');
                "
              >
                <h2 class="title-base" title="CLASSIC">
                  <a href="products" id="new-arrivals" class="headline">NEW ARRIVALS</a>
                </h2>
                <span>Bộ sưu tập<br />Những phiên bản mới nhất và đầy hứa hẹn<br /></span>
                <a href="products" class="btn btn-primary btn-shop-now" title="Xem thêm"
                  >Xem thêm</a
                >
              </div>
            </div>
          </div>
          <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
            <div class="owl-carousel">
              <div class="owl-stage-outer">
                <div id="slider__carousel2" class="owl-stage">
                  
                <c:forEach items="${productsNewArr}" var="p"> 
                  <div class="owl-item">
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
                <i id="prev-btn2" class="fa fa-angle-left prd-slider-btn prd-slider-prev"></i>
                <i id="next-btn2" class="fa fa-angle-right prd-slider-btn prd-slider-next"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--  -->
      <!-- section3 -->

      <div class="product-container section_base">
        <div class="content_sec clearfix">
          <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <div class="home_banner banner_img">
              <div
                class="image bg_img_module headingcol lazyload"
                style="
                  background-image: url('./assets/img/Ananas-Urbas-Love-Wins-Pride-Flag-2.png');
                "
              >
                <h2 class="title-base" title="CLASSIC">
                  <a href="products" class="headline">Pattas</a>
                </h2>
                <span>Bộ sưu tập cổ điển<br />Những phiên bản bất tử<br />từ năm 2010</span>
                <a href="products" class="btn btn-primary btn-shop-now" title="Xem thêm"
                  >Xem thêm</a
                >
              </div>
            </div>
          </div>
          <div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
            <div class="owl-carousel">
              <div class="owl-stage-outer">
                <div id="slider__carousel3" class="owl-stage">
                  
                <c:forEach items="${pattasclt}" var="p"> 
                  <div class="owl-item">
                    <div class="ProductCard">
                      <a data-component="" href="detail?id=${p.getPrdId()}" class="ProductCardLink"
                        ><div class="ProductCardHeader">
                          <div class="ProductCardImageContainer">
                            <img
                              alt=""
                              class="ProductCardImagePrimary"
                              width="280"
                              height="280"
                              src="${p.getPrdImgv()}"
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
                            <p class="ProductCardBrandName">${p.getPrdName()}</p>
                            <p class="ProductCardColor"></p>
                          </div>
                          <div class="PriceBrief">
                            <p class="Price">${p.getPrdPrice()}đ</p>
                          </div>
                        </div>
                      </a>
                    </div>
                  </div>
                  
                </c:forEach>   
                </div>
              </div>
              <i id="prev-btn3" class="fa fa-angle-left prd-slider-btn prd-slider-prev"></i>
              <i id="next-btn3" class="fa fa-angle-right prd-slider-btn prd-slider-next"></i>
            </div>
          </div>
        </div>
      </div>
      <!-- End Section -->
     <jsp:include page="Footer.jsp"></jsp:include>
    </div>

    <script src="./assets/js/main.js"></script>
    <script src="./assets/js/slider.js" type="module"></script>
    </body>
</html>
