/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package puertos;

import java.util.ArrayList;

/**
 *
 * @author Juan Diego Pacheco
 */
public interface Icruds<T> {
    boolean crear(T objeto);
    boolean actualizar(T objeto);
    boolean eliminar(int id);
    T buscarPorId(int id);
    ArrayList<T> listar();
}
