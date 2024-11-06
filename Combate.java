import java.util.Scanner;

class Campeao {
    private String nome;
    private int ataque;
    private int armadura;
    private int vida;

    public Campeao(String nome, int ataque, int armadura, int vida) {
        this.nome = nome;
        this.ataque = ataque;
        this.armadura = armadura;
        this.vida = vida;
    }

    public void takeDamage(int dano) {
        int danoRecebido = dano - this.armadura;
        if (danoRecebido < 1) {
            danoRecebido = 1;
        }
        this.vida -= danoRecebido;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public String status() {
        return this.nome + " - Vida: " + this.vida + (this.vida == 0 ? " (morreu)" : "");
    }

    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }
}

public class Combate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coleta dados do primeiro campeão
        System.out.print("Digite o nome do primeiro campeão: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite o ataque do primeiro campeão: ");
        int ataque1 = scanner.nextInt();
        System.out.print("Digite a armadura do primeiro campeão: ");
        int armadura1 = scanner.nextInt();
        System.out.print("Digite a vida do primeiro campeão: ");
        int vida1 = scanner.nextInt();

        // Cria o primeiro campeão
        Campeao campeao1 = new Campeao(nome1, ataque1, armadura1, vida1);

        // Coleta dados do segundo campeão
        scanner.nextLine();  // Limpar o buffer
        System.out.print("Digite o nome do segundo campeão: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite o ataque do segundo campeão: ");
        int ataque2 = scanner.nextInt();
        System.out.print("Digite a armadura do segundo campeão: ");
        int armadura2 = scanner.nextInt();
        System.out.print("Digite a vida do segundo campeão: ");
        int vida2 = scanner.nextInt();

        // Cria o segundo campeão
        Campeao campeao2 = new Campeao(nome2, ataque2, armadura2, vida2);

        // Coleta o número de turnos
        System.out.print("Digite o número de turnos: ");
        int turnos = scanner.nextInt();

        // Executa o combate por turnos
        for (int i = 1; i <= turnos; i++) {
            System.out.println("Turno " + i);

            // Ambos os campeões atacam ao mesmo tempo
            campeao1.takeDamage(campeao2.getAtaque());
            campeao2.takeDamage(campeao1.getAtaque());

            // Mostra o status dos campeões
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());

            // Verifica se algum dos campeões morreu
            if (campeao1.getVida() == 0 || campeao2.getVida() == 0) {
                System.out.println("FIM DO COMBATE");
                break;
            }
        }
        
        // Caso nenhum campeão tenha morrido ao final dos turnos
        if (campeao1.getVida() > 0 && campeao2.getVida() > 0) {
            System.out.println("Combate terminou após " + turnos + " turnos.");
        }

        scanner.close();
    }
}
