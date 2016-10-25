describe('iguais(x,y)', function() {
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

  it('{a:{b:{c:1}}, d: 2} != {a:{b:{c:3}}, d: 2}', function () {
    var x = {a:{b:{c:1}}, d: 2}, y = {a:{b:{c:3}}, d: 2};
    var resultado = iguais(x, y);
    expect(resultado).toEqual(false);
  });


});

describe('ctrlC(x)', function() {
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
    expect(JSON.stringify(a)).toEqual('{"a":1,"b":2}');
  });

  it('mesclar({a:1}, {b:2,c:{d:3}})', function () {
    var a = {a:1};
    mesclar(a, {b:2,c:{d:3}});
    expect(JSON.stringify(a)).toEqual('{"a":1,"b":2,"c":{"d":3}}');
  });
});
