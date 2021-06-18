document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep++;
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary:
            var donationQuantity = document.getElementById("donationQuantity").value;
            document.getElementById("donationQuantityP").innerHTML = donationQuantity;

            if (document.getElementById('institution0').checked) {
                var institution = document.getElementById('institution0title').innerText;
            }
            if (document.getElementById('institution1').checked) {
                var institution = document.getElementById('institution1title').innerText;
            }
            if (document.getElementById('institution2').checked) {
                var institution = document.getElementById('institution2title').innerText;
            }
            if (document.getElementById('institution3').checked) {
                var institution = document.getElementById('institution3title').innerText;
            }
            document.getElementById("institutionValue").innerText = institution;

            const categories = [];

            if (document.getElementById('categories0').checked) {
               categories.push(document.getElementById('categories0name').innerText);
            }

            if (document.getElementById('categories1').checked) {
                categories.push(document.getElementById('categories1name').innerText);
            }
            if (document.getElementById('categories2').checked) {
                categories.push(document.getElementById('categories2name').innerText);
            }
            if (document.getElementById('categories3').checked) {
                categories.push(document.getElementById('categories3name').innerText);
            }
            if (document.getElementById('categories4').checked) {
                categories.push(document.getElementById('categories4name').innerText);
            }

            document.getElementById("categoryInput").innerHTML = categories + "<br>";

            var streetNameInput = document.getElementById("streetNameInput").value;
            document.getElementById("streetName").innerText = streetNameInput;

            var cityNameInput = document.getElementById("cityNameInput").value;
            document.getElementById("cityName").innerText = cityNameInput;

            var zipCodeInput = document.getElementById("zipCodeInput").value;
            document.getElementById("zipCodeName").innerText = zipCodeInput;

            var phoneInput = document.getElementById("phoneInput").value;
            document.getElementById("phone").innerText = phoneInput;


            var pickUpDateInput = document.getElementById("pickUpDateInput").value;
            document.getElementById("pickUpDate").innerText = pickUpDateInput;

            var pickUpTimeInput = document.getElementById("pickUpTimeInput").value;
            document.getElementById("pickUpTime").innerText = pickUpTimeInput;

            var pickUpCommentInput = document.getElementById("pickUpCommentInput").value;
            document.getElementById("comments").innerText = pickUpCommentInput;

            var phoneInput = document.getElementById("phoneInput").value;
            document.getElementById("phone").innerText = phoneInput;

        }


    }


    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }

    /**
     * Password retype check
     */

    // function check() {
    //     const password = document.getElementById("password").value;
    //     const confirm=document.getElementById("password2").value;
    //     if ( password ===confirm){
    //         document.getElementById("message").style.color = "green";
    //         document.getElementById("message").innerHTML = "matching";
    //     } else {
    //         document.getElementById('message').style.color = 'red';
    //         document.getElementById('message').innerHTML = 'not matching';
    //     }
    // }


})
;
