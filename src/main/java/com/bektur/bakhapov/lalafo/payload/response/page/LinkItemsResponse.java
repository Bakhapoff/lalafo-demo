package com.bektur.bakhapov.lalafo.payload.response.page;

public record LinkItemsResponse(
        LinkHrefResponse self,
        LinkHrefResponse next,
        LinkHrefResponse last
) {
}