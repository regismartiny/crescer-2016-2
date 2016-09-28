

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste CestoDeLembasTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class CestoDeLembasTest
{
    @Test
    public void cestoComDoisPaes(){
        // Arrange
        CestoDeLembas cesto = new CestoDeLembas(2);
        // Assert
        assertFalse(cesto.podeDividirEmPares());
    }
    
    @Test
    public void cestoComTresPaes(){
        // Arrange
        CestoDeLembas cesto = new CestoDeLembas(3);
        // Assert
        assertFalse(cesto.podeDividirEmPares());
    }
    
    @Test
    public void cestoComQuatroPaes(){
        // Arrange
        CestoDeLembas cesto = new CestoDeLembas(4);
        // Assert
        assertTrue(cesto.podeDividirEmPares());
    }
    
    @Test
    public void cestoCom101Paes(){
        // Arrange
        CestoDeLembas cesto = new CestoDeLembas(101);
        // Assert
        assertFalse(cesto.podeDividirEmPares());
    }

}
