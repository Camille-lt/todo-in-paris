package com.example.demo.service;

import com.example.demo.model.Event;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParisOpenDataService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    private static final String PARIS_API_URL = "https://opendata.paris.fr/api/explore/v2.1/catalog/datasets/que-faire-a-paris-/records?limit=20";

    public ParisOpenDataService() {
        this.restClient = RestClient.create();
        this.objectMapper = new ObjectMapper();
    }

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();

        try {
            String jsonResponse = restClient.get()
                    .uri(PARIS_API_URL)
                    .retrieve()
                    .body(String.class);

            if (jsonResponse != null) {
                JsonNode rootNode = objectMapper.readTree(jsonResponse);
                if (rootNode.has("results")) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }
}