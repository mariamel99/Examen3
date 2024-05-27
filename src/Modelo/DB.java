package Modelo;

public class DB {
    private static DB dbInstance; //Variable para almacenar la unica instancia de la clase
    private static java.sql.Connection con;
    DB() {
        // El Constructor es privado!!
    }
    public static DB getInstance(){
        //Si no hay ninguna instancia...
        if(dbInstance==null){
            dbInstance= new DB();
        }
        return dbInstance;
    }
    public static java.sql.Connection getConnection(){
        if(con==null){
            try {
                String host = "jdbc:mysql://192.168.201.116:33060/gestionEquipos";
                String username = "maria";
                String password = "secret";
                con = java.sql.DriverManager.getConnection( host, username, password );
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error al conectar: "+ ex.getMessage());
            }
        }
        return con;
    }
}
