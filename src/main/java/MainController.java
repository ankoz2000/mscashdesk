import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final String topic = "mscashdesc";

    @Autowired
    private KafkaTemplate<String, TransactionData> kafkaTemplate;

    @PostMapping("")
    public void startTransaction(@RequestBody TransactionData transactionData) {
        kafkaTemplate.send(topic, "transactionData", transactionData);
    }
}
