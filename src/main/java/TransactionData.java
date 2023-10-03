import lombok.Data;

@Data
public class TransactionData {
    private int debitCash;
    private int creditCash;
    private int sum;
}
