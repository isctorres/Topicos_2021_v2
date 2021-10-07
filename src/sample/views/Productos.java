package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.ProductosDAO;

public class Productos extends Stage {
    private VBox vBox;
    private TableView<ProductosDAO> tbvProductos;
    private Button btnNuevo;
    private Scene escena;

    public Productos(){
        CrearUI();
        this.setTitle("Administración de Productos");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvProductos = new TableView<>();
        btnNuevo = new Button("Nuevo Producto");
        btnNuevo.setOnAction(event -> {});
        vBox = new VBox();
        vBox.getChildren().addAll(tbvProductos,btnNuevo);
        escena = new Scene(vBox, 300, 250);
    }
}
