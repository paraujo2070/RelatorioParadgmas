package co.s4n.users.persistance

import co.s4n.users.persistance.{ProductionDatabase, User}
import com.outworkers.phantom.dsl._
import scala.concurrent.Future

trait funcRepository extends ProductionDatabase {
  def getUserByFuncionario(nome: String): Future[Option[Funcionario]] = 
    database.userModel.getUserByUsername(nome)

  def saveOrUpdate(func: Funcionario): Future[Funcionario] =
    database.FuncModel.store(func)

  def deleteByFuncinario(nome: String): Future[String] =
    database.FuncModel.deleteUserByUsername(nome)

  def getUsers: Future[Seq[Funcionario]] =
    database.funcModel.getFuncionario
}

object FuncionarioRepository extends FuncionarioRepository with ProductionDatabase
