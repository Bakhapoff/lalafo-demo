package com.bektur.bakhapov.lalafo.controller;

import com.bektur.bakhapov.lalafo.payload.response.ad.AdsPageResponse;
import com.bektur.bakhapov.lalafo.service.LalafoApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test-result")
public class LalafoController {

    private final LalafoApiService lalafoApiService;

    public LalafoController(LalafoApiService lalafoApiService) {
        this.lalafoApiService = lalafoApiService;
    }

    @GetMapping
    public String fetchAds(@RequestParam(defaultValue = "1") Integer page, Model model) {
        AdsPageResponse response = lalafoApiService.fetchAds(page);
        model.addAttribute("ads", response.items());
        model.addAttribute("currentPage", page);
        return "ads";
    }
}