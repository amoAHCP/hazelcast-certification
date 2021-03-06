package com.hazelcast.certification.process;

import com.hazelcast.certification.domain.Transaction;
import com.hazelcast.certification.domain.TransactionList;
import com.hazelcast.certification.util.TransactionsUtil;
import com.hazelcast.internal.serialization.impl.DefaultSerializationServiceBuilder;
import com.hazelcast.internal.serialization.impl.ObjectDataOutputStream;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by michi on 12.06.17.
 */
public class Size {
    public static void main(String[] args) throws Exception {
        TransactionsUtil transactionsUtil = new TransactionsUtil();
        List<Transaction> transactions = transactionsUtil.createAndGetCreditCardTransactions(transactionsUtil.generateCreditCardNumber(0), 20);

        TransactionList transactionList = new TransactionList(transactions);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectDataOutputStream odos = new ObjectDataOutputStream(bos, new DefaultSerializationServiceBuilder().build());

        transactionList.writeData(odos);

        System.out.println("size of a transactions: " + bos.size() + " bytes");
    }
}
