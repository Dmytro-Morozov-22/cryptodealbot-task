package com.ua.cryptodealbottask.controllers;

import com.ua.cryptodealbottask.services.CryptocurrencyCurrentPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@RestController
@RequestMapping("/api/v1/current-price")
public class CryptocurrencyCurrentPriceController {

    public final CryptocurrencyCurrentPriceService cryptocurrencyCurrentPriceService;

    @Autowired
    public CryptocurrencyCurrentPriceController(CryptocurrencyCurrentPriceService cryptocurrencyCurrentPriceService) {
        this.cryptocurrencyCurrentPriceService = cryptocurrencyCurrentPriceService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCurrentPrice() throws IOException, URISyntaxException {
        URL binanceUrlToBTCUSDTJsonObject  = new URI(
                "https://fapi.binance.com/fapi/v1/premiumIndex?symbol=BTCUSDT").toURL();

        return new ResponseEntity<>(
                cryptocurrencyCurrentPriceService.getCryptocurrencyCurrentPrice(binanceUrlToBTCUSDTJsonObject),
                HttpStatus.OK);
    }



}
