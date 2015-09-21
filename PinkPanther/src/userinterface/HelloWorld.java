package userinterface;

import java.io.File;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) {
    	fillPage ("Add <EventName> || Delete <EventIndex> || ");
    }
    
    void fillPage(String newInput){
    	Stage primaryStage = new Stage();
    	
    	ScrollPane sp = new ScrollPane();
    	sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    	sp.setStyle("-fx-background: rgba(0,0,0,0);");
    	
        primaryStage.setTitle("PinkPanther: The best to-do list");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        sp.setContent(grid);
        
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.TOP_LEFT);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        sp.setContent(grid);
        
        grid2.add(sp,0,0);
        
        //Input command text label and box
        int currentYPos = 1;
  //      Label command = new Label("Input Command:");
   //     grid.add(command, 0, commandBoxYPos);
        TextField userTextField = new TextField("Input Command");
        userTextField.setMinHeight(50);
        userTextField.setMinWidth(1000);
        userTextField.setStyle(""
        + "-fx-font-size: 30px;"
        + "-fx-font-weight: bold;"
        + "-fx-font-family: Tahoma;"
        + "-fx-text-fill: DIMGRAY;"
        + "-fx-background-color: PINK");
        grid2.add(userTextField, 0, 1);
        
        //text that displays after-action (e.g added x event)
        final Text actiontarget = new Text(newInput);
        grid2.add(actiontarget, 0, 2);
        actiontarget.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        actiontarget.setFill(Color.WHITE);      
        
        //add button
        Button btn = new Button("Enter");
        btn.getStyleClass().add("button1");
        Button scrollUpButton = new Button("Scroll Up");
        scrollUpButton.getStyleClass().add("button1");
        Button scrollDownButton = new Button("Scroll Down");
        scrollDownButton.getStyleClass().add("button1");
    //    btn.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.TOP_RIGHT);
        hbBtn.getChildren().addAll(btn, scrollUpButton, scrollDownButton);
        grid2.add(hbBtn, 0, 2);
            
        
        //Scene title
        Text scenetitle = new Text("PinkPanther Calendar");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        scenetitle.setFill(Color.DIMGRAY);
        grid.add(scenetitle, 1, 0);

        
        
        Scene scene = new Scene(grid2, 1080, 900);

        
        //for the actual calendar items
        TextedColorDayBox daydBox = new TextedColorDayBox("Float");
    	grid.add(daydBox, 0, currentYPos++);
        
    	
        for (int i=5; i<20; i++){
        	Random ran = new Random();
        	int randomNumTasks = ran.nextInt(5);
        	if (randomNumTasks!=0){
        	TextedColorDayBox dayBox = new TextedColorDayBox("Day\n"+ i);
        	grid.add(dayBox, 0, currentYPos);


    			int currentXPos = 1;
	        	for (int j=0; j<randomNumTasks; j++){
	        		if(j==2){
	        			currentYPos++;
	    	        	currentXPos = 1;
	        		}
	        		TextedTaskBox taskBox = new TextedTaskBox("Meetin with boss at meeting roomdddddd" , "08:00pm", "09:00pm");
	        		grid.add(taskBox, currentXPos++, currentYPos);
	            }
	        	currentYPos++;
        	}
        	
        }
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
       	 
        	@Override
            public void handle(ActionEvent e) {
                if ((userTextField.getText() != null && !userTextField.getText().isEmpty())) {
                    actiontarget.setFill(Color.WHITE);                	
                	actiontarget.setText(userTextField.getText());
                	
                } else {
                    actiontarget.setFill(Color.WHITE);
                    actiontarget.setText("No input detected!");
                }
             }
         });

        scrollUpButton.setOnAction(new EventHandler<ActionEvent>() {
       	 
        	@Override
            public void handle(ActionEvent e) {
        		sp.setVvalue(sp.getVvalue() - 0.1);
        		System.out.println(sp.getVvalue());
             }
         });
        
        scrollDownButton.setOnAction(new EventHandler<ActionEvent>() {
          	 
        	@Override
            public void handle(ActionEvent e) {
        		sp.setVvalue(sp.getVvalue() + 0.1);
        		System.out.println(sp.getVvalue());

            	grid2.getChildren().clear();
             }
         });
        
        userTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode().equals(KeyCode.ENTER))
                {
                	if ((userTextField.getText() != null && !userTextField.getText().isEmpty())) {
                        actiontarget.setFill(Color.BLUE);                	
                    	actiontarget.setText(userTextField.getText());
                    	fillPage(userTextField.getText());
                    	primaryStage.close();
                    	
                    } else {
                        actiontarget.setFill(Color.FIREBRICK);
                        actiontarget.setText("No input detected!");
                    };
                }
                
                else if (ke.getCode().equals(KeyCode.DOWN))
                {
                	sp.setVvalue(sp.getVvalue() + 0.2f);
                }
                else if (ke.getCode().equals(KeyCode.UP))
                {
                	sp.setVvalue(sp.getVvalue() - 0.2f);
                }
            }
        });
        
        
        
       
        primaryStage.setScene(scene);

        scene.setFill(Color.RED);
    //    String css = this.getClass().getResource("a.css").toExternalForm();
        scene.getStylesheets().clear();
     //   scene.getStylesheets().add("/resources/css/yourStyle.css");
     //   System.out.println(scene.getStylesheets().toString());
       scene.getStylesheets().add(HelloWorld.class.getResource("a.css").toExternalForm());
     //   scene.getStylesheets().add("a.css");
        

        
       primaryStage.show();
        
    }
}



