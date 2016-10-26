class Herois {
  constructor (herois){
    this._herois = herois;
  }


  foraDaGuerraCivil() {
    var resultado = [],
        heroi;
    for (heroi of this._herois) {
      var evento,
          items = heroi.events.items,
          encontrado = false;
      for (evento of items) {
        if (evento.name === 'Civil War') {
          encontrado = true;
          break;
        }
      }
      if (!encontrado) {
        resultado.push(heroi);
      }
    }
    return resultado;
  }


  maisPublicado() {
    var resultado = [],
        heroi,
        heroiMaisPublicado,
        maisDisponiveis = 0;
    for (heroi of this._herois) {
      var items = heroi.comics;
      var disponiveis = items.available;
      if (disponiveis > maisDisponiveis) {
        maisDisponiveis = disponiveis;
        heroiMaisPublicado = heroi;
      }
    }
    return heroiMaisPublicado;
  }


  mediaPaginas() {
    var heroi,
      numeroHerois = 0,
      totalPaginas = 0;
    for(heroi of this._herois) {
      var item;
      for (item of heroi.comics.items) {
        //if (item.format === 'Comic') {
          totalPaginas += item.pageCount;
        //}
      }
      numeroHerois++;
    }
    return totalPaginas / numeroHerois;
  }


  seriesPorLongevidade() {
    var series = [],
        heroi;
    for(heroi of this._herois) {
      var item;
      for (item of heroi.series.items) {
        series.push(item);
      }
    }
    return series.sort(function(serieA, serieB) {
      var anosA = serieA.endYear - serieA.startYear;
      var anosB = serieB.endYear - serieB.startYear;
      return anosA < anosB;
    });
  }


  comicMaisCara() {
    var comicMaisCaro,
        precoComicMaisCaro = 0,
        heroi;
    for(heroi of this._herois) {
      var item;
      for (item of heroi.comics.items) {
        var preco,
            totalPrecos = 0;
        for (preco of item.prices) {
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
