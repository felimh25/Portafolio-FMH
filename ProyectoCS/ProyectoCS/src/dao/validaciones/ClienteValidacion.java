/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.validaciones;

import dominio.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Diego Pacheco
 */
public class ClienteValidacion {
    
    public static boolean ValidarCliente(Cliente c){
        try{
            
            if (c.getCedula().trim().length() < 11 ||
                c.getCorreo().isEmpty() ||
                c.getNombre().isEmpty() ||
                c.getApellidos().isEmpty() ||
                c.getTelefono().trim().length() < 9) {
                throw new Exception("Por favor llene todos los campos solicitados!");
            }
            
            return true;
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage(),
                    "Error!",
                    JOptionPane.ERROR_MESSAGE
            );
            
            return false;
        }
    }
}
