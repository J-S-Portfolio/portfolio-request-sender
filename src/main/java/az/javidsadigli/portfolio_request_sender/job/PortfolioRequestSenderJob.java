package az.javidsadigli.portfolio_request_sender.job;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import az.javidsadigli.portfolio_request_sender.config.RequestSenderProperties;

/**
 * Sends a GET request to every URL listed in application.request-sender.urls.
 * No code changes are needed to add a new URL.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PortfolioRequestSenderJob 
{
    private final RequestSenderProperties properties;
    private final RestClient requestSenderRestClient;

    @Scheduled(fixedRateString = "${application.request-sender.interval:60000}")
    public void execute()
    {
        log.debug("Request sender job started for {} url(s).", properties.urls().size());
        properties.urls().forEach(this::sendRequest);
    }

    private void sendRequest(String url)
    {
        // Each URL is isolated: one failing service must not stop the others.
        try
        {
            ResponseEntity<String> response = requestSenderRestClient.get()
                    .uri(url)
                    .retrieve()
                    .toEntity(String.class);
            log.info("{} -> {}", url, response.getStatusCode());
            log.debug("{} response body: {}", url, response.getBody());
        }
        catch (Exception e)
        {
            log.warn("{} -> failed: {}", url, e.getMessage());
        }
    }
}
