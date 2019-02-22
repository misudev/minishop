package my.example.minishop.service;

import lombok.RequiredArgsConstructor;
import my.example.minishop.domain.OrderDetail;
import my.example.minishop.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    @Override
    @Transactional
    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailRepository.getOrderDetailsByOrderId(orderId);
    }
}
