package co.s4n.users.services

import java.util.Properties

import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.CirceSupport._
import io.circe.generic.auto._
import co.s4n.users.persistance.{User, UserRepository}
import scala.concurrent.{ExecutionContext, Future}
import Responsable._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

class FuncionarioRoute(funcRepo: FuncionarioRepository)(implicit ec: ExecutionContext){
  def handle[T](arg: Future[T])(implicit resp: Responsable[T]) = {
    resp.toResponse(arg)
  }

  val route = path("Funcionario" / Segment) {
    username => {
      get {
        complete(handle(userRepo.getUserByFuncionario(nome)))
        } ~ delete {
          complete(handle(userRepo.deleteByFuncioanrio(nome))) 
        }
    }
  } ~ path("Funcionario"){
    post {
      entity(as[Funcionario]) { func =>
        val props = new Properties()
        props.put("bootstrap.servers", "127.0.0.1:9092")
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        props.put("auto.commit.interval.ms", "1000")
        val producer = new KafkaProducer[String, String](props)
        producer.send(new ProducerRecord[String, String]("Funcionario-creation", func.toString))
        complete(handle(funcRepo.saveOrUpdate(func)))
      }
      } ~ put {
        entity(as[func]){ Funcionario =>
          complete(handle(funcRepo.saveOrUpdate(func)))
        }
        } ~ get {
          complete(handle(funcRepo.getFunc))
        }
  } 
}
