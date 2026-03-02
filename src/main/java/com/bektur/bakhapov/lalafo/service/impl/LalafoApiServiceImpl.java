package com.bektur.bakhapov.lalafo.service.impl;

import com.bektur.bakhapov.lalafo.payload.response.ad.AdsPageResponse;
import com.bektur.bakhapov.lalafo.service.LalafoApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class LalafoApiServiceImpl implements LalafoApiService {

    @Value("${lalafo.api.url}")
    private String lalafoApiUrl;

    public static final String LANGUAGE = "language";
    public static final String COUNTRY_ID = "country-id";
    public static final String DEVICE = "device";

    private final RestTemplate restTemplate;

    public LalafoApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AdsPageResponse fetchAds() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(LANGUAGE, "ru_RU");
        headers.set(COUNTRY_ID, "12");
        headers.set(DEVICE, "pc");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(lalafoApiUrl, HttpMethod.GET,
                    requestEntity, AdsPageResponse.class).getBody();
        } catch (ResourceAccessException rae) {
            throw new ResourceAccessException("Failed to access external service.");
        }
    }
}