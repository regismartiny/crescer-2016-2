class Herois {
  constructor (herois){
    this._herois = herois;
  }


  foraDaGuerraCivil() {
    /*var resultado = [];
    for (let heroi of this._herois) {
      var items = heroi.events.items,
          encontrado = false;
      for (let evento of items) {
        if (evento.name === 'Civil War') {
          encontrado = true;
          break;
        }
      }
      if (!encontrado) {
        resultado.push(heroi);
      }
    }
    return resultado;*/
    return this._herois.filter(function(elem){
        return elem.events.items.filter(function(item){
          return item.name.indexOf('Civil War') !== -1;
        }).length === 0;
    });
  }


  maisPublicado() {
    /*var resultado = [],
        heroiMaisPublicado,
        maisDisponiveis = 0;
    for (let heroi of this._herois) {
      var items = heroi.comics;
      var disponiveis = items.available;
      if (disponiveis > maisDisponiveis) {
        maisDisponiveis = disponiveis;
        heroiMaisPublicado = heroi;
      }
    }
    return heroiMaisPublicado;*/
    return this._herois.reduce(function(a,b){
      return a.comics.available > b.comics.available?a:b;
    });
  }


  mediaPaginas() {
    var numeroHerois = 0,
      totalPaginas = 0;
    for(let heroi of this._herois) {
      for (let item of heroi.comics.items) {
        //if (item.format === 'Comic') {
          totalPaginas += item.pageCount;
        //}
      }
      numeroHerois++;
    }
    return totalPaginas / numeroHerois;
  }


  seriesPorLongevidade() {
    var series = [];
    for(let heroi of this._herois) {
      for (let item of heroi.series.items) {
        series.push(item);
      }
    }
    return series.sort(function(serieA, serieB) {
      var anosA = serieA.endYear - serieA.startYear;
      var anosB = serieB.endYear - serieB.startYear;
      if (anosA < anosB)
        return 1;
      else if(anosA > anosB)
        return 0;
      else
        return -1;
    });
  }


  comicMaisCara() {
    var comicMaisCaro,
        precoComicMaisCaro = 0;
    for(let heroi of this._herois) {
      for (let item of heroi.comics.items) {
        var totalPrecos = 0;
        for (let preco of item.prices) {
          totalPrecos += preco.price;
        }
        if (totalPrecos > precoComicMaisCaro) {
          precoComicMaisCaro = totalPrecos;
          comicMaisCaro = item;
        }
      }
    }
    return comicMaisCaro;
  }

}


//for of, let = ES2015,
/* compatibilidade
var i;
for(i=0;i<x;i++){}

arr.forEach(function(elem,indice) {});
*/
