package com.example.demo.service;

import com.example.demo.model.Event;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParisOpenDataService {

    private final RestClient restClient;
    private static final String PARIS_API_URL = "https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/que-faire-a-paris-/records?limit=30";

    public ParisOpenDataService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public List getEvents() {
        JsonNode rootNode = restClient.get()
                .uri(PARIS_API_URL)
                .retrieve()
                .body(JsonNode.class);

        List events = new ArrayList<>();

        if (rootNode != null && rootNode.has("results")) {
            for (JsonNode record : rootNode.get("results")) {
                events.add(new Event(
                        record.path("id").asText(""),
                        record.path("title").asText(""),
                        record.path("lead_text").asText(""),
                        record.path("description").asText(""),
                        record.path("cover_url").asText(""),
                        record.path("date_start").asText(""),
                        record.path("date_end").asText(""),
                        record.path("address_name").asText(""),
                        record.path("address_street").asText(""),
                        record.path("address_city").asText(""),
                        record.path("price_type").asText("")
                ));
            }
        }

        return events;
    }
}