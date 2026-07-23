/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Juan Diego Pacheco
 */
public class ClsArchivo {
    
    public static <T> void GuardarArchivo(T objeto, String nombreArchivo){
        try{
            Gson gson = new Gson();
            String json = gson.toJson(objeto);
            
            String jsonEncriptado = ClsEncriptar.Encriptar(json);
            
            try(FileWriter fw = new FileWriter(nombreArchivo + ".txt")){
                fw.write(jsonEncriptado);
            }
            
        }catch(Exception e){}
    }
    
    public static <T> T ObtenerObjeto(String nombreArchivo, Class<T> clase){
        
        File archivo = new File(nombreArchivo + ".txt");
        
        if(!archivo.exists()){
            return null;
        }
        
        try(FileReader reader = new FileReader(archivo);
            BufferedReader br = new BufferedReader(reader)){
            
            StringBuilder resultado = new StringBuilder();
            String line;
            
            while((line = br.readLine()) != null){
                resultado.append(line);
            }
            
            String json = ClsEncriptar.Desencriptar(resultado.toString());
            
            Gson gson = new Gson();
            
            return gson.fromJson(json, clase);
            
        }catch(Exception e){
            return null;
        }
    }
    
    public static void EliminarArchivo(String nombreArchivo){
        
        File archivo = new File(nombreArchivo + ".txt");
        
        if(archivo.exists()){
            archivo.delete();
        }
    }
}
