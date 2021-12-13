package kol2.rabiitmq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
 
public class Producer {
  
 private final static String MESSAGE_1 = "175008 - 154";
 private final static String MESSAGE_2 = "Jaon Majkl - 134";
 private final static String MESSAGE_3 = "175008 - 134";

  
 public void publish(){ 
   try{
      Connection conn = RabbitMQConnection.getConnection();
      if(conn != null){
        Channel channel = conn.createChannel();
  
        channel.basicPublish(TopicExchange.EXCHANGE_NAME, TopicExchange.ROUTING_KEY_1, null, MESSAGE_1.getBytes());
        System.out.println(" Message Sent '" + MESSAGE_1 + "'");
   
        channel.basicPublish(TopicExchange.EXCHANGE_NAME, TopicExchange.ROUTING_KEY_2, null, MESSAGE_2.getBytes());
        System.out.println(" Message Sent '" + MESSAGE_2 + "'");

        channel.basicPublish(TopicExchange.EXCHANGE_NAME, TopicExchange.ROUTING_KEY_3, null, MESSAGE_3.getBytes());
        System.out.println(" Message Sent '" + MESSAGE_3 + "'");
  
       
        channel.close();
        conn.close();
      }
   }catch(Exception e){
     e.printStackTrace();
   }
 }
 
}