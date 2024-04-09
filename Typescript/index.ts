/*
* This program blows up a string into letters
*
* By:      Evan Beaudoin
* Version: 1.0
* Since:   2024-04-02
*/

import { createPrompt } from 'bun-promptx'

function isDigit(char) {
  return !isNaN(parseInt(char))
}

function blowUp(input) {
  let newString = ""

  if (input === '' || input.length === 1 || isDigit(input[input.length - 1]) === true) {
    return "Invalid String"
  }

  for (let counter1 = 0; counter1 < input.length; counter1++) {
    if (isDigit(input[counter1])) { // Checks if value is a digit
      // Checks if next digit is also a number
      if (isDigit(input[counter1 + 1])) { 
        // If yes it ignores the previous number
        continue 
      }
      else {
        // Multiplies letters by their respected values
        let mulitplier = parseInt(input[counter1])
        for (let counter2 = 0; counter2 < mulitplier; counter2++) {
          // Appends characters to a new string
          newString += input[counter1 + 1] 
        }
      }
    }
    else { // If it isn't go to the next value
      continue 
    }
  }
  return newString
}

let newString = ""
let inputResult = createPrompt("Enter a String that you want to blow up: ")
if (inputResult.value !== null) {
  let input = inputResult.value
  newString = blowUp(input)
}
console.log(newString)
