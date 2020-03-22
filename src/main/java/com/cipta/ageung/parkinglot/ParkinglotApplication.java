package com.cipta.ageung.parkinglot;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.PromptProvider;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cipta.ageung.parkinglot"})
public class ParkinglotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkinglotApplication.class, args);
	}
	
	@Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("parkinglot:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
    }

}
