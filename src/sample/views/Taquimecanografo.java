package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Taquimecanografo extends Stage {

    private Scene escena;
    private VBox vBox, vTeclado;
    private HBox hFuncion;
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
    private Button[] arBtnMayu  = new Button[13];
    private Button[] arBtnShif  = new Button[13];
    private Button[] arBtnSpac  = new Button[11];

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
        tolOpciones.getItems().addAll(btnAbrir);

        txtFuente = new TextArea();
        txtFuente.setEditable(false);
        txtEscritura = new TextArea();

        vTeclado = new VBox();
        hFuncion = new HBox();
        vTeclado.getChildren().addAll(hFuncion);

        vBox.getChildren().addAll(tolOpciones,txtFuente,txtEscritura,vTeclado);

        escena = new Scene(vBox,600,300);
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

}
