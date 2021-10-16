package cz.tmobile;

import java.time.LocalDateTime;
import lombok.Data;

@Data
class Transaction {

    private String company;
    private String frequency;
    private LocalDateTime dateTime;
    private int number;
}
