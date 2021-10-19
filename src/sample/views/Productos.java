package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.CellCustome;
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
        btnNuevo.setOnAction(event -> {
            new ProductoForm(tbvProductos, null);
        });
        vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));
        vBox.getChildren().addAll(tbvProductos,btnNuevo);
        escena = new Scene(vBox, 700, 250);

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

        TableColumn<ProductosDAO, String> tbcEditar = new TableColumn<>("Acción");
        tbcEditar.setCellFactory(new Callback<TableColumn<ProductosDAO, String>, TableCell<ProductosDAO, String>>() {
            @Override
            public TableCell<ProductosDAO, String> call(TableColumn<ProductosDAO, String> param) {
                return new CellCustome(1);
            }
        });

        TableColumn<ProductosDAO, String> tbcBorrar = new TableColumn<>("Acción");
        tbcBorrar.setCellFactory(new Callback<TableColumn<ProductosDAO, String>, TableCell<ProductosDAO, String>>() {
            @Override
            public TableCell<ProductosDAO, String> call(TableColumn<ProductosDAO, String> param) {
                return new CellCustome(2);
            }
        });

        tbvProductos.getColumns().addAll(tbcIdProducto,tbcNomProducto,tbcIdCategoria,tbcstockProducto,tbcPrecioProducto,tbcCostoProducto,tbcEditar,tbcBorrar);
        tbvProductos.setItems(objPDAO.SELECTALL());
    }
}
