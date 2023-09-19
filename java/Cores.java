import java.util.ArrayList;
import java.util.Collections;

public class Cores {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();

        lista.add("VERDE");
        lista.add("AZUL");
        lista.add("VERMELHO");
        lista.add("AMARELO");
        lista.add("CINZA");
        // Insira na linha mediatamente a seguia a linha de código que atenda ao
        // requisito 1.
        lista.remove(2);
        System.out.println("Lista após exclusão: " + lista);

        // Insira a linha imediatamente a seguir a linha de código que atenda ao
        // requisito 2.
        Collections.sort(lista);
        System.out.println("Lista após ordenação: " + lista);

        alterar(lista, 2, "BRANCO");
        System.out.println("Lista após atualização: " + lista);
    }

    // A partir da próxima linha, crie o método alterar(lista, indice, novaCor).
    public static void alterar(ArrayList<String> lista, int indice, String novaCor) {
        lista.add(2, novaCor); // Errado! Deveria ser lista.set(indice, novaCor);
    }
}