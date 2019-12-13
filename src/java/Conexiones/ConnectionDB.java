package Conexiones;
/*
    Debemos haber colocado en una carpeta lib del proyecto el .jar del Conector para
    MySQL correspondiente a la version de MySQL que tengamos instalada...
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB 
{
    private final String url;
    private Connection conn;
    
    public ConnectionDB() 
    {   
        //this.url = "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_002c139c356617d?user=bf3738fa61cab0&password=25cef0de";
       // this.url = "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_7d40021705f4e61?user=bf357389bc90bd&password=3a9137a7";
         this.url = "jdbc:mysql://bxujs437hlgz2swowkdv-mysql.services.clever-cloud.com:3306/bxujs437hlgz2swowkdv?user=ueo0lmvwklrnha8m&password=5Z7IO5a7F7RtzPhGxQB3";
        //this.url = "jdbc:mysql://localhost:3306/dbvaljeet?user=root&password=1234";
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//para MySQL 8.x..x
            //Class.forName("com.mysql.jdbc.Driver").newInstance();//para MySQL 5.x..x
            
            this.conn = DriverManager.getConnection(url);
            if(this.conn!=null)
                System.out.println("Todo bien..estamos conectados..!!");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();            
        }         
        catch (InstantiationException e) 
        {
            e.printStackTrace();
        }         
        catch (IllegalAccessException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
    
    public Connection getConn() {
        return conn;
    }
    public void cierraConexion()
    {        
        try 
        {
            this.conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
