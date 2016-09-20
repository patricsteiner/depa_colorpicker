package depa_colorpicker;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

public class ColorPicker extends BorderPane {
	
	Slider[] sliders = new Slider[] { new Slider(), new Slider(), new Slider() };
	TextField[] textFields = new TextField[] { new TextField(), new TextField(), new TextField() };
	Label[] labels = new Label[] { new Label(), new Label(), new Label() };
	
	public ColorPicker() {
		setLeft(new VBox(sliders));
		setRight(new HBox(new VBox(textFields), new VBox(labels)));
		sliders[0].setStyle("-fx-background-color: red");
		sliders[1].setStyle("-fx-background-color: green");
		sliders[2].setStyle("-fx-background-color: blue");
		for (int i = 0; i < sliders.length; i++) {
			Bindings.bindBidirectional(textFields[i].textProperty(), sliders[i].valueProperty(), new NumberStringConverter());
			labels[i].textProperty().bind(sliders[i].valueProperty().asString());
			labels[i].setDisable(true);
			//sliders[i].valueProperty().addListener((prop, o, n) -> labels[i].setText(n.toString()));
		}
		
	}
}
