
package javaapplication1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/brotherstore";
        Connection cnx;
        Statement st;
        ResultSet rs;        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cnx=DriverManager.getConnection(url, usuario, password);
            st=cnx.createStatement();
            rs=st.executeQuery("select * from clientes");
            rs.next();
            do {
                System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+":"+rs.getString("email")+":"+rs.getString("telefono")+":"+rs.getString("direccion"));
            } while (rs.next());
            
            // insertar en BD
            
            st.executeUpdate("insert into clientes values('9','santiago','santiago','121545456','diagonal')");
            System.out.println();
            rs=st.executeQuery("select * from clientes");
            rs.next();
            do {
                System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+":"+rs.getString("email")+":"+rs.getString("telefono")+":"+rs.getString("direccion"));
            } while (rs.next());
            
            // eliminar en BD
            st.executeUpdate("delete from clientes where id = '8' ");
            System.out.println();
            rs=st.executeQuery("select * from clientes");
            rs.next();

            } catch (SQLException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
