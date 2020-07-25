package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequestMapping(value = "/sms")
@RestController
public class SmsController {
    private final String SMS = "aeazeaz";
    private final String SENDER = "BIP+SMS";
    private final String KEY = "ZhOOzrI5atsfEm5fZStJHQuVeilnzAPKAlRtEiWXRUgsiqXC7gc2hmrykVdOqftHyvYHY7kSglN/IDxz/-/MkFEISC4b5zY4kz";


    @GetMapping("/{phone}")
    void sendSms(@PathVariable String phone) {
        String telephone = "216" + phone;

        String Url_str = "https://bulksms.bipsms.tn/Api/Api.aspx?fct=sms&key=MYKEY&mobile=216XXXXXXXX&sms=Hello+World&sender=YYYYYYY&msg_id=19";

        Url_str = Url_str.replace ("216XXXXXXXX", telephone);
        Url_str = Url_str.replace ("MYKEY", KEY);
        Url_str = Url_str.replace ("Hello+World", SMS);
        Url_str = Url_str.replace ("YYYYYYY", SENDER);
        HttpClient client = HttpClient.newHttpClient ();
        HttpRequest request = HttpRequest.newBuilder ()
                .uri (URI.create (Url_str))
                .build ();
        try {
            client.send (request, HttpResponse.BodyHandlers.ofString ());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace ();
        }


    }
}
