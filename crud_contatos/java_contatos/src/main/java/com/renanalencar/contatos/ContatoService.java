@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    public Contato buscarContatoPorId(Long id) {
        return contatoRepository.findById(id).orElse(null);
    }

    public Contato criarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato atualizarContato(Long id, Contato novoContato) {
        Contato contatoExistente = contatoRepository.findById(id).orElse(null);
        if (contatoExistente != null) {
            contatoExistente.setNome(novoContato.getNome());
            contatoExistente.setEmail(novoContato.getEmail());
            contatoExistente.setTelefone(novoContato.getTelefone());
            return contatoRepository.save(contatoExistente);
        }
        return null;
    }

    public void deletarContato(Long id) {
        contatoRepository.deleteById(id);
    }
}
