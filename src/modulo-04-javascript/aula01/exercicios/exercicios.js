function gerarPiramide(nLinhas) {
  for(var i=1; i <= nLinhas; i++) {
    var res = '';
    for(var j=0; j < i; j++) {
      res += 'R$';
    }
    console.log(res);
  }
}

function diglettDig() {
  for(var i=1; i <= 100; i++) {
    if (i%3 === 0 && i%5 === 0) {
      console.log('Diglett dig, trio trio trio');
    }
    if (i%3 === 0){
      console.log(i, 'Diglett dig');
    }
    else if (i%5 === 0) {
      console.log('trio trio trio');
    }
  }
}

var ehPar = function (numero) {
  return numero % 2 === 0;
}

function find(arr, fFiltro) {
  if (typeof fFiltro == 'function') {
    var newArr = [];
    for(var i=0, len = arr.length; i < len; i++) {
      var element = arr[i];
      if (fFiltro(element)) {
        newArr.push(element);
      }
    }
    console.log(newArr);
  }
}

function subtrair(numero) {
  if (typeof numeroAnterior != 'undefined') {
    console.log(numeroAnterior-numero);
  }
  numeroAnterior = numero;
}

function iguais(paramA, paramB) {
  if (paramA == paramB) {
    return true;
  }
  else if (typeof paramA == 'object' && typeof paramB == 'object') {
    for (var property in paramA) {
      if (paramA.hasOwnProperty(property)) {
          console.log(property, paramA[property]);
      }
}
  }
}
