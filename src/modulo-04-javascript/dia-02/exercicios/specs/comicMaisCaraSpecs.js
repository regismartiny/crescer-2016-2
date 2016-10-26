describe('comicMaisCara()', function() {
  it('deve retornar a comic mais cara dos heróis da Marvel', function() {
    var herois = new Herois(marvel);
    var resultado = herois.comicMaisCara();
    var comic = {"id":58609,"digitalId":0,"title":"International Iron Man Premiere (Hardcover)","issueNumber":0,"variantDescription":"","description":"Who is Tony Stark, really? Since learning that he was adopted as a baby, this question has cast a shadow over Stark's life. Now, it is time to uncover what his legacy truly is, a journey that will carry Tony into new directions as a man and as a super hero. Alongside his strange new quasi-ally Doctor Doom, Iron Man will discover new things about the Marvel Universe he didn't know existed before! A character deconstruction from Bendis and Maleev along the lines of their award-winning DAREDEVIL run! COLLECTING: INTERNATIONAL IRON MAN #1-7.","modified":"2016-10-21T14:20:16-0400","isbn":"978-1-302-90149-3","upc":"","diamondCode":"JUL161062","ean":"9781302 901493 52999","issn":"","format":"Hardcover","pageCount":160,"textObjects":[{"type":"issue_solicit_text","language":"en-us","text":"Who is Tony Stark, really? Since learning that he was adopted as a baby, this question has cast a shadow over Stark's life. Now, it is time to uncover what his legacy truly is, a journey that will carry Tony into new directions as a man and as a super hero. Alongside his strange new quasi-ally Doctor Doom, Iron Man will discover new things about the Marvel Universe he didn't know existed before! A character deconstruction from Bendis and Maleev along the lines of their award-winning DAREDEVIL run! COLLECTING: INTERNATIONAL IRON MAN #1-7."}],"resourceURI":"http://gateway.marvel.com/v1/public/comics/58609","urls":[{"type":"detail","url":"http://marvel.com/comics/collection/58609/international_iron_man_premiere_hardcover?utm_campaign=apiRef&utm_source=7ae597c1277cc37f2a4001139b3e2199"}],"series":{"resourceURI":"http://gateway.marvel.com/v1/public/series/21392","name":"International Iron Man Premiere (2016)"},"variants":[],"collections":[],"collectedIssues":[],"dates":[{"type":"onsaleDate","date":"2016-10-26T00:00:00-0400"},{"type":"focDate","date":"2016-10-11T00:00:00-0400"}],"prices":[{"type":"printPrice","price":29.99}],"thumbnail":{"path":"http://i.annihil.us/u/prod/marvel/i/mg/1/a0/580a58888f790","extension":"jpg"},"images":[{"path":"http://i.annihil.us/u/prod/marvel/i/mg/1/a0/580a58888f790","extension":"jpg"},{"path":"http://i.annihil.us/u/prod/marvel/i/mg/3/00/564e15e5211d3","extension":"jpg"}],"creators":{"available":3,"collectionURI":"http://gateway.marvel.com/v1/public/comics/58609/creators","items":[{"resourceURI":"http://gateway.marvel.com/v1/public/creators/24","name":"Brian Michael Bendis","role":"writer"},{"resourceURI":"http://gateway.marvel.com/v1/public/creators/25","name":"Alex Maleev","role":"penciller (cover)"},{"resourceURI":"http://gateway.marvel.com/v1/public/creators/4430","name":"Jeff Youngquist","role":"editor"}],"returned":3},"characters":{"available":1,"collectionURI":"http://gateway.marvel.com/v1/public/comics/58609/characters","items":[{"resourceURI":"http://gateway.marvel.com/v1/public/characters/1009368","name":"Iron Man"}],"returned":1},"stories":{"available":2,"collectionURI":"http://gateway.marvel.com/v1/public/comics/58609/stories","items":[{"resourceURI":"http://gateway.marvel.com/v1/public/stories/127818","name":"cover from International Iron Man (2016)","type":"cover"},{"resourceURI":"http://gateway.marvel.com/v1/public/stories/127819","name":"story from International Iron Man (2016)","type":"interiorStory"}],"returned":2},"events":{"available":0,"collectionURI":"http://gateway.marvel.com/v1/public/comics/58609/events","items":[],"returned":0}};
    expect(resultado).toEqual(comic);
  });

  it('deve retornar a comic mais cara de 1 herói', function() {
    var heroi = [{comics: {items: [{prices:[{price:2.0}]},{prices:[{price:4.0}]}]}}];
    var herois = new Herois(heroi);
    var resultado = herois.comicMaisCara();
    var comicMaisCara = {prices:[{price:4.0}]};
    expect(resultado).toEqual(comicMaisCara);
  });

  it('deve retornar a comic mais cara de 2 heróis', function() {
    var heroisComics = [{comics: {items: [{prices:[{price:2.0}]},{prices:[{price:4.0}]}]}},
                        {comics: {items: [{prices:[{price:1.0}]},{prices:[{price:6.0}]}]}}];
    var herois = new Herois(heroisComics);
    var resultado = herois.comicMaisCara();
    var comicMaisCara = {prices:[{price:6.0}]};
    expect(resultado).toEqual(comicMaisCara);
  });
});
