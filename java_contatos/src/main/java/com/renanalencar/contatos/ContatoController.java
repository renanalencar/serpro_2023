@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> listarContatos() {
        return contatoService.listarContatos();
    }

    @GetMapping("/{id}")
    public Contato buscarContatoPorId(@PathVariable Long id) {
        return contatoService.buscarContatoPorId(id);
    }

    @PostMapping
    public Contato criarContato(@RequestBody Contato contato) {
        return contatoService.criarContato(contato);
    }

    @PutMapping("/{id}")
    public Contato atualizarContato(@PathVariable Long id, @RequestBody Contato novoContato) {
        return contatoService.atualizarContato(id, novoContato);
    }

    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Long id) {
        contatoService.deletarContato(id);
    }
}
