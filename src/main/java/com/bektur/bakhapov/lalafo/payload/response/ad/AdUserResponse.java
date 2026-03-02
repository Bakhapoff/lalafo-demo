package com.bektur.bakhapov.lalafo.payload.response.ad;

public record AdUserResponse(
        Long id,
        String avatar,
        Boolean pro,
        Integer response_rate,
        String public_url,
        Boolean is_deleted,
        String user_hash,
        Boolean hidden_delete,
        String company_name,
        String logo,
        Integer response_time,
        Boolean is_banned,
        String username,
        String response_info
) {
}