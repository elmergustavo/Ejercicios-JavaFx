/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Operar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author elmer
 */
public class EjemploControlador implements Initializable {

    @FXML
    private Button btnBoton;
    @FXML
    private TextField xtxOp1;
    @FXML
    private TextField xtxOp2;
    @FXML
    private TextField xtxResultado;
    @FXML
    private RadioButton rdbSuma;
    @FXML
    private RadioButton rdbResta;
    @FXML
    private RadioButton rdbMultiplicar;
    @FXML
    private RadioButton rdbDividir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        this.rdbSuma.setToggleGroup(tg);
        this.rdbResta.setToggleGroup(tg);
        this.rdbMultiplicar.setToggleGroup(tg);
        this.rdbDividir.setToggleGroup(tg);

    }

    @FXML
    private void Operar(ActionEvent event) {
        try {
            int op1 = Integer.parseInt(this.xtxOp1.getText());
            int op2 = Integer.parseInt(this.xtxOp2.getText());

            Operar s = new Operar(op1, op2);

            if (this.rdbSuma.isSelected()) {
                this.xtxResultado.setText(s.Suma() + "");

            } else if (this.rdbResta.isSelected()) {
                this.xtxResultado.setText(s.Resta() + "");
            } else if (this.rdbMultiplicar.isSelected()) {
                this.xtxResultado.setText(s.Multiplicar() + "");
            } else if (this.rdbDividir.isSelected()) {
                if (op2 == 0) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setHeaderText(null);
//                    alert.setTitle("Error");
//                    alert.setContentText("Formato Incorrecto");
//                    alert.showAndWait();
//                    
                    String tilte = "Operador Incorrecto";
                    String message = "Valor invalido";
                    TrayNotification tray = new TrayNotification();
                    AnimationType type = AnimationType.SLIDE;

                    tray.setAnimationType(type);
                    tray.setTitle(tilte);
                    tray.setMessage(message);
                    tray.setNotificationType(NotificationType.WARNING);
                    tray.showAndDismiss(Duration.millis(3000));
                } else {
                    this.xtxResultado.setText(s.Dividir() + "");
                }

            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato Incorrecto");
            alert.showAndWait();

        }
    }

}
