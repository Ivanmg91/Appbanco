package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuCrearCuentaController {

    @FXML
    private Button crearCuentaBoton;

    @FXML
    private TextField escribirNif;

    @FXML
    private TextField escribirApellidos;

    @FXML
    private TextField escribirNombre;

    @FXML
    private TextField escribriContrasena;

    @FXML
    private Button volverBoton;

    /*
     * Funcion para comprobar q todos los campos estan rellenados
     * REVISAR LOS CASOS POSIBLES
     */
    protected Boolean compruebaCampos() {
        if (escribirNif.getText().equals("") || escribriContrasena.getText().equals("") || escribirNombre.getText().equals("") || escribirApellidos.getText().equals("")) {
            return false; // Falso si hay campos vacios
        } else {
            return true; // Verdadero si todos los campos estan rellenados
        }
    }

    @FXML
    void CrearCuentaController(ActionEvent event) throws IOException {

        //Hacer insert a la tabla de clientes
        String Sql = "INSERT INTO clientes (NIF, contrasena, nombre, apellidos, rol) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = null;

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33006/appbanco", "root",
                    "dbrootpass");
            Cliente cliente = new Cliente(escribirNif.getText(), escribriContrasena.getText(), escribirNombre.getText(),
                    escribirApellidos.getText());

            if (cliente.validaNIF() == true && compruebaCampos() == true){
                st = conexion.prepareStatement(Sql);
                st.setString(1, cliente.getNif());
                st.setString(2, cliente.getcontrasena());
                st.setString(3, cliente.getNombre());
                st.setString(4, cliente.getApellidos());
                st.setString(5, "cliente");
                st.executeUpdate();

                //Alerta de que se ha añadido correctamente si estan los campos completos

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cliente añadido correctamente");
                alert.setContentText("Cliente añadido correctamente");
                alert.showAndWait();

                System.out.println("Empleado agregado correctamente");
                App.setRoot("menuinicio");

            } else if (cliente.validaNIF() == false){ //Alerta NIF invalido
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("NIF no valido\nComprueba que tiene los 8 números y la letra correspondiente");
                alert.showAndWait();

            } else if (compruebaCampos() == false) { //Alerta algun campo vacio
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Aún tienes campos sin rellenar");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void EscribirContrasenaController(ActionEvent event) {

    }

    @FXML
    void EscribirNifController(ActionEvent event) {

    }

    @FXML
    void EscribirApellidosController(ActionEvent event) {

    }

    @FXML
    void EscribirNombreController(ActionEvent event) {

    }

    @FXML
    void VolverBotonController(ActionEvent event) throws IOException {
        App.setRoot("menuinicio");
    }

}
