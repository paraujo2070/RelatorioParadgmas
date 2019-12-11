package co.s4n.users.persistance

import com.outworkers.phantom.dsl._
import scala.concurrent.Future
import java.util.UUID

class FuncionarioModel extends CassandraTable[ConcreteUserModel, Func] {
  override def tableName: String = "Funcionario"

  object id extends UUIDColumn(this) {
    override lazy val name = "func_id"
  }

  object name extends StringColumn(this) with PartitionKey
  
  object nacionalidade extends StringColumn(this)
  
  object dataDeNascimento extends StringColumn(this)


  override def fromRow(r: Row): Funcionario = Funcionario (id(r), nome(r), nacionalidade(r), dataDeNascimento(r))
}

abstract class ConcreteFuncionarioModel extends funcModel with RootConnector {
  def getUserByFuncionario(nome: String): Future[Option[Funcionario]] = {
    select
      .where(_.nome eqs nome)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .one()
  }

  def store(func: Funcionario): Future[Funcionario] = {
    insert
      .value(_.id, func.id)
      .value(_.nome, func.nome)
      .value(_.nacionalidade, func.nacionalidade)
      .value(_.dataDeNascimento, func.datadeDeNascimento)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .future()
      .map(_ => func)
  }

  def deleteUserByfuncionario(nome: String): Future[String] = {
    val query = delete
      .where(_.nome eqs nome)
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .future()
    query.map(_ => nome)
  }

  def getFuncionario: Future[Seq[Funcionario]] = {
    select
      .consistencyLevel_=(ConsistencyLevel.ONE)
      .fetch()
  }
}
