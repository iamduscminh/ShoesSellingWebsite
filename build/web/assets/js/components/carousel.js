export default class InfiniteCarousel {
  #totalSlide;
  #lastIndex;
  #currIndex;
  #timer;
  #actionQueue;

  constructor({
    carousel,
    dots = null,
    strAnimationClass = null,
    elementClassesWithText = {},
    durationInMs = 5000,
    maxDotOpacity = "1",
    minDotOpacity = "0.25",
  }) {
    this.carousel = carousel;
    this.dots = dots;
    this.durationInMs = durationInMs;
    this.strAnimationClass = strAnimationClass;
    this.elementClassesWithText = elementClassesWithText;
    this.maxDotOpacity = maxDotOpacity;
    this.minDotOpacity = minDotOpacity;

    this.#totalSlide = this.carousel.childElementCount - 1;
    this.#lastIndex = 0;
    this.#currIndex = 0;
    this.#timer = null;
    this.#actionQueue = [this.nextSlide.bind(this)];
  }

  run() {
    this.#timer = setInterval(this.goToSlide.bind(this, { index: 0 }), 0);
  }

  nextSlide() {
    if (this.#currIndex >= this.#totalSlide) {
      this.goToSlide({ index: 0, animation: false });
      return;
    }
    this.goToSlide({ index: this.#currIndex + 1 });
  }

  prevSlide() {
    if (this.#currIndex <= 0) {
      this.#actionQueue.unshift(this.prevSlide.bind(this));
      this.goToSlide({ index: this.#totalSlide, animation: false });
      return;
    }
    this.goToSlide({ index: this.#currIndex - 1 });
  }

  goToSlide({ index, animation = true }) {
    let duration = animation ? this.durationInMs : 0;
    let element,
      content = "";

    this.#chooseAnimationBehavior(animation);

    this.#lastIndex = this.#currIndex;
    this.#currIndex = index;
    if (this.dots !== null && this.dots.length >= this.#totalSlide) {
      this.dots[this.#lastIndex % this.#totalSlide].style.opacity = this.minDotOpacity;
      this.dots[this.#currIndex % this.#totalSlide].style.opacity = this.maxDotOpacity;
    }
    for (const elementClass in this.elementClassesWithText) {
      if (this.elementClassesWithText.hasOwnProperty(elementClass)) {
        element = document.getElementById(elementClass);
        content = this.elementClassesWithText[elementClass][this.#currIndex];
        content = content === undefined ? "" : content;
        element.innerText = content;
      }
    }
    this.carousel.style.right = index * 33.333333 + "%";
    this.#resetTimer(duration);
  }

  #chooseAnimationBehavior(addAnimation) {
    if (!addAnimation) {
      this.#removeAnimation();
      return;
    }
    this.#addAnimation();
  }

  #addAnimation() {
    this.carousel.classList.add(this.strAnimationClass);
  }

  #removeAnimation() {
    if (this.carousel.classList.contains(this.strAnimationClass)) {
      this.carousel.classList.remove(this.strAnimationClass);
    }
  }

  #resetTimer(durationInMs) {
    let action = this.#actionQueue[0];
    if (this.#actionQueue.length > 1) {
      this.#actionQueue.shift();
    }
    clearInterval(this.#timer);
    this.#timer = setInterval(action, durationInMs);
  }
}
