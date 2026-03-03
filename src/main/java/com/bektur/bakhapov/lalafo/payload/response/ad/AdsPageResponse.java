package com.bektur.bakhapov.lalafo.payload.response.ad;

import com.bektur.bakhapov.lalafo.payload.response.page.PageMetaResponse;
import com.bektur.bakhapov.lalafo.payload.response.page.LinkItemsResponse;

import java.util.List;

public record AdsPageResponse(
        List<AdResponse> items,
        LinkItemsResponse _links,
        PageMetaResponse _meta
) {
}