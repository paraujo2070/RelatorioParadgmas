package co.s4n.users.persistance

import java.util.UUID;
import scala.util.{Try, Success, Failure}


case class Funcionario(
  id: UUID, 
  nome: String,
  Nacionalidade: String,
  dataDeNascimento: String
) 
