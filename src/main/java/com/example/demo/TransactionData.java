package com.example.demo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionData {
    private int debitCash;
    private int creditCash;
    private BigDecimal amount;
}
