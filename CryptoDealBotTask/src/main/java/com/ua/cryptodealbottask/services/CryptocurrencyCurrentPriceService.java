package com.ua.cryptodealbottask.services;

import com.fasterxml.jackson.databind.*;

import com.ua.cryptodealbottask.utils.JacksonAndObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

@Service
public class CryptocurrencyCurrentPriceService {

    public String getCryptocurrencyCurrentPrice(URL binanceUrlToBTCUSDTJsonObject) throws IOException {
        JsonNode json = JacksonAndObjectMapper.get(binanceUrlToBTCUSDTJsonObject);
        return "markPrice = " + json.get("markPrice");
    }

}
