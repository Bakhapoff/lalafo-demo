package com.bektur.bakhapov.lalafo.payload.response.page;

public record PageMetaResponse(
        Long feed_id,
        Integer totalCount,
        Integer pageCount,
        Integer currentPage,
        Integer perPage,
        String feed
) {
}