import java.util.ArrayList;

public class FSM {
    public static void main(String[] args) {
        // Cria a lista de agentes (personagens)
        ArrayList<Character> characters = new ArrayList<>();
        characters.add(new Blacksmith());
        characters.add(new Guard());

        // Variável para controlar a quantidade de iterações
        int contador = 1;

        while (contador <= 40) {
            // Delega a ação iterando pela lista de forma limpa e abstrata
            for (Character c : characters) {
                c.update();
            }
            contador++;
        }
    }
}