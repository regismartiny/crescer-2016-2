describe('mediaPaginas()', function() {

  it('deve encontrar a media de paginas das comics dos heróis da Marvel', function() {
    var herois = new Herois(marvel);
    var resultado = herois.mediaPaginas();
    expect(resultado).toEqual(296.25);
  });

  it('deve encontrar a media de paginas das comics de 1 herói', function() {
    var heroi = [{comics:{items:[{pageCount:1},{pageCount:2},{pageCount:3}]}}];
    var herois = new Herois(heroi);
    var resultado = herois.mediaPaginas();
    expect(resultado).toEqual(6);
  });

  it('deve encontrar a media de paginas das comics de 2 heróis', function() {
    var heroisComics = [{comics:{items:[{pageCount:1},{pageCount:2},{pageCount:3}]}},
                        {comics:{items:[{pageCount:2},{pageCount:4},{pageCount:6}]}}];
    var herois = new Herois(heroisComics);
    var resultado = herois.mediaPaginas();
    expect(resultado).toEqual(9);
  });

});
