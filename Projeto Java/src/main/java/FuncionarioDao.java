import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.client.model.Filters.*;

import java.util.Arrays;

import com.mongodb.Block;
import com.mongodb.client.MongoCursor;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Updates.*;

import com.mongodb.client.result.UpdateResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.bson.Document;


public class FuncionarioDao {
	MongoClient mongoClient = new MongoClient( "localhost" );
	MongoDatabase database = mongoClient.getDatabase("unisal");
	MongoCollection<Document> collection = database.getCollection("Funcionario");
	
	public String Cadastrar(Funcionario funcio){
		Long cont = collection.count();
		try {
			Document doc = new Document("dataDeNascimento",funcio.getDataDeNascimento()).append("Nome", funcio.getNome()).append("naturalidade", funcio.getNaturalidade());
			collection.insertOne(doc);
			return cont == collection.count()? "Erro no cadastro!" : "Cadastro Efetuado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String Consultar(String ra){
		Document myDoc = collection.find(eq("Ra", ra)).first();
		return myDoc.toJson();
	}
	
	public String Atualizar(Funcionario funcionario){
		try {
			collection.updateOne(eq("dataDeNacimento", funcionario.getDataDeNascimento()), new Document("$set", new Document("Nome", funcionario.getNome()).append("naturalidade", funcionario.getNaturalidade())));
			return "Atualização efetuado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String Excluir(String ra){
		Long cont = collection.count();
		collection.deleteOne(eq("DataDeNascimento", ra));
		return cont == collection.count()? "Erro na exclusão" : "Exclusão efetuada com sucesso!";
	}
}
