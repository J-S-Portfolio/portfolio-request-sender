package az.javidsadigli.portfolio_request_sender.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
    @GetMapping(value = "/")
    public String isOn()
    {
        return "Request sender server is on.";
    }
}
