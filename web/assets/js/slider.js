import InfiniteCarousel from "../js/components/carousel.js";

// let titles = [
//   "Cách giúp bạn cải thiện dòng code của bản thân",
//   "Cách tạo ra named parameter trong các ngôn ngữ khác nhau",
//   "Lí do bạn nên hạn chế sử  dụng từ khoá else",
//   "Một số lỗi hay gặp và cách khắc phục",
//   "Cách giúp bạn cải thiện dòng code của bản thân",
// ];
// let descriptions = [
//   "Code sạch là code mà không chỉ người khác mà còn cá nhân bạn sau nhiều tháng có thể đọc được.",
//   "Named parameter - một trong những tính năng hữu ích khi code. Tuy nhiên, không phải ngôn ngữ nào cũng hỗ trợ. Bài viết này sẽ giúp bạn tiếp cận với nó.",
//   "Những ngày đầu khi học code, hầu hết chúng ta đều cảm thấy quen thuộc với từ khoá else. Tuy nhiên, khi bạn học lên cao, bạn sẽ dần ít sử dụng từ khoá này. Cùng tìm hiểu tại sao nhé.",
//   "Trong quá trình code, chúng ta thường bỏ đi những chi tiết nhỏ. Tuy nhiên, chính những chi tiết nhỏ này đôi khi lại gây ra những bug sau này. Dưới đây là 10 lỗi chung mà nhiều lập trình viên hay mắc phải.",
//   "Code sạch là code mà không chỉ người khác mà còn cá nhân bạn sau nhiều tháng có thể đọc được.",
// ];
// const sliederCarousels = document.getElementsByClassName("owl-stage");
// Array.prototype.forEach.call(sliederCarousels, function (element) {
//   console.log(element.getElementsByClassName("owl-item").length);
//   let slider = new InfiniteCarousel({
//     carousel: element,
//     durationInMs: 100000000,
//   });
//   slider.run();

//   element.querySelector(".prd-slider-prev").onclick = slider.prevSlide.bind(slider);
//   element.querySelector(".prd-slider-next").onclick = slider.nextSlide.bind(slider);
// });

// slider1
let slider = new InfiniteCarousel({
  carousel: document.getElementById("slider__carousel1"),

  durationInMs: 100000000,
});
slider.run();

document.getElementById("prev-btn1").onclick = slider.prevSlide.bind(slider);
document.getElementById("next-btn1").onclick = slider.nextSlide.bind(slider);

// slider2

let slider2 = new InfiniteCarousel({
  carousel: document.getElementById("slider__carousel2"),

  durationInMs: 10000000,
});
slider2.run();
document.getElementById("prev-btn2").onclick = slider2.prevSlide.bind(slider2);
document.getElementById("next-btn2").onclick = slider2.nextSlide.bind(slider2);

let slider3 = new InfiniteCarousel({
  carousel: document.getElementById("slider__carousel3"),

  durationInMs: 10000000,
});
slider3.run();
document.getElementById("prev-btn3").onclick = slider3.prevSlide.bind(slider3);
document.getElementById("next-btn3").onclick = slider3.nextSlide.bind(slider3);

// let dots = document.getElementsByClassName("slider__dot");
// for (let index = 0; index < dots.length; index++) {
//   connectDot(dots[index], index);
// }

// function connectDot(dot,order, index) {
//   dot.onclick = slider.goToSlide.bind(slider, { index: index });
// }
