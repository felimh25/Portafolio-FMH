/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Juan Diego Pacheco
 */
public class Cliente extends Persona {
    
    private int id;
    private String correo;
    private String telefono;

    public Cliente(int id, String correo, String telefono, String cedula, String nombre, String apellidos) {
        super(cedula, nombre, apellidos);
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
