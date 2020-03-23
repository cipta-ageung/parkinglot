package com.cipta.ageung.parkinglot.stream;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CarParkingLotRunner implements CommandLineRunner {

    @Value("classpath:input.txt")
    private Resource res;

    @Autowired
    private CarParkingLotStream carParkingLotStream;

    @Override
    public void run(String... args) throws Exception {

        Map<String, Integer> words =  carParkingLotStream.getWordsCount(res);

        for (String key : words.keySet()) {

            System.out.println(key + ": " + words.get(key));
        }
    }
}
