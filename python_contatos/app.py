from flask import Flask, request, jsonify
import mysql.connector

app = Flask(__name__)

# Configurações do banco de dados
db = mysql.connector.connect(
    host="localhost",
    user="seu_usuario",
    password="sua_senha",
    database="contatosdb"
)
cursor = db.cursor()

# Rota para listar todos os contatos
@app.route('/contatos', methods=['GET'])
def listar_contatos():
    cursor.execute("SELECT * FROM contatos")
    contatos = cursor.fetchall()
    return jsonify(contatos)

# Rota para obter um contato por ID
@app.route('/contatos/<int:id>', methods=['GET'])
def obter_contato(id):
    cursor.execute("SELECT * FROM contatos WHERE id = %s", (id,))
    contato = cursor.fetchone()
    if contato:
        return jsonify(contato)
    return jsonify(message="Contato não encontrado"), 404

# Rota para criar um novo contato
@app.route('/contatos', methods=['POST'])
def criar_contato():
    novo_contato = request.get_json()
    cursor.execute("INSERT INTO contatos (nome, email, telefone) VALUES (%s, %s, %s)",
                   (novo_contato['nome'], novo_contato['email'], novo_contato['telefone']))
    db.commit()
    return jsonify(id=cursor.lastrowid, **novo_contato), 201

# Rota para atualizar um contato existente
@app.route('/contatos/<int:id>', methods=['PUT'])
def atualizar_contato(id):
    novo_contato = request.get_json()
    cursor.execute("UPDATE contatos SET nome = %s, email = %s, telefone = %s WHERE id = %s",
                   (novo_contato['nome'], novo_contato['email'], novo_contato['telefone'], id))
    db.commit()
    return jsonify(id=id, **novo_contato)

# Rota para deletar um contato
@app.route('/contatos/<int:id>', methods=['DELETE'])
def deletar_contato(id):
    cursor.execute("DELETE FROM contatos WHERE id = %s", (id,))
    db.commit()
    return jsonify(message="Contato removido")

if __name__ == '__main__':
    app.run(debug=True)
