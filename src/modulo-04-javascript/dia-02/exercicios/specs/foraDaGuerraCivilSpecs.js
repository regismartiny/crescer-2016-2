describe('foraDaGuerraCivil()', function() {
  it('deve retornar a lista dos heróis da Marvel que não estiveram na Guerra Civil', function() {
    var herois = new Herois(marvel);
    var resultado = herois.foraDaGuerraCivil();
    expect(resultado[0]).toEqual(marvel[0]);
  });
});
