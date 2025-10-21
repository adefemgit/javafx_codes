package org.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Calculate calc = new Calculate();
    TextField display;

    @Override
    public void start(Stage stage) throws IOException {



        display = new TextField("0");
        display.setEditable(false);
        display.setPromptText("0");
        display.setMaxWidth(200);
        display.setMaxHeight(40);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 20px; -fx-border-width: 2;  ");


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);


        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", "C", "=", "+"}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                final String value = buttons[row][col];
                Button button = new Button(value);

                button.setOnAction(event -> {buttonClicked(value);});
                grid.add(button, col, row);

            }
        }


        VBox root = new VBox(10, display, grid);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void buttonClicked(String value) {

        if ("0123456789".contains(value)) {

            if (display.getText().equals("0")) {
                display.setText(value);
            } else {
                display.setText(display.getText() + value);
            }
        } else if ("+-*/".contains(value)) {

            calc.setNum1(Double.parseDouble(display.getText()));
            calc.setOperator(value);
            display.setText("0");

        } else if (value.equals("=")) {

            double num2 = Double.parseDouble(display.getText());
            double result = calc.Calc(num2);
            display.setText(String.valueOf(result));

        } else if (value.equals("C")) {

            display.setText("0");
            calc.clear();
        }
    }


}
