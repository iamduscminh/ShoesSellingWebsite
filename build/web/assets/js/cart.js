quantityMinus = document.getElementsByClassName("qty-minus");
quantityPlus = document.getElementsByClassName("qty-plus");

[...quantityMinus].forEach((item, index) =>
  item.addEventListener("click", function (e) {
    var effect = document.getElementsByClassName("qty-text")[index];
    var qty = effect.value;
    
    if (!isNaN(qty) && qty < 2) return;
    effect.value--;
  })
);

[...quantityPlus].forEach((item, index) =>
  item.addEventListener("click", function (e) {
    var effect = document.getElementsByClassName("qty-text")[index];
    var qty = effect.value;
    var max = effect.getAttribute("max");
    
    if (!isNaN(qty) && qty > max - 1) return;
    effect.value++;
  })
);
