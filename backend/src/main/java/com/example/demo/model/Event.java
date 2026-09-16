package com.example.demo.model;

public record Event(
    String id,
    String title,
    String leadText,
    String description,
    String coverUrl,
    String dateStart,
    String dateEnd,
    String addressName,
    String addressStreet,
    String addressCity,
    String priceType
) {}