package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.ProductosDAO;

public class Productos extends Stage {
    private VBox vBox;
    private TableView<ProductosDAO> tbvProductos;
    private Button btnNuevo;
    private Scene escena;
    private ProductosDAO objPDAO;

    public Productos(){
        objPDAO = new ProductosDAO();
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

        CrearTabla();
    }

    private void CrearTabla(){
        TableColumn<ProductosDAO, Integer> tbcIdProducto = new TableColumn<>("ID");
        tbcIdProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));

        TableColumn<ProductosDAO, String> tbcNomProducto = new TableColumn<>("NOMBRE");
        tbcNomProducto.setCellValueFactory(new PropertyValueFactory<>("nomProducto"));

        TableColumn<ProductosDAO, Integer> tbcIdCategoria = new TableColumn<>("CATEGORIA");
        tbcIdCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));

        TableColumn<ProductosDAO, Integer> tbcstockProducto = new TableColumn<>("EXISTENCIA");
        tbcstockProducto.setCellValueFactory(new PropertyValueFactory<>("stockProducto"));

        TableColumn<ProductosDAO, Float> tbcPrecioProducto = new TableColumn<>("PRECIO");
        tbcPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precioProducto"));

        TableColumn<ProductosDAO, Float> tbcCostoProducto = new TableColumn<>("COSTO");
        tbcCostoProducto.setCellValueFactory(new PropertyValueFactory<>("costoProducto"));

        tbvProductos.getColumns().addAll(tbcIdProducto,tbcNomProducto,tbcIdCategoria,tbcstockProducto,tbcPrecioProducto,tbcCostoProducto);
        tbvProductos.setItems(objPDAO.SELECTALL());
    }
}
