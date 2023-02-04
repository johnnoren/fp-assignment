package com.example.model.command;

import com.example.model.data.repository.OrderRepository;
import com.example.model.entity.Shoe;
import com.example.model.service.Session;
import javafx.collections.ListChangeListener;

public class AdjustOrderCommand implements Command {

	private final ListChangeListener.Change<? extends Shoe> orderChange;
	private final OrderRepository orderRepository = new OrderRepository();

	public AdjustOrderCommand(ListChangeListener.Change<? extends Shoe> orderChange) {
		this.orderChange = orderChange;
	}

	@Override
	public Boolean task() {
		var orderNumber = Session.getSession().getCurrentOrderNumber();
		while (orderChange.next()) {
			for (Shoe removed : orderChange.getRemoved()) {
				// TODO

				//
			}
			for (Shoe added : orderChange.getAddedSubList()) {
				additem.add(Outer.this);
			}
		}
	}

}
