package com.example.model.javafxextension;

import com.example.model.entity.Shoe;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ShoeCellFactory implements Callback<ListView<Shoe>, ListCell<Shoe>> {

		@Override
		public ListCell<Shoe> call(ListView<Shoe> param) {
			return new ListCell<>(){
				@Override
				public void updateItem(Shoe shoe, boolean empty) {
					super.updateItem(shoe, empty);
					if (empty) {
						setText(null);
						setGraphic(null);
					} else if (shoe != null) {
						setText(null);
						setGraphic(new CheckBox("ksdhfdkshfjsh"));
					} else {
						setText("null");
						setGraphic(null);
					}
				}
			};
		}

}
