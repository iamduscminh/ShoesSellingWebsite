// Search Box
const navSearch_btn = document.querySelector(".right-top-menu .nav-btn:first-child");
const navSearchBox = document.querySelector(".nav__searchbox");
const container = document.querySelector(".search-container");

function showSearchBox() {
  container.classList.add("open");
  navSearch_btn.style.borderRadius = "100px";
  navSearch_btn.style.backgroundColor = "rgba(0, 0, 0, 0.24)";
}
function hideSearchBox() {
  container.classList.remove("open");
  navSearch_btn.style.borderRadius = "0px";
  navSearch_btn.style.backgroundColor = "rgba(0, 0, 0, 0)";
}
navSearch_btn.addEventListener("click", showSearchBox);
container.addEventListener("click", hideSearchBox);
navSearchBox.addEventListener("click", function (event) {
  event.stopPropagation();
});
// Top-Slider
// Top-slider
window.addEventListener("load", function () {
  const topSliderMain = document.querySelector(".top-slider-main");
  const topSliderItems = document.querySelectorAll(".top-slider-item");
  const topNextBtn = document.querySelector(".top-slider-next");
  const topPrevBtn = document.querySelector(".top-slider-prev");
  const topSliderItemWidth = topSliderItems[0].offsetWidth;
  const topSliderLength = topSliderItems.length;
  let positionX = 0;
  let index = 0;
  topNextBtn.addEventListener("click", function () {
    handleChangeSlide(1);
  });
  topPrevBtn.addEventListener("click", function () {
    handleChangeSlide(-1);
  });
  function handleChangeSlide(direction) {
    if (direction === 1) {
      if (index === topSliderLength - 1) {
        positionX += topSliderItemWidth * (index + 1);
        index = -1;

        // return;
      }
      positionX -= topSliderItemWidth;
      topSliderMain.style = `transform : translateX(${positionX}px)`;
      index++;
    } else if (direction === -1) {
      if (index <= 0) {
        index = 0;
        return;
        // index == topSliderLength - 1;
        // positionX -= topSliderItemWidth * (index + 1);
      }

      // console.log(index);
      positionX += topSliderItemWidth;
      topSliderMain.style = `transform : translateX(${positionX}px)`;
      index--;
    }
  }

  var repeat = function (activeClass) {
    let i = 1;

    var repeater = () => {
      setTimeout(function () {
        positionX = -1 * i * topSliderItemWidth;
        topSliderMain.style = `transform:translateX(${positionX}px)`;
        i++;

        if (topSliderLength == i) {
          i = 0;
        }

        repeater();
      }, 5000);
    };
    repeater();
  };
  repeat();
});
// Slider
window.addEventListener("load", function () {
  const sliderMain = document.querySelector(".slider-main");
  const sliderItems = document.querySelectorAll(".slider-item");
  // const nextBtn = document.querySelector(".slider-next");
  // const prevBtn = document.querySelector(".slider-prev");
  const dotItems = document.querySelectorAll(".slider-dot-item");
  const sliderItemWidth = sliderItems[0].offsetWidth;
  const sliderLength = sliderItems.length;
  let postionX = 0;
  let index = 0;
  // nextBtn.addEventListener("click", function () {
  //   handleChangeSlide(1);
  // });
  // prevBtn.addEventListener("click", function () {
  //   handleChangeSlide(-1);
  // });

  [...dotItems].forEach((item) =>
    item.addEventListener("click", function (e) {
      [...dotItems].forEach((e1) => e1.classList.remove("active"));
      e.target.classList.add("active");
      const slideIndex = parseInt(e.target.dataset.index);
      index = slideIndex;
      postionX = -1 * index * sliderItemWidth;
      sliderMain.style = `transform:translateX(${postionX}px)`;
    })
  );

  var repeat = function (activeClass) {
    let i = 1;

    var repeater = () => {
      setTimeout(function () {
        [...dotItems].forEach((e1) => e1.classList.remove("active"));

        dotItems[i].classList.add("active");
        postionX = -1 * i * sliderItemWidth;
        sliderMain.style = `transform:translateX(${postionX}px)`;
        i++;

        if (sliderLength == i) {
          i = 0;
        }

        repeater();
      }, 8000);
    };
    repeater();
  };
  repeat();
});
// ------------->
// Product item hover
const prdCardHeaders = document.querySelectorAll(".ProductCardHeader");

for (let i = 0; i < prdCardHeaders.length; i++) {
  const prdImg = prdCardHeaders[i].getElementsByTagName("img")[0];
  const metas = prdCardHeaders[i].getElementsByTagName("meta");
  prdImg.addEventListener("mouseover", function (e) {
    e.target.setAttribute("src", metas[1].getAttribute("content"));
  });
  prdImg.addEventListener("mouseout", function (e) {
    e.target.setAttribute("src", metas[0].getAttribute("content"));
  });
}
// Category Menu SideBar
const itemSidebars = document.querySelectorAll(".category-left-li");
itemSidebars.forEach(function (menuItem, index) {
  menuItem.addEventListener("click", function () {
    menuItem.classList.toggle("active");
  });
});
