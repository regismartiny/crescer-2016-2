class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {
    self.$btnSincronizarComMarvel = $('#btn-sincronizar-com-marvel');
    self.$btnSincronizarComMarvel.on('click', self.buscarHeroisMarvel);
  }

  sincronizarComMarvel(self) {
    this.buscarHeroisMarvel();
  }

  buscarHeroisMarvel(self) {
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=068d4b47678bcc4e93442d51baccbf19&orderBy=-modified&limit=20';
    $.get(url).done(function (res) {
      res.data.results.forEach(
        (heroiMarvel) => {
          let heroiASerCriado = {
            nome: heroiMarvel.name,
            urlThumbnail: heroiMarvel.thumbnail.path + '.' + heroiMarvel.thumbnail.extension
          }
          self.cadastrarNovoHeroi(heroiASerCriado)
          self.buscarHeroisBanco(self);
        })
    });
  }

  cadastrarNovoHeroi(heroi) {
    console.log('Cadastrou!!!');
    $.post('/api/herois', {
      nome: heroi.nome,
      urlThumbnail: heroi.urlThumbnail
    }).done((res) => {
      console.log('novo id', res.id);
    });
  }

  buscarHeroisBanco(self) {
    $.get('/api/herois')
      .done(function (res) {
        let renderizar = marvelflix.render('.tela', 'tela-principal', {
          chars: res.map(function (item) {
            return {
              id: item.id,
              name: item.nome,
              thumbnail: item.urlThumbnail
            }
          })
        });
        //renderizar.then(self.registrarBindsEventos.bind(self));
        renderizar.then(() => {
          this.registrarBindsEventos(this);
        })
      }.bind(self));
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    let self = this;

    self.buscarHeroisMarvel(self);    

    //exibir dados direto da API
    /*let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=068d4b47678bcc4e93442d51baccbf19&orderBy=-modified&limit=20';
    $.get(url).done(function (res) {
      console.log(res.data.results)
      let renderizar = marvelflix.render('.tela', 'tela-principal', {
        chars: res.data.results.map(function (item) {
          return {
            id: item.id,
            name: item.name,
            thumbnail: item.thumbnail.path + '.' + item.thumbnail.extension
          }
        })
      });
      renderizar.then(() => {
        self.registrarBindsEventos(self);
      });
    });*/
  }
}
