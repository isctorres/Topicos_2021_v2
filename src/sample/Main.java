package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.models.Conexion;
import sample.views.Loteria;
import sample.views.Taquimecanografo;

public class Main extends Application implements EventHandler<WindowEvent>{

    private BorderPane bdpPrincipal;
    private MenuBar mnbOpciones;
    private Menu menCompetencia1, menCompetencia2, menSalir;
    private MenuItem mitLoteria, mitTaqui, mitSalir;
    private Scene escena;

    @Override
    public void start(Stage primaryStage) throws Exception{
        CrearUI();
        escena = new Scene(bdpPrincipal);
        primaryStage.setScene(escena);
        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING,this);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Formulario Principal");
        primaryStage.show();
    }

    private void CrearUI() {
        bdpPrincipal = new BorderPane();
        mnbOpciones = new MenuBar();
        menCompetencia1 = new Menu("1er. Competencia");
        menCompetencia2 = new Menu("2da. Competencia");
        menSalir        = new Menu("Salir");
        // Agregar menus al menubar
        mnbOpciones.getMenus().addAll(menCompetencia1, menCompetencia2, menSalir);
        bdpPrincipal.setTop(mnbOpciones);
        // Instanciamos los MenuItems
        mitLoteria = new MenuItem("Loteria");
        mitTaqui   = new MenuItem("Taquimecanógrafo");

        mitLoteria.setOnAction(event -> MenuOpciones(1));
        mitTaqui.setOnAction(event -> MenuOpciones(2));

        menCompetencia1.getItems().addAll(mitLoteria,mitTaqui);
        mitSalir   = new MenuItem("Hasta luego...");
        mitSalir.setOnAction(event -> MenuOpciones(20));

        menSalir.getItems().add(mitSalir);
    }

    private void MenuOpciones(int opc){
        switch (opc){
            case 1: new Loteria(); break;
            case 2: new Taquimecanografo(); break;
            // aqui van los demás casos que se trabajarán en clase
            case 20: System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(WindowEvent event) {
        try {
            Conexion.getConexion();
            System.out.println("Conexion establecida.....");
        }catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Información del sistema");
            alerta.setHeaderText("Tópicos Avanzados de Programación");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
            System.exit(0);
        }
    }
}
