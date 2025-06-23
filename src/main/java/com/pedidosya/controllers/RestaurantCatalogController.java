package com.pedidosya.controllers;

import java.util.List;

import com.pedidosya.models.Restaurant;
import com.pedidosya.repositories.RestaurantRepo;

public class RestaurantCatalogController {
  RestaurantRepo repo;

  public RestaurantCatalogController() {
    this.repo = new RestaurantRepo();
  }

  public List<Restaurant> searchRestaurants(String query) {
    // parseo de input
    return this.repo.searchRestaurants(query);
  }
}
