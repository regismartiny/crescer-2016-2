describe('maisPublicado()', function() {

  it('deve encontrar o heroi da Marvel mais publicado', function() {
    var herois = new Herois(marvel);
    var maisPublicado = herois.maisPublicado();
    expect(maisPublicado).toEqual(marvel[7]);
  });

  it('deve encontrar o heroi mais publicado de 2', function() {
    var herois_ = [{comics: {available: 5}},
                   {comics: {available: 10}}];
    var herois = new Herois(herois_);
    var maisPublicado = herois.maisPublicado();
    expect(maisPublicado).toEqual({comics: {available: 10}});
  });

  it('deve encontrar o heroi mais publicado de 3', function() {
    var herois_ = [{comics: {available: 5}},
                   {comics: {available: 10}},
                   {comics: {available: 6}}];
    var herois = new Herois(herois_);
    var maisPublicado = herois.maisPublicado();
    expect(maisPublicado).toEqual({comics: {available: 10}});
  });

});
