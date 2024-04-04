/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author luisp
 */
public class TestValoracionLibro {
    
    
    @Test
    public void testObtieneValoracionLibro(){
        ValoracionLibro valoracionLibro = Mockito.mock(ValoracionLibro.class);
        Mockito.when(valoracionLibro.obtieneValoracionLibro("Harry potter")).thenReturn(4.5f);
        assertEquals(4.5f, valoracionLibro.obtieneValoracionLibro("Harry Potter"));
    }
    
}
