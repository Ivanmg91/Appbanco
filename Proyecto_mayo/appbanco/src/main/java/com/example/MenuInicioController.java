package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuInicioController {

    @FXML
    private Button crearCuentaBoton;

    @FXML
    private PasswordField escribirContrasena;

    @FXML
    private TextField escribirContrasenaText;

    @FXML
    private TextField escribirNif;

    @FXML
    private Button iniciarSesionBoton;

    @FXML
    private ImageView imagen;

    @FXML
    private Button verContrasenaBoton;

    @FXML
    private ImageView imagenVerContrasena;

    @FXML
    private Button githubBoton;

    @FXML
    private ImageView imagenGithubLogo;

    @FXML
    void CrearCuentaController(ActionEvent event) throws IOException {
        App.setRoot("menucrearcuenta");
    }

    

    @FXML
    void EscribirNifController(ActionEvent event) {

    }

    @FXML
    void EscribirContrasenaTextController(ActionEvent event) {

    }

    @FXML
    void VerContrasenaBotonController(ActionEvent event) {
        //Hacer q las letras cambien por asteriscos para que se vea o no se vea la contraseña
        boolean visible = escribirContrasena.isVisible();
        escribirContrasena.setVisible(!visible);
        escribirContrasenaText.setVisible(visible);
        
    }

    @FXML
    void IniciarSesionController(ActionEvent event) throws IOException {
        String nif = escribirNif.getText();

        String contrasena = escribirContrasena.getText();
        
        /*
         * Comprobar el inicio de sesion y si coincide con la base de datos acceder
         */
        if (nif_contrasenas.containsKey(nif)) { //Si el NIF existe

            System.out.println("Inicio de sesión correcto");
            if (nif_contrasenas.get(nif).equals(contrasena)) { //Si el la contraseña coincide con el nif
                App.setRoot("menuoperaciones");

            } else if (!nif_contrasenas.get(nif).equals(contrasena) && !contrasena.equals("")) { //Si la contraseña no coincide
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Contraseña incorrecta");
                alert.showAndWait();
            } else if (!nif_contrasenas.get(nif).equals(contrasena) && contrasena.equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Debes introducir la contraseña");
                alert.showAndWait();
            }
            
        } else if (!nif_contrasenas.containsKey(nif) && !nif.equals("")) { //Si el NIF introducido no existe
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("NIF inexistente");
            alert.showAndWait();

        } else if (nif.equals("") && !contrasena.equals("")) { //Si no se ha introducido un NIF
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Debes introducir un NIF");
            alert.showAndWait();

        } else if (contrasena.equals("") && !nif.equals("")) { //Si no se ha introducido una contraseña
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Debes introducir la contraseña");
            alert.showAndWait();

        } else if (nif.equals("") && contrasena.equals("")) { //Si no se ha introducido nada en ningun campo
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Debes completar los campos para iniciar sesión");
            alert.showAndWait();
        }
    }

    @FXML
    void GithubBotonController(ActionEvent event) {
        String url = "https://github.com/Ivanmg91/Carpeta_programacion/tree/main/JavaFX/Proyecto_mayo";
        try {
            new ProcessBuilder("x-www-browser", url).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();

    TreeMap<String, String> nif_contrasenas = new TreeMap<>(); //Treemap de cada NIF y su contraseña
    /*TreeMap<String, String> nif_clientes = new TreeMap<>(); //Para los nombres
    TreeMap<String, String> nif_apellidos = new TreeMap<>(); //Para los clientes
    TreeMap<String, Double> nif_facturas = new TreeMap<>(); //Para las facturas*/


    @FXML
    void initialize() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33006/appbanco", "root", "dbrootpass");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes");

            while (rs.next()) { // Añadir todos los clientes a un arraylist
                Cliente cliente =new Cliente(rs.getString("NIF"), rs.getString("contrasena"), rs.getString("nombre"), rs.getString("apellidos"));
                lista_clientes.add(cliente);

                nif_contrasenas.put(rs.getString("NIF"), rs.getString("contrasena")); // Añadir todos los NIF y contraseñas a un TreeMap
                /*nif_clientes.put(rs.getString("NIF"), rs.getString("nombre")); // Añadir todos los NIF y clientes a un TreeMap
                nif_apellidos.put(rs.getString("NIF"), rs.getString("apellidos")); // Añadir todos los NIF y apellidos a un TreeMap*/
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Image logo = new Image("file:/home/dam/Escritorio/Ivanmg/Carpeta_programacion/JavaFX/Proyecto_mayo/appbanco/src/main/resources/imagenes/tarjeta-removebg-preview.png"); // Reemplaza con la ruta de tu imagen
        imagen.setImage(logo); //CAMBIAR LOGO

        Image image = new Image("file:/home/dam/Escritorio/Ivanmg/Carpeta_programacion/JavaFX/Proyecto_mayo/appbanco/src/main/resources/imagenes/ojosintachar-removebg-preview.png"); // Reemplaza con la ruta de tu imagen
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20); // ancho
        imageView.setFitHeight(20); // Alto
        verContrasenaBoton.setGraphic(imageView);

        //Mostrara al iniciar el textfield y no el passwordfield
        escribirContrasenaText.setVisible(false);
        escribirContrasena.setVisible(true);
        escribirContrasena.textProperty().bindBidirectional(escribirContrasenaText.textProperty());

    }

}
