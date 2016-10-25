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
    var nArr = [];
    for(var i=0, len = arr.length; i < len; i++) {
      var element = arr[i];
      if (fFiltro(element)) {
        nArr.push(element);
      }
    }
    console.log(nArr);
  }
}

function subtrair(numero) {
  if (typeof numeroAnterior != 'undefined') {
    console.log(numeroAnterior-numero);
  }
  numeroAnterior = numero;
}

function iguais(x, y)
{
  var p;
  for(p in x) {
      if(typeof(y[p])=='undefined') {return false;}
  }
  for(p in x) {
      if (x[p]) {
          switch(typeof(x[p])) {
              case 'object':
                  if (!x[p].equals(y[p])) { return false; } break;
              case 'function':
                  if (typeof(y[p])=='undefined' ||
                      (p != 'equals' && x[p].toString() != y[p].toString()))
                      return false;
                  break;
              default:
                  if (x[p] != y[p]) { return false; }
          }
      } else {
          if (y[p])
              return false;
      }
  }
  for(p in y) {
      if(typeof(x[p])=='undefined') {return false;}
  }
  return true;
}

function ctrlC(obj) {
  var nObj = JSON.parse(JSON.stringify(obj));
  return nObj;
}

function mesclar(objA, objB) {
  for(param in objA) {
    if (typeof objB[param] != 'undefined') {
      if (objA[param] !== objB[param]) {
        objA[param] = objB[param];
      }
    }
  }
}
