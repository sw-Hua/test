
function isValidUsername (str) {
  return ['admin', 'editor'].indexOf(str.trim()) >= 0;
}

function isExternal (path) {
  return /^(https?:|mailto:|tel:)/.test(path);
}

function isCellPhone (val) {
  if (!/^1(3|4|5|6|7|8)\d{9}$/.test(val)) {
    return false
  } else {
    return true
  }
}

//Check account
function checkUserName (rule, value, callback){
  if (value == "") {
    callback(new Error("Please enter account number"))
  } else if (value.length > 20 || value.length <3) {
    callback(new Error("The account length should be 3-20"))
  } else {
    callback()
  }
}

//Check the name
function checkName (rule, value, callback){
  if (value == "") {
    callback(new Error("Please enter your name"))
  } else if (value.length > 12) {
    callback(new Error("The account length should be 1-12"))
  } else {
    callback()
  }
}

function checkPhone (rule, value, callback){
  // let phoneReg = /(^1[3|4|5|6|7|8|9]\d{9}$)|(^09\d{8}$)/;
  if (value == "") {
    callback(new Error("Please enter your mobile number"))
  } else if (!isCellPhone(value)) {//Introduce the method of checking the phone format encapsulated in Methods
    callback(new Error("Enter the correct phone number!"))
  } else {
    callback()
  }
}


function validID (rule,value,callback) {
  //The ID number is 15 or 18 digits. When the number is 15 digits, all digits are digits. The first 17 digits of the 18 digits are digits, and the last digit is a check digit, which may be a digit or character X
  let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
  if(value == '') {
    callback(new Error('Please enter your ID number(Chinese)'))
  } else if (reg.test(value)) {
    callback()
  } else {
    callback(new Error('The Chinese ID number is 15 or 18 digits.'))
  }
}