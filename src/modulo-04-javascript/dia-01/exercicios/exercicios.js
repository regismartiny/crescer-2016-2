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
    else if (i%3 === 0){
      console.log('Diglett dig');
    }
    else if (i%5 === 0) {
      console.log('trio trio trio');
    }
    else {
      console.log(i);
    }
  }
}

var ehPar = function (numero) {
  return numero % 2 === 0;
}

function find(arr, fnFiltro) {
  if (typeof fnFiltro === 'function') {
    var nArr = [];
    for(var i=0, len = arr.length; i < len; i++) {
      var elem = arr[i];
      if (fnFiltro(elem)) {
        nArr.push(elem);
      }
    }
    return nArr;
  }
}

function subtrair(num1) {
  return function(num2) {
    return num1 - num2;
  }
}
/*
//chamando subtrair(a), depois subtrair(b)
function subtrair(numero) {
  if (typeof numeroAnterior !== 'undefined') {
    console.log(numeroAnterior-numero);
  }
  numeroAnterior = numero;
}*/

function qtdPropriedades(obj) {
  return Object.keys(obj).length;
}

function iguais(x, y)
{
  if (typeof x === 'object' && typeof y === 'object' && qtdPropriedades(x) != qtdPropriedades(y)) {
    return false;
  }
  var p;
  for(p in x) {
      if(typeof(y[p])=='undefined') {return false;}
  }
  for(p in x) {
      if (x[p]) {
          switch(typeof(x[p])) {
              case 'object':
                  if (!iguais(x[p],y[p])) { return false; } break;
              case 'function':
                  if (typeof(y[p])=='undefined' || (x[p].toString() != y[p].toString()))
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

function mesclar(objA, objB, recursiva = false) {
  for(prop in objB) {
    if (recursiva && typeof objB[prop] === 'object') {
      mesclar(objA[prop], objB[prop], recursiva);
    }else {
      objA[prop] = objB[prop];
    }
  }
}
