package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Loteria extends Stage {

    private String[] arImagenes = {"barril.jpeg","botella.jpeg","catrin.jpeg","chavorruco.jpeg","concha.jpeg","graduada.jpeg","luchador.jpeg","maceta.jpeg","rosa.jpeg","tacos.jpeg","venado.jpeg"};
    private Scene escena;
    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAtras, btnSiguiente;
    private Button[][] arBtnCartas = new Button[3][3];
    private Image imgCarta;
    private GridPane gdpPlantilla;

    public Loteria(){
        CrearUI();
        this.setTitle("Loteria");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        vBox = new VBox();
        hBox1 = new HBox();
        btnAtras = new Button("<");
        btnSiguiente = new Button(">");
        hBox1.getChildren().addAll(btnAtras,btnSiguiente);

        hBox2 = new HBox();
        gdpPlantilla = new GridPane();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                arBtnCartas[j][i] = new Button();
                arBtnCartas[j][i].setPrefSize(100,120);

                imgCarta = new Image("sample/images/"+arImagenes[i]);
                ImageView view = new ImageView(imgCarta);
                view.setFitHeight(120);
                view.setFitWidth(100);
                view.setPreserveRatio(true);
                arBtnCartas[j][i].setGraphic(view);

                gdpPlantilla.add(arBtnCartas[j][i],j,i);
            }
        }
        hBox2.getChildren().addAll(gdpPlantilla);
        vBox.getChildren().addAll(hBox1,hBox2);

        escena = new Scene(vBox,500,600);
    }
}
