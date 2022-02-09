
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!-- Hearder -->
      <div class="header-container">
        <div class="top-header">
          <div class="slogan">
            <span><i>More than a shoes...</i></span>
          </div>
          <div class="top-header__user">
            <div class="userHelp">
              <div class="pre-dropdown-menu">
                <div id="HelpMenuDropdown" class="HelpMenuDropdown">
                  <a href="#" class="pre-help-dropdown button body-4"><span>Help</span></a>

                  <div id="HelpMenuDropdown-menu" class="HelpMenuDropdown-menu-box">
                    <nav class="HelpMenuBox">
                      <a href="#" class="pre-help-dropdown button d-sm-b mb3-sm"
                        ><span>Help</span></a
                      >
                      <ul class="HelpMenuBox-content">
                        <li>
                          <a
                            class="pre-help-dropdown-menu-item body-3 u-bold"
                            href="https://www.nike.com/vn/orders"
                            >Contact Us</a
                          >
                        </li>
                        <li>
                          <a
                            class="pre-help-dropdown-menu-item body-3 u-bold"
                            href="https://www.nike.com/vn/orders"
                            >Send us feedback</a
                          >
                        </li>
                        <li>
                          <a
                            class="pre-help-dropdown-menu-item body-3 u-bold"
                            href="https://www.nike.com/vn/orders"
                            >Dispatch and Delivery</a
                          >
                        </li>
                      </ul>
                    </nav>
                  </div>
                </div>
              </div>
              <span class="userHelp-separate">|</span>
            </div>
              
           <c:if test="${sessionScope.account !=null}" >
            <div class="userAccount" style="display:flex">
              <div class="pre-acct-dropdown d-sm-ib">
                <div id="AccountMenu" class="pre-dropdown-menu">
                  <a
                    class="pre-acct-avatar d-sm-h d-lg-ib"
                    href="https://www.nike.com/vn/member/profile/"
                  >
                    <div class="pre-avatar" data-pre="Avatar">
                      <p class="pre-avatar-name flx-order-sm-1 flx-order-lg--1 body-4 u-bold">
                        Hi, ${sessionScope.account.getLastName()}
                      </p>
                      <div class="icon-btn ripple">
                        <i class="far fa-user"></i>
                        <img
                          alt="Avatar"
                          src="#"
                          class="pre-avatar-image va-sm-m"
                          style="display: none"
                          data-var="img"
                        />
                      </div>
                    </div>
                  </a>
                  <div id="AccountMenu-Menu" class="pre-dropdown-menu-box" data-var="content">
                    <div class="pre-dropdown-menu-content">
                      <nav class="pre-acct-menu">
                       <c:if test="${!sessionScope.account.isRole()}" >
                        <a
                          class="account-dropdown-menu-header d-sm-b mb3-sm"
                          href="manage"
                          >Manager Product</a
                        >
                       </c:if>
                        <ul>
                        <c:if test="${sessionScope.account.isRole()}" >    
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="https://www.nike.com/vn/member/profile/"
                              >Profile</a
                            >
                          </li>
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="https://www.nike.com/vn/orders"
                              >Orders</a
                            >
                          </li>
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="https://www.nike.com/vn/favorites"
                              >Favourites</a
                            >
                          </li>
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="https://www.nike.com/vn/member/inbox"
                              >Inbox</a
                            >
                          </li>
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="https://www.nike.com/vn/experiences"
                              >Experiences</a
                            >
                          </li>
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="https://www.nike.com/vn/member/settings"
                              >Account Settings</a
                            >
                          </li>
                          </c:if>
                          <li>
                            <a
                              class="pre-account-dropdown-menu-item body-3 u-bold"
                              href="logout"
                              >Log out
                          </li>
                           <a class="pre-account-dropdown-menu-item body-3 u-bold" href="#" ></a>    
                        </ul>
                      </nav>
                    </div>
                  </div>
                </div>
              </div>
            </div>
           </c:if>
              
           <c:if test="${sessionScope.account ==null}" >   
            <div class="UserLogin" style="">
              <div class="pre-login-btns">
                <a class="nav-btn body-4" href="login"><span>Sign up</span></a>
                <span class="userHelp-separate">|</span>
                <button class="nav-btn p0-sm d-sm-b body-4 u-bold ml2-sm mr2-sm">
                  <a class="nav-btn body-4" href="login"><span>Log In</span></a>
                </button>
              </div>
            </div>
           </c:if>           
                      
          </div>
        </div>
        <header class="header">
          <div class="header__logo col-md-2">
            <a href="home"> <h1>TEA_SH</h1></a>
          </div>
          <nav class="header__nav col-md-8">
            <ul class="navbar">
              <li class="dropdown">
                <a href="products"
                  >SHOES
                  <span class="caret"></span>
                </a>
                <!-- Subnav -->
                <div id="subnav" class="dropdown-menu">
                  <ul class="col-md-1 col-sm-1"></ul>
                  <ul class="col-md-5 col-sm-5 col-level-two text-truncate">
                    <li>
                      <a href="#" class="title">NỔI BẬT</a>

                      <a class="blank">&nbsp;</a>
                      <a class="title1" href=""></a>
                      <a href="#"
                        >Best Seller</a
                      >
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=new-arrival"
                        >New Arrival</a
                      >
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=sale-off"
                        >Sale off</a
                      >
                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="#">Bộ sưu tập</a>
                      <a
                        href="/product-list?gender=&amp;category=&amp;attribute=pineapple-or-ananas"
                        >Pineapple Or Ananas</a
                      >
                      <a href="/product-list?gender=&amp;category=&amp;attribute=corluray"
                        >Corluray</a
                      >
                      <a
                        href="/product-list?gender=men,women&amp;category=&amp;attribute=bst-unsettling"
                        >Unsettling</a
                      >
                      <a href="/product-list?gender=&amp;category=&amp;attribute=irrelevant"
                        >Irrelevant</a
                      >
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=temperate"
                        >Temperate</a
                      >
                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="#">Collaboration</a>
                      <a href="/product-list/?gender=&amp;category=&amp;attribute=ananas-lucky-luke"
                        >Ananas x Lucky Luke</a
                      >
                      <a
                        href="/product-list/?gender=&amp;category=&amp;attribute=ananas-doraemon-50years"
                        >Ananas x Doraemon 50 Years</a
                      >
                      <a class="blank">&nbsp;</a>
                    </li>
                  </ul>

                  <ul class="col-md-2 col-sm-2 col-level-two text-truncate">
                    <li class="style2-divider"></li>
                    <li>
                      <a href="products" class="title">GIÀY</a>

                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="#">Dòng sản phẩm</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=basas">Basas</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=vintas"
                        >Vintas</a
                      >
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=urbas">Urbas</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=pattas"
                        >Pattas</a
                      >
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=creas">Creas</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=track-6"
                        >Track 6</a
                      >
                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="#">Style</a>
                      <a
                        href="/product-list?gender=men&amp;category=&amp;attribute=high-top?gender=men&amp;category=&amp;attribute=high-top"
                        >High Top</a
                      >
                      <a href="/product-list">Low Top</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=slip-on"
                        >Slip-on</a
                      >
                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="products">Tất cả giày</a>
                      <a class="blank">&nbsp;</a>
                    </li>
                  </ul>

                  <ul class="col-md-2 col-sm-2 col-level-two text-truncate">
                    <li>
                      <a
                        href="/product-list?gender=men&amp;category=top,bottom,accessories&amp;attribute="
                        class="title"
                        >THỜI TRANG &amp; PHỤ KIỆN</a
                      >

                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="#">Nửa trên</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=basic-tee-tron"
                        >Basic Tee</a
                      >
                      <a href="/product-list/?gender=&amp;category=&amp;attribute=graphic-tee"
                        >Graphic tee</a
                      >
                      <a href="/product-list?gender=&amp;category=&amp;attribute=sweatshirt"
                        >Sweatshirt</a
                      >
                      <a href="/product-list?gender=&amp;category=&amp;attribute=hoodie">Hoodie</a>
                      <a class="blank">&nbsp;</a>
                      <a class="title1" href="#">Phụ kiện</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=hat">Nón</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=shoelaces"
                        >Dây giày</a
                      >
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=socks">Vớ</a>
                      <a href="/product-list?gender=men&amp;category=&amp;attribute=backpack"
                        >Ba lô &amp; Túi</a
                      >
                      <a class="blank">&nbsp;</a>
                      <a
                        class="title1"
                        href="/product-list?gender=men&amp;category=top,bottom,accessories&amp;attribute="
                        >Xem tất cả</a
                      >
                      <a class="blank">&nbsp;</a>
                    </li>
                  </ul>
                  <ul class="col-md-2 col-sm-2"></ul>
                </div>
              </li>
              <li><a href="#">BIG SALE</a></li>

              <li>
                <a href="#new-arrivals">NEW ARRIVALS</a>
              </li>

              <li><a href="Sizechart.jsp">SIZE CHART</a></li>
              <li><a href="#">SHOWROOM</a></li>
            </ul>
          </nav>
          <!-- Top Right Menu -->
          <div class="col-lg-2 col-md-2 col-xs-6">
            <div class="menu-bar-h nav-mobile-button hidden-md hidden-lg">
              <i class="ti-menu"></i>
            </div>
            <!-- Right top menu -->
            <div class="right-top-menu">
              <div class="nav__search nav-btn">
                <a href="#"
                  ><span id="nav__search-btn" class="nav__search-btn"
                    ><i class="fas fa-search"></i></span
                ></a>
              </div>
              <!--Search Box  -->
              <div class="search-container">
                <div id="nav__searchbox" class="nav__searchbox">
                  <form action="search" method="post" class="input-group search-bar" role="search">
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
                  <div id="resultSearchDesktop" class="resultDesktop" style="display: none">
                    <div class="innerResultDesktop"></div>
                  </div>
                </div>
              </div>
              <div class="nav__favor nav-btn">
                <a href="#"> <i class="far fa-heart"></i></a>
              </div>
                          

              <div class="nav__cart nav-btn">
                <a href="loadcart">   <i class="fas fa-cart-plus"></i></a> 
                <span class="nav__cart-notice">${sizeCart}</span>
                <!-- Cart Box -->
               
                <div class="cart-box cart-box--empty">
                 <c:if test="${sessionScope.sizeCart ==0}"> 
                  <img src="./assets/img/emptyCart.png" alt="" class="cart-box__img--empty" />
                  <span class="emptyCart-text">Cart empty...Add something for you</span>
                 </c:if>
                 <c:if test="${sessionScope.sizeCart !=0}">
                  <ul class="cart-list">
                  
                  <c:forEach items="${sessionScope.orders}" var="o">   
                    <li>
                      <a href="#" class="image"
                        ><img src="${o.getPrdImg()}" class="cart-thumb" alt=""
                      /></a>
                      <div class="cart-item-desc">
                        <h6><a href="#">${o.getPrdName()}</a></h6>
                        <p><span class="price">${o.getPrdPrice()}đ</span></p>
                      </div>
                      <span class="dropdown-product-remove"><i class="icon-cross"></i></span>
                    </li>
                   </c:forEach>
                    
                    <li class="total">
                      <a href="products" class="btn btn-sm btn-cart pull-right">Shopping</a>
                      <a href="loadcart" class="btn btn-sm btn-cart">Cart</a>
                      <a href="loadcart" class="btn btn-sm btn-checkout">Checkout</a>
                    </li>
                  </ul>
                  </c:if> 
                </div>
                
              </div></a>
            </div>
          </div>
        </header>
      </div>
<!-- Top-Slider -->
      <div class="top-slider">
        <div class="top-slider-container">
          <i class="fa fa-angle-left top-slider-prev"></i>
          <div class="top-slider-wrapper">
            <div class="top-slider-main">
              <div class="top-slider-item">
                <a href=""><i>HÀNG 2 TUẦN NHẬN ĐỔI - GIÀY NỬA NĂM BẢO HÀNH</i></a>
              </div>
              <div class="top-slider-item">
                <a href=""><i>BUY 2 GET 10% OFF - ÁP DỤNG VỚI TẤT CẢ BASIC TEE</i></a>
              </div>
              <div class="top-slider-item">
                <a href=""><i>FREE SHIPPING VỚI HOÁ ĐƠN TỪ 800K !</i> </a>
              </div>
              <div class="top-slider-item">
                <a href=""><i>BUY MORE PAY LESS - ÁP DỤNG KHI MUA PHỤ KIỆN</i></a>
              </div>
            </div>
          </div>
          <i class="fa fa-angle-right top-slider-next"></i>
        </div>
      </div>