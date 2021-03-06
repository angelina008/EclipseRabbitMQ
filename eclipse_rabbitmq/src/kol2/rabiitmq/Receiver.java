package kol2.rabiitmq;
import java.io.IOException;
 
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
 
public class Receiver {
 
 public void receive(){
   try{
     Connection conn = RabbitMQConnection.getConnection();
     if(conn != null){
       Channel channel = conn.createChannel();
       Consumer consumer1 = new DefaultConsumer(channel) {
         @Override
         public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
           String message = new String(body, "UTF-8");
           System.out.println(" Message Received Queue 1_1 (student's actions) '" + message + "'");
         }
       };
       channel.basicConsume(TopicExchange.QUEUE_NAME_1_1, true, consumer1);
       Consumer consumer4 = new DefaultConsumer(channel) {
           @Override
           public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
             String message = new String(body, "UTF-8");
             System.out.println(" Message Received Queue 1_2 (profesors's actions)'" + message + "'");
           }
         };
         channel.basicConsume(TopicExchange.QUEUE_NAME_1_2, true, consumer4);
     
       
       Thread.sleep(1000);
       channel.close();
       conn.close();
     }
   }catch(Exception e){
      e.printStackTrace();
   }
 }
  
}