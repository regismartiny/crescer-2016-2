describe('seriesPorLongevidade()', function() {

  it('deve retornar a lista das series em ordem descendente por longevidade', function() {
    var heroiSeries = [{series: {items:[{endYear:2000, startYear:1999},{endYear:2000, startYear:1998},{endYear:2000, startYear:1997}]}}];
    var serie1 = {endYear:2000, startYear:1999};
    var serie2 = {endYear:2000, startYear:1998};
    var serie3 = {endYear:2000, startYear:1997};
    var herois = new Herois(heroiSeries);
    var resultado = herois.seriesPorLongevidade();
    expect(resultado[0]).toEqual(serie3);
    expect(resultado[1]).toEqual(serie2);
    expect(resultado[2]).toEqual(serie1);
  });

  it('deve retornar a lista das series dos herois em ordem descendente por longevidade', function() {
    var heroisSeries = [{series: {items:[{endYear:2000, startYear:1999},
                                        {endYear:2000, startYear:1998},
                                        {endYear:2000, startYear:1997}]}},
                        {series: {items:[{endYear:2010, startYear:1999},
                                         {endYear:2010, startYear:1998},
                                         {endYear:2010, startYear:1997}]}}];
    var serie1 = {endYear:2000, startYear:1999};
    var serie2 = {endYear:2000, startYear:1998};
    var serie3 = {endYear:2000, startYear:1997};
    var serie4 = {endYear:2010, startYear:1999};
    var serie5 = {endYear:2010, startYear:1998};
    var serie6 = {endYear:2010, startYear:1997};
    var herois = new Herois(heroisSeries);
    var resultado = herois.seriesPorLongevidade();
    expect(resultado[0]).toEqual(serie6);
    expect(resultado[1]).toEqual(serie5);
    expect(resultado[2]).toEqual(serie4);
    expect(resultado[3]).toEqual(serie3);
    expect(resultado[4]).toEqual(serie2);
    expect(resultado[5]).toEqual(serie1);
  });

});
