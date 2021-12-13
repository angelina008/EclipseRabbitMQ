package kol2.rabiitmq;

public class Demo {
  
 public static void main(String args[]){
   try{
     TopicExchange ex = new TopicExchange();
     ex.createExchangeAndQueue();

     Producer produce = new Producer();
     produce.publish();

     Receiver receive = new Receiver();
     receive.receive();
     
   }catch(Exception e){
     e.getMessage();
   }
 }
 
}