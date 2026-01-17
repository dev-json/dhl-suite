package de.dhlsuite.service;

import de.dhlsuite.data.DHLAuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class DHLAuthService {

    private final RestTemplate restTemplate;

    @Value("${dhl.auth.url}")
    private String authUrl;

    @Value("${dhl.client.id}")
    private String clientId;

    @Value("${dhl.client.secret}")
    private String clientSecret;

    @Value("${dhl.username}")
    private String username;

    @Value("${dhl.password}")
    private String password;

    public DHLAuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "password");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        form.add("username", username);
        form.add("password", password);

        HttpEntity<MultiValueMap<String, String>> entity =
                new HttpEntity<>(form, headers);

        ResponseEntity<DHLAuthResponse> response =
                restTemplate.exchange(
                        authUrl,
                        HttpMethod.POST,
                        entity,
                        DHLAuthResponse.class
                );

        return response.getBody().getAccess_token();
    }
}

