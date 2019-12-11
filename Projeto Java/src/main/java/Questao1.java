import java.util.Scanner;

public class Questao1 {
	
	Scanner sc = new Scanner(System.in);
    int cels;

    public Questao1() {
        System.out.println("Entre com a temperatura Celsius: ");
        setCels(sc.nextInt());
        System.out.println("A Temperatura convvertida é de: " + getCels());
    }

    public int getCels() {
        return cels;
    }

    public void setCels(int cels) {
        this.cels = (cels - 32) * 5 / 9;
    }

}
