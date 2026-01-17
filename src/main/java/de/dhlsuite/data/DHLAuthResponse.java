package de.dhlsuite.data;

import lombok.Data;

@Data
public class DHLAuthResponse {
    private String access_token;
    private String token_type;
    private int expires_in;
}
