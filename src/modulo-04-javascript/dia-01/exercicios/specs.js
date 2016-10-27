describe('find(arr,fFilter)', function() {
  it('deve encontrar elementos to tipo string', function () {
    var resultado = find([ 'a', 5, null, false, 'false' ], function(elem) {
      return typeof elem === 'string';
      });
    expect(resultado).toEqual([ 'a', 'false' ]);
  });

  it('deve encontrar elementos maiores que 1', function () {
    var resultado = find([1,2,3,4],function(elem){
      return elem > 1;
    });
    expect(resultado).toEqual([2,3,4]);
  });

  it('deve encontrar elementos pares', function () {
    var resultado = find([1,2,3,4],ehPar);
    expect(resultado).toEqual([2,4]);
  });

  it('deve retornar undefined caso segundo parâmetro passado não seja função', function () {
    var resultado = find([1,2],{});
    expect(resultado).toEqual(undefined);
  });
});

describe('subtrair()()', function() {
  it('deve subtrair o parametro da primeira execucao da paramentro da segunda execucao(2-1)', function () {
    var resultado = subtrair(2)(1);
    expect(resultado).toEqual(1);
  });

  it('deve subtrair o parametro da primeira execucao da paramentro da segunda execucao(0-0)', function () {
    var resultado = subtrair(0)(0);
    expect(resultado).toEqual(0);
  });

  it('deve subtrair o parametro da primeira execucao da paramentro da segunda execucao(-2-1)', function () {
    var resultado = subtrair(-2)(1);
    expect(resultado).toEqual(-3);
  });
});

describe('iguais(x,y)', function() {
  it('goku == sonGoku', function () {
    var goku = {
    nivel: 'SSJ4',
    golpes: [ { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 } ],
    nome: 'Goku',
    }, sonGoku = {
    nome: 'Goku',
    nivel: 'SSJ4',
    golpes: [ { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 } ]
    };
    var resultado = iguais(goku, sonGoku);
    expect(resultado).toBeTruthy();
  });

  it('goku == sonGoku com recursividade', function () {
    var goku = {
    nivel: 'SSJ4',
    golpes: [ { nome: 'kamehameha', dano: { precisao: 'milhar', valor: 56 } }, { nome: 'genki-dama', dano: 99 } ],
    nome: 'Goku',
    }, sonGoku = {
    nivel: 'SSJ4',
    golpes: [ { nome: 'kamehameha', dano: { precisao: 'milhar', valor: 56 } }, { nome: 'genki-dama', dano: 99 } ],
    nome: 'Goku',
    };
    var resultado = iguais(goku, sonGoku);
    expect(resultado).toEqual(true);
  });

  it('goku != sonGoku', function () {
    var goku = {
    nome: 'Goku',
    nivel: 'SSJ4',
    golpes: [
      { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 }
    ]
    }, sonGoku = {
    nome: 'Goku',
    nivel: 'SSJ4',
    golpes: [
      { nome: 'genki-dama', dano: 99 }, { nome: 'kamehameha', dano: 45 }
    ]
  };
    var resultado = iguais(goku, sonGoku);
    expect(resultado).toEqual(false);
  });

  it('{a:{b:"c"}, d: 1} == {a:{b:"c"}, d: 1}', function () {
    var x = {a:{b:"c"}, d: 1}, y = {a:{b:"c"}, d: 1};
    var resultado = iguais(x, y);
    expect(resultado).toEqual(true);
  });

  it('{a:{b:2}, d: 1} != {a:{f:"f"}, d: 1}', function () {
    var x = {a:{b:2}, d: 1}, y = {a:{f:"f"}, d: 1};
    var resultado = iguais(x, y);
    expect(resultado).toEqual(false);
  });

  it('{a:{b:2}, d: 1} != {a:1, d: 1}', function () {
    var x = {a:{b:2}, d: 1}, y = {a:1, d: 1};
    var resultado = iguais(x, y);
    expect(resultado).toEqual(false);
  });

  it('{a:{b:{c:1}}, d: 2} != {a:{b:{c:3,e:5}}, d: 2}', function () {
    var x = {a:{b:{c:1}}, d: 2}, y = {a:{b:{c:3,e:5}}, d: 2};
    var resultado = iguais(x, y);
    expect(resultado).toEqual(false);
  });


});

describe('ctrlC(x)', function() {
  it('origem != destino', function () {
    var origem = { a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] };
    var destino = ctrlC(origem);
    var resultado = destino != origem;
    expect(resultado).toEqual(true);
  });


  it('ctrlC({a:1}) != {a:1}', function () {
    var resultado = ctrlC({a:1}) != {a:1};
    expect(resultado).toEqual(true);
  });

  it("JSON.stringify(ctrlC({a:1})) == '{\"a\":1}'", function () {
    var resultado = JSON.stringify(ctrlC({a:1}));
    expect(resultado).toEqual('{"a":1}');
  });

  it('ctrlC(5) == 5', function () {
    var resultado = ctrlC(5) == 5;
    expect(resultado).toEqual(true);
  });
});

describe('mesclar(x,y)', function() {
  it('mesclar({a:1}, {b:2})', function () {
    var a = {a:1};
    mesclar(a, {b:2});
    expect(a).toEqual({a:1,b:2});
  });

  it('mesclar({a:1}, {b:2,c:{d:3}})', function () {
    var a = {a:1};
    mesclar(a, {b:2,c:{d:3}});
    expect(a).toEqual({a:1,b:2,c:{d:3}});
  });

  it('mesclar(x,y) iterando em subpropriedades', function () {
    var objeto1 = {
      abacaxi: 0,
      banana: { peso: 52, preco: 100 },
      cereja: 97
    };
    var objeto2 = {
      banana: { preco: 200 },
      damasco: 100
    };
    var objetoMesclado = {
      abacaxi: 0,
      banana: { peso: 52, preco: 200 },
      cereja: 97,
      damasco: 100
    };
    mesclar(objeto1, objeto2, true);
    expect(objetoMesclado).toEqual(objeto1);
  });
});
