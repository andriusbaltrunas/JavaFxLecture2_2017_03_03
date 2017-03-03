package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private TextField currentGuess;
    @FXML
    private Label isvedimas;

    public void takeGuess(ActionEvent event){
        Random random = new Random();
        int generatedNumber = random.nextInt(10) + 1;
        try {


            int cg = Integer.parseInt(currentGuess.getText());
            Alert.AlertType alert = Alert.AlertType.INFORMATION;


            String ats = "Atspejai " + generatedNumber;

            if (cg != generatedNumber) {
                ats = "neatspejai " + generatedNumber;
                alert = Alert.AlertType.WARNING;
            }
            isvedimas.setText(ats);
            alert(alert, ats);
        }
        catch (NumberFormatException e){
            alert(Alert.AlertType.ERROR, "Iveskite skaiciu!!!");
        }
        currentGuess.setText("");

    }
    private void alert(Alert.AlertType type, String text){
        Alert alert=new Alert(type);
        alert.setContentText(text);
        alert.show();
    }
}
