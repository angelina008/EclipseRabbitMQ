package kol2.rabiitmq;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
public class RabbitMQConnection {
  
  public static Connection getConnection(){
    Connection conn = null;
    try{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        conn = factory.newConnection();
    }catch(Exception e){
        e.getMessage();
    }
    return conn;
  }
 
}