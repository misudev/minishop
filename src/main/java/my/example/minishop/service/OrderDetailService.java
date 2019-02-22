package my.example.minishop.service;

import my.example.minishop.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public OrderDetail addOrderDetail(OrderDetail orderDetail);
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
}
