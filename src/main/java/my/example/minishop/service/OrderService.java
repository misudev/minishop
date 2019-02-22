package my.example.minishop.service;

import my.example.minishop.domain.Order;

import java.util.List;

public interface OrderService {
    public Order addOrder(Order order);
    public List<Order> getOrdersByUserId(Long userId);
}
