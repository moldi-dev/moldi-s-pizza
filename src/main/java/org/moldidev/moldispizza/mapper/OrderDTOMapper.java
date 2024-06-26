package org.moldidev.moldispizza.mapper;

import lombok.RequiredArgsConstructor;
import org.moldidev.moldispizza.dto.OrderDTO;
import org.moldidev.moldispizza.entity.Order;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDTOMapper implements Function<Order, OrderDTO> {

    private final UserDTOMapper userDTOMapper;
    private final PizzaDTOMapper pizzaDTOMapper;

    @Override
    public OrderDTO apply(Order order) {
        return new OrderDTO(
                order.getOrderId(),
                userDTOMapper.apply(order.getUser()),
                order.getPizzas()
                        .stream()
                        .map(pizzaDTOMapper::apply)
                        .collect(Collectors.toList()),
                order.getTotalPrice(),
                order.getCreatedDate(),
                order.getStatus()
        );
    }
}
