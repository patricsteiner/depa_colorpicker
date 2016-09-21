package depa_colorpicker;



import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class ColorPicker extends BorderPane {
	
	Slider[] sliders = new Slider[] { new Slider(), new Slider(), new Slider() };
	TextField[] textFields = new TextField[] { new TextField(), new TextField(), new TextField() };
	Label[] labels = new Label[] { new Label(), new Label(), new Label() };
	Rectangle rect = new Rectangle(100,100);
	
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
			sliders[i].valueProperty().addListener((prop, o, n) -> rect.setFill(Color.rgb(n.intValue(), n.intValue(), n.intValue())));
			//sliders[i].valueProperty().addListener((prop, o, n) -> labels[i].setText(n.toString()));
		}
		
		setBottom(rect);
		
	}
}
