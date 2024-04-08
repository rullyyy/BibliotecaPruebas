/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.time.LocalDate;


/**
 *
 * @author PC
 */
public class DTOAgregarUsuario {
    private int id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String curp;
    private String matricula;
    

    public DTOAgregarUsuario() {
    
    }

    public DTOAgregarUsuario(int id, String nombre, String apellido, LocalDate fechaNacimiento, String curp, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.matricula = matricula;
    }

    public DTOAgregarUsuario(String nombre, String apellido, LocalDate fechaNacimiento, String curp, String matricula) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.matricula = matricula;
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
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    
}
