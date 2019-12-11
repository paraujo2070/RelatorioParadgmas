package co.s4n.users.persistance

import co.s4n.infrastructure.Connector._
import com.outworkers.phantom.dsl._

class FuncionarioDatabase(override val connector: KeySpaceDef) extends Database[FuncioanrioDatabase](connector){
  object funcModel extends ConcreteFincionarioModel with connector.Connector
} 

object ProductionDb extends UserDatabase(connector)

trait ProductionDatabaseProvider {
  def database: UserDatabase
}

trait ProductionDatabase extends ProductionDatabaseProvider {
  override val database = ProductionDb
}

object EmbeddedDb extends UserDatabase(testConnector)

trait EmbeddedDatabaseProvider {
  def database: FuncionarioDatabase
}

trait EmbeddedDatabase extends EmbeddedDatabaseProvider {
  override val database = EmbeddedDb
}
