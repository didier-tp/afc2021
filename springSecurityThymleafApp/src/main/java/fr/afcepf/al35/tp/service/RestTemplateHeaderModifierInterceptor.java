package fr.afcepf.al35.tp.service;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateHeaderModifierInterceptor
implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(
    HttpRequest request, 
    byte[] body, 
    ClientHttpRequestExecution execution) throws IOException {
	  System.out.println("token =" + DeviseServiceDelegate.token);
	  request.getHeaders().add("Authorization", "Bearer " + DeviseServiceDelegate.token);
      ClientHttpResponse response = execution.execute(request, body);
      return response;
  }
}