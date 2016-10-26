describe('constructor', function() {

  it('deve criar uma objeto Herois com a lista de herois da marvel passada por parametro', function() {
    var herois = new Herois(marvel);
    expect(herois._herois).toEqual(marvel);
  });
  it('deve criar uma objeto Herois com lista customizada passada por parametro', function() {
    var lista = [{nome:'batman'},{nome:'superman'}];
    var herois = new Herois(lista);
    expect(herois._herois).toEqual(lista);
  });
  it('deve criar uma objeto Herois com lista vazia passada por parametro', function() {
    var lista = [];
    var herois = new Herois(lista);
    expect(herois._herois).toEqual(lista);
  });
});
