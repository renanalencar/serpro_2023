@RunWith(SpringRunner.class)
@SpringBootTest
public class ContatoServiceTest {

    @Autowired
    private ContatoService contatoService;

    @Test
    public void testCriarContato() {
        // Crie um novo contato e verifique se ele foi salvo corretamente
    }

    @Test
    public void testBuscarContatoPorId() {
        // Busque um contato por ID e verifique se as informações estão corretas
    }

    @Test
    public void testAtualizarContato() {
        // Atualize um contato e verifique se as informações foram atualizadas corretamente
    }

    @Test
    public void testDeletarContato() {
        // Crie um contato, delete-o e verifique se ele foi removido corretamente
    }
}
