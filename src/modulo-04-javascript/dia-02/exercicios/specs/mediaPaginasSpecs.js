describe('mediaPaginas()', function() {

  it('deve encontrar a media de paginas das comics dos heróis da Marvel', function() {
    var herois = new Herois(marvel);
    var resultado = herois.mediaPaginas();
    expect(resultado).toEqual(296.25);
  });

});
