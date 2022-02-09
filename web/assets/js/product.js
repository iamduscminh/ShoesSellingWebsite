//Product views
 const mainImg = document.querySelector(".main-img");
 const detailImgs = document.querySelectorAll(".prd-detail-img__item img");
 detailImgs.forEach(function (element, index) {
   element.addEventListener("click", function (e) {
     mainImg.setAttribute("src", e.target.getAttribute("src"));
   });
 });
