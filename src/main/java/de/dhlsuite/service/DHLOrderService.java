package de.dhlsuite.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhlsuite.data.response.DHLOrderResponse;
import de.dhlsuite.data.DHLOrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DHLOrderService {

    private final RestTemplate restTemplate;
    private final DHLAuthService authService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${dhl.api.base-url}")
    private String baseUrl;

    public DHLOrderService(RestTemplate restTemplate, DHLAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    public DHLOrderResponse createOrder(DHLOrdersRequest request) {

        String token = authService.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        try
        {
            String jsonBody = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(request);
            System.out.println("======== JSON =========");
            System.out.println(jsonBody);
        } catch (JsonProcessingException exception)
        {
            exception.printStackTrace();
        }

        HttpEntity<DHLOrdersRequest> entity = new HttpEntity<>(request, headers);

        String url = baseUrl + "/orders";
        ResponseEntity<DHLOrderResponse> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        entity,
                        DHLOrderResponse.class);
        return response.getBody();
    }
}
