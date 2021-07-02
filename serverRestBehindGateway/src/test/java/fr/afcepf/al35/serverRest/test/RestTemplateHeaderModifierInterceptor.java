package fr.afcepf.al35.serverRest.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

public class RestTemplateHeaderModifierInterceptor
implements ClientHttpRequestInterceptor {
	
  public static String token;
  
  
  public static RestTemplate initRestTemplate() {
      RestTemplate restTemplate = new RestTemplate();

      List<ClientHttpRequestInterceptor> interceptors
        = restTemplate.getInterceptors();
      if (CollectionUtils.isEmpty(interceptors)) {
          interceptors = new ArrayList<>();
      }
      interceptors.add(new RestTemplateHeaderModifierInterceptor());
      restTemplate.setInterceptors(interceptors);
      return restTemplate;
  }

  @Override
  public ClientHttpResponse intercept(
    HttpRequest request, 
    byte[] body, 
    ClientHttpRequestExecution execution) throws IOException {
	  System.out.println("token =" + RestTemplateHeaderModifierInterceptor.token);
	  request.getHeaders().add("Authorization", "Bearer " + RestTemplateHeaderModifierInterceptor.token);
      ClientHttpResponse response = execution.execute(request, body);
      return response;
  }
}