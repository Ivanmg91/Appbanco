package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuCrearCuentaController {

    @FXML
    private Button crearCuentaBoton;

    @FXML
    private TextField escribirNif;

    @FXML
    private TextField escribirNombreApellidos;

    @FXML
    private TextField escribriContrasena;

    @FXML
    private Button volverBoton;

    @FXML
    void CrearCuentaController(ActionEvent event) {

    }

    @FXML
    void EscribirContrasenaController(ActionEvent event) {

    }

    @FXML
    void EscribirNifController(ActionEvent event) {

    }

    @FXML
    void EscribirNombreApellidosController(ActionEvent event) {

    }

    @FXML
    void VolverBotonController(ActionEvent event) throws IOException {
        App.setRoot("menuinicio");
    }

}
