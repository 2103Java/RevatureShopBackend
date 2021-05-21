package com.revature.shop.controllers;

import com.revature.shop.models.StockItem;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class e2eInventoryTesting
{

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void viewItemsE2E()
    {
        URI uri = URI.create("http://localhost:8088/api/inventory/view");
        ResponseEntity<List> stockItemsList = restTemplate.getForEntity(uri, List.class);
        stockItemsList.getStatusCode();
        stockItemsList.getBody();
    }

    @Test
    public void addItemE2E()
    {
        StockItem item = new StockItem("Revature Watches", 70, 90);
        URI uri = URI.create("http://localhost:8088/api/inventory/stockitem/new");
        restTemplate.put(uri, item);
//        stockItemsList.getStatusCode();
//        stockItemsList.getBody();
    }

    @Test
    public void updateQuantitiesE2E()
    {
        StockItem item = new StockItem("Rev It Up Hat", 50, 3500);
        URI uri = URI.create("http://localhost:8088/api/inventory/stockitem/update");
        restTemplate.put(uri, item);
//        stockItemsList.getStatusCode();
//        stockItemsList.getBody();
    }

}
