package com.example.model.command;

import com.example.model.data.dao.AdjustOrderContentsDao;
import com.example.model.data.dto.OrderItemDto;
import com.example.model.data.repository.OrderRepository;
import com.example.model.entity.Shoe;
import com.example.model.property.Quantity;
import com.example.model.service.Session;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;

public class AdjustOrderCommand implements Command {

	private final ListChangeListener.Change<? extends Shoe> orderChange;
	private final AdjustOrderContentsDao dao = new AdjustOrderContentsDao();
	private final OrderRepository orderRepository = new OrderRepository();
	private final Label errorDisplay;

	public AdjustOrderCommand(ListChangeListener.Change<? extends Shoe> orderChange, Label errorDisplay) {
		this.orderChange = orderChange;
		this.errorDisplay = errorDisplay;
	}

	@Override
	public Boolean task() {
		var orderNumber = Session.getSession().getCurrentOrderNumber();
		var orderId = orderRepository.find(order -> order.orderNumber().equals(orderNumber)).get().id();
		while (orderChange.next()) {
			for (Shoe removedShoe : orderChange.getRemoved()) {
				boolean removeWasSuccessful = dao.RemoveFromOrder(new OrderItemDto(new Quantity(1),removedShoe.id(),orderId));
				if (!removeWasSuccessful) errorDisplay.textProperty().set("Product could not be removed.");
			}
			for (Shoe addedShoe : orderChange.getAddedSubList()) {
				boolean addWasSuccessful = dao.AddToOrder(new OrderItemDto(new Quantity(1),addedShoe.id(),orderId));
				if (!addWasSuccessful) errorDisplay.textProperty().set("Product could not be added.");
			}
		}
		return false;
	}

}
