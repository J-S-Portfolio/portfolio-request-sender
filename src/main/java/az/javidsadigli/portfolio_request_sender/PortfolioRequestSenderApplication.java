package az.javidsadigli.portfolio_request_sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ConfigurationPropertiesScan
@SpringBootApplication
public class PortfolioRequestSenderApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(PortfolioRequestSenderApplication.class, args);
	}
}
