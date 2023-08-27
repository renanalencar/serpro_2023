import unittest
import json
from app import app

class TestApp(unittest.TestCase):

    def setUp(self):
        self.app = app.test_client()
        self.app.testing = True

    def test_listar_contatos(self):
        response = self.app.get('/contatos')
        data = json.loads(response.data)
        self.assertEqual(response.status_code, 200)
        self.assertIsInstance(data, list)

    # Implemente testes similares para as outras rotas (obter por ID, criar, atualizar, deletar)

if __name__ == '__main__':
    unittest.main()
