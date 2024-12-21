package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup toolToggleGroup;

    private boolean isDrawing = false; 
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double mouseX = event.getX(); 
        double mouseY = event.getY(); 

        double paneWidth = drawingAreaPane.getWidth(); 
        double paneHeight = drawingAreaPane.getHeight();  

        if (mouseX >= 0 && mouseX <= paneWidth && mouseY >= 0 && mouseY <= paneHeight) {
            if (penRadioButton.isSelected()) {
                Circle newCircle = new Circle(mouseX, mouseY, 4, Color.BLACK);
                drawingAreaPane.getChildren().add(newCircle);
            } else if (eraserRadioButton.isSelected()) {
                Circle newCircle = new Circle(mouseX, mouseY, 10, Color.WHITE);
                drawingAreaPane.getChildren().add(newCircle);
            }
        }
    }
    @FXML
    void penSelected(ActionEvent event) {
    	 isDrawing = true; 
    }
    @FXML
    void eraserSelected(ActionEvent event) {
    	 isDrawing = false;     
    }
}
