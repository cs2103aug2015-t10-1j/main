package userinterface;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextedTaskBox extends StackPane{
	public TextedTaskBox(String name, String startTime, String endTime){
		ColoredTextBox box = new ColoredTextBox();
		
		
		GridPane grid = new GridPane();
	//	grid.setGridLinesVisible(true);
	    grid.setPadding(new Insets(5));
	    grid.setHgap(5);
	    grid.setVgap(5);

	    ColumnConstraints column1 = new ColumnConstraints(5);
	    ColumnConstraints column2 = new ColumnConstraints(50, 150, 100);
	    grid.getColumnConstraints().addAll(column1, column2);
		
		Text text = new Text(name);
		text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		text.setTextAlignment(TextAlignment.LEFT);
		text.setFill(Color.DIMGRAY);

		GridPane.setConstraints(text, 0, 2);
		grid.add(text, 0, 2);
		
		if (!startTime.equals("")){
			TextedTimeBox startTimeBox = new TextedTimeBox(startTime);
			GridPane.setConstraints(startTimeBox , 0, 3);

			grid.add(startTimeBox, 0, 3);
		}
		
		if (!endTime.equals("")){
			TextedTimeBox timeBox = new TextedTimeBox(endTime);
	
			GridPane.setConstraints(timeBox , 5, 3);
			grid.add(timeBox, 5, 3);
		}
		this.getChildren().addAll(box, grid);
		
	}
}