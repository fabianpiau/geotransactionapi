package com.sagepay.hackaton;

import com.sagepay.hackaton.model.Location;
import com.sagepay.hackaton.model.Transaction;
import com.sagepay.hackaton.repository.LocationRepository;
import com.sagepay.hackaton.repository.TransactionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class HackatonApplication implements CommandLineRunner {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public static void main(String[] args) {
        SpringApplication.run(HackatonApplication.class, args);
    }

    private void generateAndSaveTransactions(int nbTransactions) {
        for (int i = 0; i < nbTransactions; i++) {
            transactionRepository.save(new Transaction(generateRandomAmout(), randomLocationFromDb(), generateRandomDate()));
        }
    }

    private Date generateRandomDate() {
        long rangeBegin = Timestamp.valueOf("2015-01-01 00:00:00").getTime();
        long rangeEnd = new DateTime().getMillis();
        long diff = rangeEnd - rangeBegin + 1;
        return new Timestamp(rangeBegin + (long)(Math.random() * diff));
    }

    private Location randomLocationFromDb() {
        List<Location> locations = locationRepository.findAll();
        int max = locations.size();
        return locations.get(randInt(0, max - 1));
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private Integer generateRandomAmout() {
        return randInt(100, 100000);
    }

    @Override
    public void run(String... strings) throws Exception {
        // Do something at the start
//        transactionRepository.deleteAll();
//        generateAndSaveTransactions(1000);

        System.out.println("Transactions found with findByLocationRegion('West Midlands'):");
        System.out.println("--------------------------------");
        for (Transaction transaction : transactionRepository.findByLocationRegion("West Midlands")) {
            System.out.println(transaction);
        }
        System.out.println();
    }
}
