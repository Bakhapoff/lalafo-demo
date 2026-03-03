package com.bektur.bakhapov.lalafo.payload.response.ad;

public record AdImageResponse(
        Long id,
        Boolean is_main,
        Integer width,
        Integer height,
        Boolean is_cv_image,
        String original_url,
        String thumbnail_url,
        String original_webp_url,
        String thumbnail_webp_url,
        String p_hash
) {
}