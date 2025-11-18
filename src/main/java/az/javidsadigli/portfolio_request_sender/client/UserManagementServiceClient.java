package az.javidsadigli.portfolio_request_sender.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user-management-service-client", url = "${application.request-sender-urls.user-management-service}")
public interface UserManagementServiceClient 
{
    @RequestMapping(method = RequestMethod.GET, value = "{endpoint}")
    public String getTestServer(@PathVariable(value = "endpoint") String endpoint);
}
