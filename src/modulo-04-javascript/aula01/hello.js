console.log('Olá JS!');
console.log('Olá \'JS!\'');


var elfo = { nome: 'Legolas', experiencia: 1 };
console.log("Nome:", elfo.nome);

elfo.flechas = 42;

//delete elfo.flechas;

console.log(elfo);

elfo['Nome Completo'] = 'Legolas da Silva';

elfo.atirarFlecha = function(dwarf) {
  dwarf.vida -= 10;
  elfo.flechas--;
  elfo.experiencia++;
}

var dwarf = { vida: 110 };

elfo.atirarFlecha(dwarf);
