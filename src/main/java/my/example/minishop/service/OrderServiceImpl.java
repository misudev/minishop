package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.Order;
import my.example.minishop.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.getOrdersByUserId(userId);
    }
}
