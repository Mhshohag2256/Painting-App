package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.awt.CharsetString;
import javafx.scene.control.Slider;
import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller_Assignment5<add> {


    private enum PenSize {

        SMALL(2),
        MEDIUM(6),
        LARGE(10),
        XLARGE(14);

        final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }

    }

    private enum DrawColor {

        BLACK(Color.BLACK),
        RED(Color.RED),
        GREEN(Color.GREEN),
        BLUE(Color.BLUE),
        BROWN(Color.BROWN);

        final Color color;

        DrawColor(Color color) {
            this.color = color;
        }
    }

    private PenSize penSize = PenSize.MEDIUM;
    private DrawColor drawColor = DrawColor.BLACK;



    @FXML
    private RadioButton rbBlack;

    @FXML
    private ToggleGroup tgColor;

    @FXML
    private RadioButton rbGreen;

    @FXML
    private RadioButton rbRed;

    @FXML
    private RadioButton rbBlue;

    @FXML
    private RadioButton rbBrown;

    @FXML
    private RadioButton rbSmall;

    @FXML
    private ToggleGroup tgPenSize;

    @FXML
    private RadioButton rbMed;

    @FXML
    private RadioButton rbLarge;

    @FXML
    private RadioButton rbXLarge;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnSerialize;

    @FXML
    private Button btnClear;

    @FXML
    private Pane panelDraw;

    @FXML
    private Slider slider;




    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {

        panelDraw.getChildren().add(new Circle(event.getX(), event.getY(), penSize.radius, drawColor.color));
    }

    @FXML
    void colorChangeEventHandler(ActionEvent event) {
        if (rbBlack.isSelected())
            drawColor = DrawColor.BLACK;
        else if (rbGreen.isSelected())
            drawColor = DrawColor.GREEN;
        else if (rbRed.isSelected())
            drawColor = DrawColor.RED;
        else if(rbBlue.isSelected())
            drawColor = DrawColor.BLUE;
        else
            drawColor=DrawColor.BROWN;
    }
    ListA5Shape list=new ListA5Shape();

    public void serializeButtonEventHandler(ActionEvent actionEvent) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Select a XML File");
        File file=fileChooser.showOpenDialog(null);
        try(BufferedWriter output= Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())){
            Scanner input =new Scanner(System.in);
            while(input.hasNext()){
                try{
                    A5Shape shapes=new A5Shape(input.nextInt(),
                            input.nextInt(),
                            input.nextInt());

                    list.getShape().add(shapes);
                }
                catch(NoSuchElementException elementException){
                    System.out.println("Invalid input");
                    input.nextLine();
                }
            }
            JAXB.marshal(list,output);
        }
        catch (IOException ioException){
            System.out.println("Error opening file");
        }


    }
    @FXML
    void penSizeChangeEventHandler(ActionEvent event) {

        if (rbSmall.isSelected())
            penSize = PenSize.SMALL;
        else if (rbMed.isSelected())
            penSize = PenSize.MEDIUM;
        else if(rbLarge.isSelected())
            penSize = PenSize.LARGE;
        else
            penSize=PenSize.XLARGE;
    }

    @FXML
    void undoButtonEventHandler(ActionEvent event) {

        panelDraw.getChildren().remove(panelDraw.getChildren().size() - 1);
    }

    @FXML
    void clearButtonEventHandler(ActionEvent event) {

        panelDraw.getChildren().clear();
    }




    Label label=new Label(" ");
    @FXML
    void initialize() {

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                slider.setMin(0);
                slider.setMinorTickCount(3);
                slider.setMajorTickUnit(25);
                slider.setMax(255);

//                String style = String.format("-fx-background-color :  #FFFFFF %d%%, #0000FF%d%%",
//                        newValue.intValue(), newValue.intValue());
//                panelDraw.setStyle(style);
                panelDraw.setStyle("-fx-background: #90EE90; -fx-background: #90EE90;");


            }
        });


        assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgColor != null : "fx:id=\"tgColor\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBrown != null : "fx:id=\"rbBrown\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgPenSize != null : "fx:id=\"tgPenSize\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbMed != null : "fx:id=\"rbMed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbXLarge != null : "fx:id=\"rbXLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert panelDraw != null : "fx:id=\"panelDraw\" was not injected: check your FXML file 'Assignment5.fxml'.";
    }
}
