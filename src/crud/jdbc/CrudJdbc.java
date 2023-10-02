package crud.jdbc;

import java.sql.*;
import javax.swing.JOptionPane;

public class CrudJdbc {
  Connection cn;

  public void connect(String url, String user, String password) {
    try {
      cn = DriverManager.getConnection(url, user, password);
      JOptionPane.showMessageDialog(null, "Conectado a la base de datos de forma exitosa con el usuario " + user + ".");
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "La conexión falló con el error: " + e.getMessage() + ".");
    }
  }

  public void disconnect() {
    if (cn != null) {
      try {
        cn.close();
        JOptionPane.showMessageDialog(null, "Desconectando...");
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "La desconexión falló con el error: " + e.getMessage() + ".");
      }
    }
  }

  public Connection getConnection() {
    return cn;
  }
}
