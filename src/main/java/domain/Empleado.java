/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public class Empleado {

    private int id;
    private String nombre;
    private String apellido;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static Empleado buscarPorId(int id) {
        List<Empleado> empleados = obtenerEmpleadosDeLaBaseDeDatos();

        // Buscar el empleado con el ID proporcionado
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }

        return null;
    }

    private static List<Empleado> obtenerEmpleadosDeLaBaseDeDatos() {
        List<Empleado> empleados = new ArrayList<>();
        // Agregar algunos empleados para simular la base de datos
        empleados.add(new Empleado("Juan", "Perez"));
        empleados.add(new Empleado("María", "García"));
        empleados.add(new Empleado("Carlos", "López"));
        return empleados;
    }
}
