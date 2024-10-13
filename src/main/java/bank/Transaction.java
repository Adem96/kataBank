package bank;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {


    private double amount;

    private double balance;

    private LocalDate date;

}
