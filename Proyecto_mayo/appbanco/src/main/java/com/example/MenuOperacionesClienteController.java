package com.example;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MenuOperacionesClienteController extends MenuInicioController{

    @FXML
    private Button ajustes;

    @FXML
    private Button cerrarSesion;

    @FXML
    private Button facturasBoton;

    @FXML
    private TableView<?> tablaTransferencias;

    @FXML
    private Button tarjetasBoton;

    @FXML
    private Button transferenciaBoton;

    @FXML
    private ImageView imagenSalir;

    @FXML
    private AnchorPane panelLateral;

    @FXML
    private AnchorPane fondo;

    @FXML
    private Button cerrarLateral;

    @FXML
    private Text textoNombre;

    @FXML
    private Button modoOscuro;

    @FXML
    private ImageView imagenModoOscuro;

    @FXML
    private Button misDatos;

    @FXML
    private Button notificaciones;

    @FXML
    private Button acercaDe;

    @FXML
    void CerrarSesionController(ActionEvent event) throws IOException {
        clienteOperando = null;
        App.setRoot("menuinicio");
    }

    @FXML
    void FacturasBotonController(ActionEvent event) {

    }

    @FXML
    void TablaTransferenciasController(ActionEvent event) {

    }

    @FXML
    void TarjetasBotonController(ActionEvent event) {

    }

    @FXML
    void TransferenciaBotonController(ActionEvent event) {

    }

    @FXML
    void ajustesController(ActionEvent event) throws InterruptedException {

        //Mostrar panel lateral
        panelLateral.setVisible(true);

        TranslateTransition transicion = new TranslateTransition();
        transicion.setDuration(Duration.seconds(1));
        transicion.setNode(panelLateral);
        transicion.setByX(-200);

        transicion.play();

        //Inhabilitar todos los botones
        cerrarSesion.setDisable(true);
        facturasBoton.setDisable(true);
        transferenciaBoton.setDisable(true);
        tarjetasBoton.setDisable(true);
        tablaTransferencias.setDisable(true);
        
        
    }

    @FXML
    void CerrarLateralController(ActionEvent event) throws InterruptedException {
        TranslateTransition transicion = new TranslateTransition();
        transicion.setDuration(Duration.seconds(1));
        transicion.setNode(panelLateral);
        transicion.setByX(200);

        transicion.play();

        //Inhabilitar todos los botones
        cerrarSesion.setDisable(false);
        facturasBoton.setDisable(false);
        transferenciaBoton.setDisable(false);
        tarjetasBoton.setDisable(false);
        tablaTransferencias.setDisable(false);

        wait(1000);
        panelLateral.setVisible(false);
    }

    Boolean modoOscuroActivado = false;
    @FXML
    void ModoOscuroController(ActionEvent event) { //Cambiar colores a otros mas oscuros
        if (modoOscuroActivado == false) {
        
                //Q el boton se mueva a la derecha
                TranslateTransition transicion = new TranslateTransition();
                transicion.setDuration(Duration.seconds(0.7));
                transicion.setNode(modoOscuro);
                transicion.setByX(modoOscuro.getLayoutX() + (109 - 44));

                transicion.play();
                fondo.setStyle("-fx-background-color: #000000");
                modoOscuroActivado = true;

            } else if (modoOscuroActivado == true) {

                //Q el boton se mueva a la izquierda
                TranslateTransition transicion = new TranslateTransition();
                transicion.setDuration(Duration.seconds(0.7));
                transicion.setNode(modoOscuro);
                transicion.setByX(modoOscuro.getLayoutX() - (109 - 44));

                transicion.play();
                fondo.setStyle("-fx-background-color:  #21A9FF");
                modoOscuroActivado = false;
        }
    }

    @FXML
    void MisDatosController(ActionEvent event) {

    }

    @FXML
    void NotificacionesController(ActionEvent event) {

    }

    @FXML
    void AcercaDeController(ActionEvent event) {

    }

    @FXML
    void initialize() {
        /*
         * Cargar imagenes
         */

        Image salir = new Image("file:/home/dam/Escritorio/Ivanmg/Carpeta_programacion/JavaFX/Proyecto_mayo/appbanco/src/main/resources/imagenes/salir.png");
        imagenSalir.setImage(salir);
        imagenSalir.setFitHeight(20);
        imagenSalir.setFitWidth(20);

        Image oscuro = new Image("file:/home/dam/Escritorio/Ivanmg/Carpeta_programacion/JavaFX/Proyecto_mayo/appbanco/src/main/resources/imagenes/activarmodooscuro-removebg-preview.png");
        imagenModoOscuro.setImage(oscuro);
        //Q la imagen rellene el tamaño del boton
        imagenModoOscuro.setFitHeight(30);
        imagenModoOscuro.setFitWidth(30);


        //Q no se vea el panel lateral
        panelLateral.setVisible(true);

        /*
         * Ver q usuario esta operando
         */
        textoNombre.setText(nif_nombres.get(clienteOperando.getNif()));

    }
}
