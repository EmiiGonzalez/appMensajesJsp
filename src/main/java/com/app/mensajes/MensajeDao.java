package com.app.mensajes;

import static com.app.mensajes.Conexion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MensajeDao {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs  = null;
    private Mensaje mensaje;
    
    public List<Mensaje>seleccionar() throws ClassNotFoundException{
        String sql = "SELECT *  FROM mesajes_tabla";
            List<Mensaje> mensajes = new ArrayList<>();
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            
            while(this.rs.next()){
                int id = this.rs.getInt("id_mensaje");
                String msm = this.rs.getString("mensaje");
                String autor = this.rs.getString("autor");
                String fecha = this.rs.getString("fecha");  
                 
                this.mensaje = new Mensaje(msm, id , autor, fecha);  
                mensajes.add(this.mensaje);
            }           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   finally{
            try {
                close(this.rs);
                close(this.ps);
                close(this.conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return mensajes;
    }

     public int insertar(Mensaje mensaje) throws ClassNotFoundException{
        String sql = "INSERT INTO mesajes_tabla (mensaje,autor,fecha) VALUES (?,?, CURRENT_TIME())";
        int registros = 0;
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);

            this.ps.setString(1, mensaje.getMensaje());
            this.ps.setString(2, mensaje.getAutor());
            registros = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   finally{
            try {
                close(this.ps);
                close(this.conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int editar(Mensaje mensaje) throws ClassNotFoundException{
        String sql = "UPDATE mesajes_tabla SET mensaje= ?, autor= ? WHERE id_mensaje= ?";
        int registros = 0;
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);

            this.ps.setString(1, mensaje.getMensaje());
            this.ps.setString(2, mensaje.getAutor());
            this.ps.setInt(3, mensaje.getId());
            registros = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   finally{
            try {
                close(this.ps);
                close(this.conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(Mensaje mensaje) throws ClassNotFoundException{
        String sql = "DELETE FROM mesajes_tabla WHERE id_mensaje= ?";
        int registros = 0;
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setInt(1, mensaje.getId());
            
            registros = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }   finally{
            try {
                close(this.ps);
                close(this.conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
}
