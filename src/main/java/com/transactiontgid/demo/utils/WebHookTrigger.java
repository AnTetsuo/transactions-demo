package com.transactiontgid.demo.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebHookTrigger {
  public void sendHook(Object payload) {
    try {
      this.dispatch(payload);
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    catch (InterruptedException ex) {
      System.out.println(ex.getMessage());
    }
  }
  public void dispatch(Object payload) throws IOException, InterruptedException {
    String serviceUrl = "https://webhook.site/9dec50c7-59a0-412c-8f59-c4bfecb88b5d";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(serviceUrl))
        .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
        .build();
    client.send(request, HttpResponse.BodyHandlers.ofString());
  }
}
