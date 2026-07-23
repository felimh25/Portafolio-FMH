/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import clases.Conexion;
import dao.validaciones.ClienteValidacion;
import dominio.Cliente;
import java.util.ArrayList;
import puertos.Icruds;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Diego Pacheco
 */
public class ClienteDAO implements Icruds<Cliente> {

    @Override
    public boolean crear(Cliente objeto) {
        
        if (!ClienteValidacion.ValidarCliente(objeto)) {
            return false;
        }
        
        //Proceso para agregar o actualizar una persona
        if (true) {
            
        }
        
        return true;
    }

    @Override
    public boolean actualizar(Cliente objeto) {
        return true;
    }

    @Override
    public boolean eliminar(int id) {
        return true;
    }

    @Override
    public Cliente buscarPorId(int id) {
        return null;
    }

    @Override
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "select c.id, c.correo, c.telefono, c.cedula, p.nombre, p.apellidos from cliente c inner join persona p on c.cedula = p.cedula";
        
        try(Connection con = Conexion.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)
           ){
            
            while(rs.next()){
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("correo"),
                        rs.getString("telefono"),
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellidos")
                ));
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "Hubo un error al cargar los datos de cliente!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        return lista;
    }

}
