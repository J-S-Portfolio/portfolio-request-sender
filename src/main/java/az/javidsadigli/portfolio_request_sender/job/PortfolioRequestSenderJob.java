package az.javidsadigli.portfolio_request_sender.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import az.javidsadigli.portfolio_request_sender.client.PortfolioClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class PortfolioRequestSenderJob 
{
    @Value("${application.request-sender-endpoints.portfolio}")
    private String portfolioTestEndpoint; 

    private final PortfolioClient portfolioClient;

    @Scheduled(fixedRate = 60000)
    private void execute()
    {
        log.debug("Portfolio request sender job started execution.");
        this.sendRequestToPortfolioTestUrl();
    }

    private void sendRequestToPortfolioTestUrl()
    {
        String response = this.portfolioClient.getTestServer(portfolioTestEndpoint);
        log.debug("Server response : {}", response);
    }
}