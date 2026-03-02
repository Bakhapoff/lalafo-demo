package com.bektur.bakhapov.lalafo.controller;

import com.bektur.bakhapov.lalafo.payload.response.ad.AdsPageResponse;
import com.bektur.bakhapov.lalafo.service.LalafoApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-result")
public class LalafoController {

    private final LalafoApiService lalafoApiService;

    public LalafoController(LalafoApiService lalafoApiService) {
        this.lalafoApiService = lalafoApiService;
    }

    @GetMapping
    public ResponseEntity<AdsPageResponse> fetchAds() {
        try {
            AdsPageResponse response = lalafoApiService.fetchAds();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}