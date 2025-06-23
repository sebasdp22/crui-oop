package com.pedidosya;

import java.util.List;
import java.util.stream.Collectors;

import com.pedidosya.controllers.RestaurantCatalogController;
import com.pedidosya.models.Customer;
import com.pedidosya.models.Driver;
import com.pedidosya.models.Order;
import com.pedidosya.models.OrderUpdate;
import com.pedidosya.models.Product;
import com.pedidosya.models.Restaurant;
import com.pedidosya.views.CustomerApp;
import com.pedidosya.views.DriverApp;
import com.pedidosya.views.RestaurantApp;

public class PedidosYaFlow {
  public static void main(String[] args) {

    // Creamos las instancias necesarias, y instanciamos las vistas y los controladores

    Customer juanPerez =
        new Customer(
            "1",
            "Juan Perez",
            "juan.perez@example.com",
            "1234567890",
            "Ratti 200, Ituzaingo, Buenos Aires, Argentina");
    Driver juanLopez =
        new Driver(
            "1",
            "Juan Lopez",
            "juan.perez@example.com",
            "1234567890",
            "Ratti 200, Ituzaingo, Buenos Aires, Argentina",
            true);

    RestaurantCatalogController restaurantCatalogController = new RestaurantCatalogController();

    CustomerApp customerApp = new CustomerApp(restaurantCatalogController);
    DriverApp driverApp = new DriverApp();

    // Busco restaurantes
    List<Restaurant> pizzaRestaurants = restaurantCatalogController.searchRestaurants("pizza");
    // Seleccionar uno
    Restaurant oneRestaurant = pizzaRestaurants.get(0);
    RestaurantApp restaurantApp = new RestaurantApp(oneRestaurant);

    customerApp.login(juanPerez);
    driverApp.login(juanLopez);

    // El cliente escribe pizza en la caja de busqueda
    List<Restaurant> restaurants = customerApp.searchRestaurants("pizza");
    // El cliente selecciona el primer restaurante
    Restaurant selectedRestaurant = restaurants.get(0);
    List<Product> products = customerApp.selectRestaurant(selectedRestaurant);

    // El cliente crea un pedido
    Order order = customerApp.createOrderWithProducts(products);

    // El restaurante acepta el pedido
    restaurantApp.acceptOrder(order);

    driverApp.offerOrderToDriver(order);

    driverApp.acceptOrder();

    restaurantApp.startPreparation(order);

    restaurantApp.finishPreparation(order);

    driverApp.startDelivery();

    driverApp.finishDelivery();

    System.out.println("Order status: " + order.getStatus());
    System.out.println(
        "Order updates: "
            + order.getUpdates().stream()
                .map(OrderUpdate::toString)
                .collect(Collectors.joining("\n")));
  }
}
