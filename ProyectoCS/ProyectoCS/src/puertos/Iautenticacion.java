/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package puertos;

import dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Juan Diego Pacheco
 */
public interface Iautenticacion {
    boolean Registrar(Usuario u, String confirmar);
    boolean ValidarAcceso(Usuario u);
    ArrayList<Usuario> Listar();
}
