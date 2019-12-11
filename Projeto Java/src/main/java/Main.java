
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.MongoCollection;
//import org.bson.Document;
//import java.util.Arrays;
//import com.mongodb.Block;
//import com.mongodb.client.MongoCursor;
//import static com.mongodb.client.model.Filters.*;
//import com.mongodb.client.result.DeleteResult;
//import static com.mongodb.client.model.Updates.*;
//import com.mongodb.client.result.UpdateResult;
//import java.util.ArrayList;
//import java.util.List;
//import org.bson.Document;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		FuncionarioDao funcionariodao = new FuncionarioDao();
		Scanner in = new Scanner(System.in);
		byte op = 0;
		do {
			System.out.println("--------MENU--------");
			System.out.println("Seleciona uma Opção:");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Consultar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Deletar");
			System.out.println("0 - Sair");
			op = in.nextByte();
			switch (op) {
			case 1:
				System.out.println("Digite o nome do funcionario:");
				funcionario.setNome(in.next());
				System.out.println("Digite  a data de nascimento do funcionario:");
				funcionario.setDataDeNascimento(in.next());
				System.out.println("Digite a naturalidade do funcionario:");
				funcionario.setNaturalidade(in.next());
				break;
			case 2:
				System.out.println("Digite a data de nascimento do funcionario");
				System.out.println(funcionariodao.Consultar(in.next()));
				break;
			case 3:
				System.out.println("Digite o nome do funcionario:");
				funcionario.setNome(in.next());
				System.out.println("Digite  a data de nascimento do funcionario:");
				funcionario.setDataDeNascimento(in.next());
				System.out.println("Digite a naturalidade do funcionario:");
				funcionario.setNaturalidade(in.next());
				System.out.println(funcionariodao.Atualizar(funcionario));
				break;
			case 4:
				System.out.println("Digite o RA do Aluno");
				System.out.println(funcionariodao.Excluir(in.next()));
				break;
			default:
				break;
			}
			;

		} while (op != 0);

		Scanner leia = new Scanner(System.in);
		int n1 = 0;
		int n2 = 0;
		System.out.println("Digite o 1º numero: ");
		n1 = leia.nextInt();
		System.out.println("Digite o 2º numero: ");
		n2 = leia.nextInt();
		if (n1 == n2) {
			System.out.println("São iguais");
		} else {
			System.out.println("São Diferentes");
		}

	}

}
