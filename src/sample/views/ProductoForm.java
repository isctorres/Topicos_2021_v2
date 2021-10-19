package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.ProductosDAO;

public class ProductoForm extends Stage {

    private Scene escena;
    private VBox vBox;
    private TextField txtNombre, txtCategoria, txtStock, txtPrecio, txtCosto;
    private Button btnGuardar;
    private ProductosDAO objPDAO;
    private TableView<ProductosDAO> tbvProductos;

    public ProductoForm(TableView<ProductosDAO> tbvProductos, ProductosDAO objPDAO){
        this.tbvProductos = tbvProductos;
        if( objPDAO != null )
            this.objPDAO = objPDAO;             // La acción es una actualización
        else
            this.objPDAO = new ProductosDAO();  // La acción es una inserción
        CrearUI();
        this.setTitle("Gestión de Producto");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del producto");
        txtNombre.setText(objPDAO.getNomProducto());

        txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoria del Producto");
        txtCategoria.setText( String.valueOf(objPDAO.getIdCategoria()));

        txtStock = new TextField();
        txtStock.setPromptText("Número de existencias");
        txtStock.setText(String.valueOf(objPDAO.getStockProducto()));

        txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio Sugerido");
        txtPrecio.setText(String.valueOf(objPDAO.getPrecioProducto()));

        txtCosto = new TextField();
        txtCosto.setPromptText("Costo del producto");
        txtCosto.setText(String.valueOf(objPDAO.getCostoProducto()));

        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> {
            objPDAO.setNomProducto(txtNombre.getText());
            objPDAO.setIdCategoria(Integer.parseInt(txtCategoria.getText()));
            objPDAO.setStockProducto(Integer.parseInt(txtStock.getText()));
            objPDAO.setPrecioProducto(Float.parseFloat(txtPrecio.getText()));
            objPDAO.setCostoProducto(Float.parseFloat(txtCosto.getText()));

            if( objPDAO.getIdProducto() > 0 )
                objPDAO.UPDATE();
            else
                objPDAO.INSERT();

            tbvProductos.setItems(objPDAO.SELECTALL());
            tbvProductos.refresh();

            this.close();
        });
        vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));
        vBox.getChildren().addAll(txtNombre,txtCategoria,txtStock,txtPrecio,txtCosto,btnGuardar);
        escena = new Scene(vBox, 300, 250);
    }
}
