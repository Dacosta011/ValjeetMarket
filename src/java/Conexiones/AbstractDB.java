package Conexiones;

import java.sql.Connection;

public abstract class AbstractDB
{
  protected Connection conn;
  public AbstractDB()
  {
    ConnectionDB x = new ConnectionDB();
    this.conn = x.getConn();
  }
  
}