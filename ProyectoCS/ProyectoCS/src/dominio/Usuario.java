/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Juan Diego Pacheco
 */
public class Usuario extends Persona {
    private int id;
    private String correo;
    private String clave;
    private String salt;
    private boolean activo;

    public Usuario(String correo) {
        super(null, null, null);
        this.correo = correo;
    }
    
    public Usuario(String correo, String clave) {
        super(null, null, null);
        this.correo = correo.toLowerCase();
        this.clave = clave;
    }

    public Usuario(int id, String correo, boolean activo) {
        super(null, null, null);
        this.id = id;
        this.correo = correo;
        this.activo = activo;
    }
    
    public Usuario(String correo, String clave, boolean activo) {
        super(null, null, null);
        this.correo = correo.toLowerCase();
        this.clave = clave;
        this.activo = activo;
    }

    public Usuario(String correo, String clave, String salt, boolean activo, String cedula, String nombre, String apellidos) {
        super(cedula, nombre, apellidos);
        this.correo = correo.toLowerCase();
        this.clave = clave;
        this.salt = salt;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }
    
    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public String getSalt() {
        return salt;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", clave=" + clave + ", salt=" + salt + ", activo=" + activo + '}';
    }
}
