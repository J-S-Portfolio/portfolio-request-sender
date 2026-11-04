package az.javidsadigli.portfolio_request_sender.config;

import java.time.Duration;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Everything the request sender needs, read from application.properties.
 * To ping a new service, just add its full URL to application.request-sender.urls.
 */
@ConfigurationProperties(prefix = "application.request-sender")
public record RequestSenderProperties(
        @DefaultValue List<String> urls,
        @DefaultValue("10s") Duration connectTimeout,
        @DefaultValue("60s") Duration readTimeout)
{
}
