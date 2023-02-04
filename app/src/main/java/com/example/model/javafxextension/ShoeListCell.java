package com.example.model.javafxextension;

import com.example.model.entity.Shoe;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ShoeListCell extends ListCell<Shoe> {

		private final HBox content;
		private final Text brand = new Text();
		private final Text model = new Text();
		private final Text style = new Text();
		private final Text size = new Text();
		private final Text price = new Text();

		public ShoeListCell() {
			super();
			VBox vBox = new VBox(brand, model, style, size, price);
			content = new HBox(new Label("[Graphic]"), vBox);
			content.setSpacing(10);
		}

		@Override
		protected void updateItem(Shoe shoe, boolean empty) {
			super.updateItem(shoe, empty);
			if (shoe != null && !empty) { // <== test for null item and empty parameter
				brand.setText(shoe.style().model().brand().name().value());
				model.setText(shoe.style().model().modelName().value());
				style.setText(shoe.style().styleName().value());
				size.setText(shoe.size().europeanSize().value().toString());
				price.setText(String.format("%d $", shoe.price().amount()));
				setGraphic(content);
			} else {
				setGraphic(null);
			}
		}


}
