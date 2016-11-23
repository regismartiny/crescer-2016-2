var itemMagicoEditar = {};


itemMagicoEditar.sucessoNoCadastro = function (resposta) {
    alert(resposta.Mensagem);
}

itemMagicoEditar.erroNoCadastro = function (resposta) {
  alert(resposta.Mensagem);
}