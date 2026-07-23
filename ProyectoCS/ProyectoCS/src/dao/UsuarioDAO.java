/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import clases.ClsEncriptar;
import clases.ClsGlobales;
import clases.Conexion;
import dao.validaciones.UsuarioValidacion;
import dominio.Usuario;
import java.util.ArrayList;
import puertos.Iautenticacion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Diego Pacheco
 */
public class UsuarioDAO implements Iautenticacion {

    @Override
    public boolean ValidarAcceso(Usuario u) {
        
        String sql = "SELECT * FROM usuario WHERE correo = ?";
        
        try(
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
           ){
        
            ps.setString(1, u.getCorreo());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                String salt = rs.getString("salt");
                String claveEncriptada = ClsEncriptar.encriptaSHA256(u.getClave(), salt);
                
                if(!claveEncriptada.equals(rs.getString("clave"))){
                    throw new SQLException("Los datos de acceso son incorrectos","LAcceso",2);
                }
                
                if(!rs.getBoolean("activo")){
                    throw new SQLException("Su usuario esta inactivo", "LInactivo",3);
                }
                
                ClsGlobales.usuarioGlobal = new Usuario(
                        rs.getString("correo")
                );
                
                return true;
                
            }else{
                throw new SQLException("El correo no exite", "LEmail",1);
            }
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Error!",
                    JOptionPane.ERROR_MESSAGE
            );
            
            return false;
        }
    }
    
    @Override
    public boolean Registrar(Usuario u, String confirmar) {
        
        if (!UsuarioValidacion.ValidarRegistro(u, confirmar)) {
            return false;
        }
        
        u.setSalt(ClsEncriptar.generarSalt());
        u.setClave(ClsEncriptar.encriptaSHA256(confirmar, u.getSalt()));
        
        String sql = "INSERT INTO usuario(correo, clave, salt) values(?,?,?)";
        
        try(
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
           ){
            
            ps.setString(1, u.getCorreo());
            ps.setString(2, u.getClave());
            ps.setString(3, u.getSalt());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(
                    null, 
                    "Usuario creado con éxito!"
            );
            
            return true;
            
        }catch(SQLException e){
            
            String mensaje;
            
            switch(e.getErrorCode()){
                case 1062:
                    mensaje = "El correo electrónico ya existe!";
                    break;
                default:
                    mensaje = e.getMessage();
            }
            
            JOptionPane.showMessageDialog(
                    null, 
                    mensaje,
                    "Error!",
                    JOptionPane.ERROR_MESSAGE
            );
            
            return false;
        }
    }

    @Override
    public ArrayList<Usuario> Listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, correo, activo FROM usuario";
        
        try(Connection con = Conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
            
            while(rs.next()){
                lista.add(
                    new Usuario(
                        rs.getInt("id"),
                        rs.getString("correo"),
                        rs.getBoolean("activo")
                    )
                );
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "Hubo un error al cargar los datos de usuario!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        return lista;
    }
    
}
