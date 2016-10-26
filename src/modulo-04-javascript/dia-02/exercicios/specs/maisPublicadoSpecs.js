describe('maisPublicado()', function() {

  it('deve encontrar o heroi da Marvel mais publicado', function() {
    var herois = new Herois(marvel);
    var maisPublicado = herois.maisPublicado();
    expect(maisPublicado).toEqual(marvel[7]);
  });

});
