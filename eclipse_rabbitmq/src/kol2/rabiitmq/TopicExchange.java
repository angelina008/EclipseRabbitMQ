package kol2.rabiitmq;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

 
public class TopicExchange { 
 
 public static String EXCHANGE_NAME = "exchange1";
 public static String QUEUE_NAME_1_1 = "topic-queue-1-1";
 public static String QUEUE_NAME_1_2 = "topic-queue-1-2";
 
 
 public static String ROUTING_PATTERN_1_1 = "student.*";
 public static String ROUTING_PATTERN_1_2 = "profesor.*";
 
 public static String ROUTING_KEY_1 = "student.kancelarija";
 public static String ROUTING_KEY_2 = "profesor.*";
 public static String ROUTING_KEY_3 = "student.*";
  
 public void createExchangeAndQueue(){
   try{
      Connection conn = RabbitMQConnection.getConnection();
        if(conn != null){
           Channel channel = conn.createChannel();
           channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.TOPIC.getExchangeName(), true);

           channel.queueDeclare(QUEUE_NAME_1_1, true, false, false, null);
           channel.queueBind(QUEUE_NAME_1_1, EXCHANGE_NAME, ROUTING_PATTERN_1_1);
  
           channel.queueDeclare(QUEUE_NAME_1_2, true, false, false, null);
           channel.queueBind(QUEUE_NAME_1_2, EXCHANGE_NAME, ROUTING_PATTERN_1_2);
           
          
           channel.close();
           conn.close();
       }
   }catch(Exception e){
     e.printStackTrace();
   }
 }
 
}