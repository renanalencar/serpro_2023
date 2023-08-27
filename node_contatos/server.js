const express = require('express');
const bodyParser = require('body-parser');
const connection = require('./db');

const app = express();
app.use(bodyParser.json());

// Listar contatos
app.get('/contatos', (req, res) => {
  connection.query('SELECT * FROM contatos', (err, results) => {
    if (err) throw err;
    res.json(results);
  });
});

// Obter contato por ID
app.get('/contatos/:id', (req, res) => {
  const id = req.params.id;
  connection.query('SELECT * FROM contatos WHERE id = ?', [id], (err, results) => {
    if (err) throw err;
    if (results.length === 0) {
      res.status(404).json({ message: 'Contato não encontrado' });
    } else {
      res.json(results[0]);
    }
  });
});

// Criar contato
app.post('/contatos', (req, res) => {
  const novoContato = req.body;
  connection.query('INSERT INTO contatos SET ?', [novoContato], (err, results) => {
    if (err) throw err;
    res.status(201).json({ id: results.insertId, ...novoContato });
  });
});

// Atualizar contato
app.put('/contatos/:id', (req, res) => {
  const id = req.params.id;
  const novoContato = req.body;
  connection.query('UPDATE contatos SET ? WHERE id = ?', [novoContato, id], (err) => {
    if (err) throw err;
    res.json({ id, ...novoContato });
  });
});

// Deletar contato
app.delete('/contatos/:id', (req, res) => {
  const id = req.params.id;
  connection.query('DELETE FROM contatos WHERE id = ?', [id], (err) => {
    if (err) throw err;
    res.json({ message: 'Contato removido' });
  });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Servidor rodando na porta ${PORT}`);
});
