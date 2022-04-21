const form = document.getElementById('form');
const email = document.getElementById('email');
const password = document.getElementById('password');
const confirmPassword = document.getElementById('confirmPassword');
const signupSubmit = document.getElementById('signupSubmit');



//signupSubmit.addEventListener('click', e => {
//    if (validateInputs()) {
//        form.submit();
//    }
//})

function isValidEmail(email) {
    const reg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return reg.test(String(email).toLowerCase());
}
function setError(element, message) {
    const inputControl = element.parentElement;
    const errorDisplay = inputControl.querySelector('.error');

    errorDisplay.innerText = message;
    inputControl.classList.add('error');
}

function validateInputs() {
    const emailValue = email.value.trim();
    const passwordValue = password.value.trim();
    const confirmPasswordValue = confirmPassword.value.trim();
        // for email
        if(emailValue === '') {
            setError(email, 'Email cannot be blank');
            return false;
        } else if(!isValidEmail(emailValue)) {
            setError(email, 'Email is not valid');
            return false;
        }
        // for password
        if(passwordValue === '') {
            setError(password, 'Password cannot be blank');
            return false;
        } else if(passwordValue.length <8) {
            setError(password, 'Password must be at least 8 characters');
            return false;
        } else if (passwordValue != confirmPasswordValue) {
            setError(confirmPassword, 'Passwords do not match');
            return false;
        }
        return true;
}
