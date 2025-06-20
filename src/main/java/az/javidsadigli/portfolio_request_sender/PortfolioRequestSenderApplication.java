package az.javidsadigli.portfolio_request_sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class PortfolioRequestSenderApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(PortfolioRequestSenderApplication.class, args);
	}
}
