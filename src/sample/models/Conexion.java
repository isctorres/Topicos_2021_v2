package sample.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String server = "127.0.0.1";    //localhost
    private static String user   = "topicos2021";
    private static String pwd    = "123456789";
    private static String bd     = "tiendabd";

    public static Connection conexion;
    public static void getConexion() throws Exception{
        // Configuracion para MySQL
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+db,user,pwd);*/

        Class.forName("org.mariadb.jdbc.Driver");
        conexion = DriverManager.getConnection("jdbc:mariadb://"+server+":3306/"+bd,user,pwd);
    }
}