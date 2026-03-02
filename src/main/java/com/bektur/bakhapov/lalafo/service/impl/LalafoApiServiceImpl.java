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

import java.util.Random;

@Service
public class LalafoApiServiceImpl implements LalafoApiService {

    @Value("${lalafo.api.url}")
    private String LALAFO_API_URL;

    @Value("${lalafo.api.params}")
    private String LALAFO_API_PARAMS;

    private static final String LANGUAGE = "language";
    private static final String COUNTRY_ID = "country-id";
    private static final String DEVICE = "device";

    private static final long MIN_RANGE = 1_000_000_000_0000L;
    private static final long MAX_RANGE = 9_000_000_000_0000L;

    private final RestTemplate restTemplate;

    public LalafoApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AdsPageResponse fetchAds(Integer page) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(LANGUAGE, "ru_RU");
        headers.set(COUNTRY_ID, "12");
        headers.set(DEVICE, "pc");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        Random random = new Random();
        long number = MIN_RANGE + (long) (random.nextDouble() * MAX_RANGE);

        try {
            return restTemplate.exchange( LALAFO_API_URL + page + LALAFO_API_PARAMS + number,
                    HttpMethod.GET,
                    requestEntity,
                    AdsPageResponse.class).getBody();
        } catch (ResourceAccessException rae) {
            throw new ResourceAccessException("Failed to access external service.");
        }
    }
}