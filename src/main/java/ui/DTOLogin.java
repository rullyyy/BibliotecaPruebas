/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author luisp
 */
public class DTOLogin {
    private long matricula;
    private String password;
    
    public DTOLogin(){
        
    }
    public DTOLogin(long matricula, String password) {
        this.matricula = matricula;
        this.password = password;
    }
    
    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}   
