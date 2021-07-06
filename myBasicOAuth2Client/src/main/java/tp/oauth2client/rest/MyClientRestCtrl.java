package tp.oauth2client.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClientRestCtrl {
	@Value("${resource.server.url}")
    private String remoteResourceServer;

    private RestTemplate restTemplate;

    private OAuth2AuthorizedClientService authorizedClientService;

    public MyClientRestCtrl(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/infos")
    public String infos(OAuth2AuthenticationToken authenticationToken) {
    	System.out.println("authenticationToken.getAuthorizedClientRegistrationId()="+authenticationToken.getAuthorizedClientRegistrationId());
        System.out.println("authenticationToken.getName()="+authenticationToken.getName());
    	OAuth2AuthorizedClient oAuth2AuthorizedClient = 
        		this.authorizedClientService.loadAuthorizedClient(authenticationToken.getAuthorizedClientRegistrationId(), authenticationToken.getName());
    	OAuth2AccessToken oAuth2AccessToken = oAuth2AuthorizedClient.getAccessToken();

        String response = "Hello, " + authenticationToken.getPrincipal().getName();
        response += "</br></br>";
        response += "Here is your accees token :</br>" + oAuth2AccessToken.getTokenValue();
        response += "</br>";
        response += "</br>You can use it to call these Resource Server APIs:";
        response += "</br></br>";
        response += "<a href='/read'>Call Resource Server Read API</a>";
        response += "</br>";
        response += "<a href='/write'>Call Resource Server Write API</a>";
        return response;
    }

    @GetMapping("/read")
    public String read(OAuth2AuthenticationToken authenticationToken) {
        String url = remoteResourceServer + "/read";
        return callResourceServer(authenticationToken, url);
    }

    @GetMapping("/write")
    public String write(OAuth2AuthenticationToken authenticationToken) {
        String url = remoteResourceServer + "/write";
        return callResourceServer(authenticationToken, url);
    }

    private String callResourceServer(OAuth2AuthenticationToken authenticationToken, String url) {
        OAuth2AuthorizedClient oAuth2AuthorizedClient = this.authorizedClientService.loadAuthorizedClient(authenticationToken.getAuthorizedClientRegistrationId(), authenticationToken.getName());
        OAuth2AccessToken oAuth2AccessToken = oAuth2AuthorizedClient.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + oAuth2AccessToken.getTokenValue());

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> responseEntity = null;

        String response = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            response = responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            response = e.getMessage();
        }
        return response;
    }
}
