package com.example.model.command;

import com.example.model.data.dao.AdjustOrderContentsDao;
import com.example.model.data.dto.OrderItemDto;
import com.example.model.data.repository.OrderRepository;
import com.example.model.entity.Shoe;
import com.example.model.property.Quantity;
import com.example.model.service.Session;
import javafx.collections.ListChangeListener;

public class AdjustOrderCommand implements Command {

	private final ListChangeListener.Change<? extends Shoe> orderChange;
	private final AdjustOrderContentsDao dao = new AdjustOrderContentsDao();
	private final OrderRepository orderRepository = new OrderRepository();

	public AdjustOrderCommand(ListChangeListener.Change<? extends Shoe> orderChange) {
		this.orderChange = orderChange;
	}

	@Override
	public Boolean task() {
		var orderNumber = Session.getSession().getCurrentOrderNumber();
		var orderId = orderRepository.find(order -> order.orderNumber().equals(orderNumber)).get().id();
		while (orderChange.next()) {
			for (Shoe removedShoe : orderChange.getRemoved()) {
				dao.RemoveFromOrder(new OrderItemDto(new Quantity(1),removedShoe.id(),orderId));
			}
			for (Shoe addedShoe : orderChange.getAddedSubList()) {
				dao.AddToOrder(new OrderItemDto(new Quantity(1),addedShoe.id(),orderId));
			}
		}
		return false;
	}

}
