describe('seriesPorLongevidade()', function() {

  it('deve retornar a lista das series em ordem descendente por longevidade', function() {
    var herois = new Herois(marvel);
    var resultado = herois.seriesPorLongevidade();
    var series = {};
    expect(resultado).toEqual(series);
  });

});
