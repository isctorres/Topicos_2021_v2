package sample.views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Loteria extends Stage {

    private String[] arImagenes = {"barril.jpeg","botella.jpeg","catrin.jpeg","chavorruco.jpeg","concha.jpeg","graduada.jpeg","luchador.jpeg","maceta.jpeg","rosa.jpeg","tacos.jpeg","venado.jpeg"};
    private Scene escena;
    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAtras, btnSiguiente;
    private Button[][] arBtnCartas = new Button[3][3];
    private Image imgCarta;
    private GridPane gdpPlantilla;
    private Label lblCarta;         // Clase 8

    public Loteria(){
        CrearUI();
        this.setTitle("Loteria");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        vBox = new VBox();
        hBox1 = new HBox();
        btnAtras = new Button("< Plantilla Anterior");
        btnSiguiente = new Button("Plantilla Siguiente >");
        btnSiguiente.setOnAction(event -> iniciarJuego());
        hBox1.getChildren().addAll(btnAtras,btnSiguiente);
        hBox1.setSpacing(10);   // Clase 8

        hBox2 = new HBox();
        gdpPlantilla = new GridPane();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                arBtnCartas[j][i] = new Button();
                arBtnCartas[j][i].setPrefSize(120,140);

                imgCarta = new Image("sample/images/"+arImagenes[i]);
                ImageView view = new ImageView(imgCarta);
                view.setFitHeight(140);
                view.setFitWidth(120);
                view.setPreserveRatio(true);
                arBtnCartas[j][i].setGraphic(view);

                gdpPlantilla.add(arBtnCartas[j][i],j,i);
            }
        }

        lblCarta = new Label();
        imgCarta = new Image("sample/images/"+arImagenes[0]);
        ImageView view = new ImageView(imgCarta);
        view.setFitWidth(180);
        view.setFitHeight(200);
        view.setPreserveRatio(true);
        lblCarta.setGraphic(view);
        lblCarta.setAlignment(Pos.CENTER);

        hBox2.getChildren().addAll(gdpPlantilla, lblCarta);
        hBox2.setSpacing(10);

        vBox.getChildren().addAll(hBox1,hBox2);
        vBox.setSpacing(10);                                // Clase 8
        vBox.setPadding(new Insets(10));   // Clase 8

        escena = new Scene(vBox,600,510);
    }

    private void iniciarJuego() {
        Timer timer = new Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Platform.runLater(
                        new Runnable() {
                            @Override
                            public void run() {
                                imgCarta = new Image("sample/images/"+arImagenes[1]);
                                ImageView view = new ImageView(imgCarta);
                                lblCarta.setGraphic(view);
                            }
                        }
                );
            }
        });
        timer.start();
    }
}
