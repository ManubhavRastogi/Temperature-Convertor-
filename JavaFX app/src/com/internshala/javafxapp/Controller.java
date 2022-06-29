package com.internshala.javafxapp;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcome;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField userInputField;

    @FXML
    public Button convertButton;

    private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit to celsius";
    private boolean isC_TO_F;

    {
        isC_TO_F = true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);
        choiceBox.setValue(C_TO_F_TEXT);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(C_TO_F_TEXT)){// If the user has selected "celsius to Fahrenheit"
                isC_TO_F = true;
            }
            else {
                isC_TO_F = false;
            }
        });
        convertButton.setOnAction(event -> convert());
    }

    private void convert() {
        String input = userInputField.getText();
        float enteredTemperature;
        try {
            enteredTemperature = Float.parseFloat(input);
        }catch (Exception exception){
            warnuser();
            return;// no code is executed after this statement in this block after return
        }
        float newTemperature = 0.0f;

        if (isC_TO_F){
        newTemperature = (enteredTemperature * 9/5)+32;
        }
        else {
            newTemperature = (enteredTemperature - 32) * 5 / 9;
        }
        display(newTemperature);}

    private void warnuser() {
        Alert warning = new Alert(Alert.AlertType.WARNING);
        warning.setTitle("Error Occurred");
        warning.setContentText("You have entered an invalid value");
        warning.show();
    }

    private void display(float newTemperature){
        String unit = isC_TO_F? " F" : " C";
        System.out.println("The new temperature is : " + newTemperature + unit);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully executed");
        alert.setContentText("The new temperature is : "+ newTemperature + unit);
        alert.show();
    }
 }


