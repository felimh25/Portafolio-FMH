/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.validaciones;

import dominio.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Diego Pacheco
 */
public class UsuarioValidacion {
    
    public static boolean ValidarRegistro(Usuario u, String confirmar){
        try{
            
            if (u.getCorreo().isEmpty() ||
                u.getClave().isEmpty() ||
                confirmar.isEmpty()) {
                throw new Exception("Debe llenar todos los datos solicitados!");
            }
            
            if (!u.getClave().equals(confirmar)) {
                throw new Exception("Las contraseñas no coinciden!");
            }
            
            if (u.getClave().length() < 6) {
                throw new Exception("La contraseña debe tener minimo 6 caracteres!");
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
