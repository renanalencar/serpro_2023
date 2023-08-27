const chai = require('chai');
const chaiHttp = require('chai-http');
const server = require('../server');

chai.use(chaiHttp);
chai.should();

describe('Contatos API', () => {
  it('Deve listar todos os contatos', (done) => {
    chai.request(server)
      .get('/contatos')
      .end((err, res) => {
        res.should.have.status(200);
        res.body.should.be.a('array');
        done();
      });
  });

  // Implemente testes similares para as outras rotas (buscar por ID, criar, atualizar, deletar)
});
