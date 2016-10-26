describe('foraDaGuerraCivil()', function() {
  it('deve retornar a lista dos heróis da Marvel que não estiveram na Guerra Civil', function() {
    var herois = new Herois(marvel);
    var resultado = herois.foraDaGuerraCivil();
    expect(resultado[0]).toEqual(marvel[0]);
  });

  it('deve retornar o herói que não esteve na Guerra Civil', function() {
    var heroisGuerra = [{events:{items:[{name:'Civil War'}]}},
                        {events:{items:[{name:'Avengers'}]}}];
    var herois = new Herois(heroisGuerra);
    var resultado = herois.foraDaGuerraCivil();
    var heroiQueNaoEsteve = {events:{items:[{name:'Avengers'}]}};
    expect(resultado[0]).toEqual(heroiQueNaoEsteve);
  });

  it('deve retornar os heróis que não estiveram na Guerra Civil', function() {
    var heroisGuerra = [{events:{items:[{name:'Civil War'}]}},
                        {events:{items:[{name:'Avengers II'}]}},
                        {events:{items:[{name:'Avengers'}]}}];
    var herois = new Herois(heroisGuerra);
    var resultado = herois.foraDaGuerraCivil();
    var heroisQueNaoEstiveram = [{events:{items:[{name:'Avengers II'}]}},{events:{items:[{name:'Avengers'}]}}];
    expect(resultado).toEqual(heroisQueNaoEstiveram);
  });
});
