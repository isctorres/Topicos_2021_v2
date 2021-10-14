package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class ProductosDAO {

    //public ProductosDAO(){}

    private int idProducto;
    private String nomProducto;
    private int idCategoria;
    private int stockProducto;
    private float precioProducto;
    private float costoProducto;

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public String getNomProducto() { return nomProducto; }
    public void setNomProducto(String nomProducto) { this.nomProducto = nomProducto; }
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    public int getStockProducto() { return stockProducto; }
    public void setStockProducto(int stockProducto) { this.stockProducto = stockProducto; }
    public float getPrecioProducto() { return precioProducto; }
    public void setPrecioProducto(float precioProducto) { this.precioProducto = precioProducto; }
    public float getCostoProducto() { return costoProducto; }
    public void setCostoProducto(float costoProducto) { this.costoProducto = costoProducto; }

    //CRUD
    // C -> Create
    // R -> Read
    // U -> Update
    // D -> Delete

    public void INSERT(){
        try{
            String query = "INSERT INTO tblProductos (nomProducto, idCategoria, stockProducto, precioProducto, costoProducto) " +
                    "values('"+nomProducto+"',"+idCategoria+","+stockProducto+","+precioProducto+","+costoProducto+")";
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace(); // DEBUG MODE
        }
    }

    public void UPDATE(){
        try{
            String query = "UPDATE tblProductos SET nomProducto = '"+nomProducto+"', idCategoria = "+idCategoria+", " +
                    "stockProducto = "+stockProducto+", precioProducto = "+precioProducto+"," +
                    "costoProducto =  WHERE idProducto = "+idProducto;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace(); // DEBUG MODE
        }
    }

    public void DELETE(){
        try{
            String query = "DELETE FROM tblProductos WHERE idProducto = "+idProducto;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace(); // DEBUG MODE
        }
    }

    // Recupera todos los registros de la tabla
    public ObservableList<ProductosDAO> SELECTALL(){
        ObservableList<ProductosDAO> listaP = FXCollections.observableArrayList();
        try {
            ProductosDAO objP;

            String query = "SELECT * FROM tblProductos";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objP = new ProductosDAO();
                objP.setIdProducto(res.getInt("idProducto"));
                objP.setNomProducto(res.getString("nomProducto"));
                objP.setIdCategoria(res.getInt("idCategoria"));
                objP.setStockProducto(res.getInt("stockProducto"));
                objP.setPrecioProducto(res.getFloat("precioProducto"));
                objP.setCostoProducto(res.getFloat("costoProducto"));
                listaP.add(objP);
            }
        }catch (Exception e){
            e.printStackTrace(); // DEBUG MODE
        }
        return listaP;
    }

    // Recupera solo un registro identificado por el id
    public ProductosDAO SELECTID(){
        ProductosDAO objP = null;
        try {
            String query = "SELECT * FROM tblProductos where idProducto = " + idProducto;
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            if( res.next() ){
                objP = new ProductosDAO();
                objP.setIdProducto(res.getInt("idProducto"));
                objP.setNomProducto(res.getString("nomProducto"));
                objP.setIdCategoria(res.getInt("idCategoria"));
                objP.setStockProducto(res.getInt("stockProducto"));
                objP.setPrecioProducto(res.getFloat("precioProducto"));
                objP.setCostoProducto(res.getFloat("costoProducto"));
            }
        }catch (Exception e){
            e.printStackTrace(); //DEBUG MODE
        }
        return objP;
    }
}
