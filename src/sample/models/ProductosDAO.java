package sample.models;

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

    }

    public void UPDATE(){

    }

    public void DELETE(){

    }

    // Recupera todos los registros de la tabla
    public void SELECTALL(){

    }

    // Recupera solo un registro identificado por el id
    public void SELECTID(){

    }
}
