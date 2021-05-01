package com.example.crypto.rest.request;

import com.example.crypto.domain.model.Coin;
import com.example.crypto.rest.resources.CoinDto;
import com.example.crypto.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpUrlConnection {
    private final URL url = new URL("https://api.coinranking.com/v2/coins");

    @Autowired
    private CoinService service;

    public HttpUrlConnection() throws MalformedURLException {
    }


    public void init() throws IOException, ParseException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();
        if (status != 200) return;
        readResponse(con);
        con.disconnect();
    }

    private void readResponse(HttpURLConnection con) throws IOException, ParseException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        parseJson(content.toString());
        in.close();
    }

    private void parseJson(String result) throws ParseException, JsonProcessingException {
        JSONParser parser = new JSONParser();

            Object obj = parser.parse(result);

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray coinList = (JSONArray) ((JSONObject) jsonObject.get("data")).get("coins");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            for (Object next : coinList) {
                CoinDto coin = mapper.readValue(next.toString(), CoinDto.class);
                Coin updated = service.processCoin(coin);
            }
    }
}
