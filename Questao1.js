function cToF(celsius) 
{
  var cTemp = celsius;
  var cToFahr = cTemp * 9 / 5 + 32;
  var message = cTemp+'\xB0C é igual a ' + cToFahr + ' \xB0F.';
  console.log(message);
}

function fToC(fahrenheit) 
{
  var fTemp = fahrenheit;
  var fToCel = (fTemp - 32) * 5 / 9;
  var message = fTemp+'\xB0F é igual a ' + fToCel + '\xB0C.';
  console.log(message);
} 
cToF(60);
fToC(45);
