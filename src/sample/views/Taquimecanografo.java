package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Taquimecanografo extends Stage implements EventHandler<KeyEvent> {

    private Scene escena;
    private VBox vBox, vTeclado;
    private HBox hFuncion, hNum, hTap;
    private TextArea txtFuente;
    private TextArea txtEscritura;
    private ToolBar tolOpciones;
    private Button btnAbrir;

    private Image imgOpcion;
    private ImageView imvOpcion;
    private FileChooser flcArchivo;

    private Button[] arBtnFunc  = new Button[13];
    private Button[] arBtnNum   = new Button[14];
    private Button[] arBtnTab   = new Button[14];
    private String[] arSimTab   = {"->","Q","W","E","R","T","Y","U","I","O","P","^","*","Enter"};
    private Button[] arBtnMayu  = new Button[13];
    private Button[] arBtnShif  = new Button[13];
    private Button[] arBtnSpac  = new Button[11];

    private boolean ban = false;    // bandera para detectar cuando se presiona o suelta una tecla

    public Taquimecanografo() {
        CrearUI();
        this.setTitle("Taquimecanógrafo");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        tolOpciones = new ToolBar();
        imgOpcion = new Image("sample/images/file_open_icon.png");
        imvOpcion = new ImageView(imgOpcion);
        imvOpcion.setFitHeight(24);
        imvOpcion.setFitWidth(24);
        btnAbrir = new Button();
        btnAbrir.setOnAction(event -> tlbOpciones(1));
        btnAbrir.setGraphic(imvOpcion);
        btnAbrir.setId("btn_menu");
        tolOpciones.getItems().addAll(btnAbrir);

        txtFuente = new TextArea();
        txtFuente.setEditable(false);
        txtEscritura = new TextArea();
        txtEscritura.setOnKeyPressed(this);
        txtEscritura.setOnKeyReleased(this);

        vTeclado = new VBox();
        hFuncion = new HBox();
        hNum     = new HBox();
        hTap     = new HBox();
        hTap.setSpacing(5);
        setButtons(arBtnTab,hTap,arSimTab);

        vTeclado.getChildren().addAll(hFuncion,hNum,hTap);
        vBox.getChildren().addAll(tolOpciones,txtFuente,txtEscritura,vTeclado);

        escena = new Scene(vBox,600,300);
        escena.getStylesheets().add("sample/css/style.css");
    }

    private void setButtons(Button[] arBtns,HBox hBtns, String[] arSimbolos){
        for (int i = 0; i < arBtns.length ; i++) {
            arBtns[i] = new Button(arSimbolos[i]);
            hBtns.getChildren().add(arBtns[i]);
        }
    }

    private void tlbOpciones(int opc) {
        switch(opc){
            case 1:
                flcArchivo = new FileChooser();
                flcArchivo.setTitle("Buscar archivo......");
                flcArchivo.getExtensionFilters().add(
                        new FileChooser.ExtensionFilter("TXT","*.txt"));
                File file = flcArchivo.showOpenDialog(this);
        }
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode().toString()){
            case "Q":
                if( ban == false ) {
                    arBtnTab[1].setStyle("-fx-background-color: gray");
                }else{
                    arBtnTab[1].setStyle("-fx-background-color: green");
                }
                break;
        }

        ban = !ban;
    }
}
