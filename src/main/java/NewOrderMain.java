
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      try(var dispacher =new KafkaDispatcher()){
          var topic = "ECOMMERCE_NEW_ORDER";
          for (int i = 0; i < 10; i++) {
              var key = UUID.randomUUID().toString();
              var value = key+",5675656,778787776";
              dispacher.send(topic,key, value);
              var email= "Thank you your order";
              dispacher.send(topic,key,email);
          }
      }
    }
}
