import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void Ano2015Bissexto() { // nao é
        // Act
        DataTerceiraEra data = new DataTerceiraEra(1,1,2015);
        // Assert
        assertFalse(data.ehBissexto());
    }
    
    @Test
    public void Ano2016Bissexto() { // é
        // Act
        DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
        // Assert
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void Ano3000Bissexto() {
        // Act
        DataTerceiraEra data = new DataTerceiraEra(1,1,3000);
        // Assert
        assertFalse(data.ehBissexto());
    }
    
    @Test
    public void Ano3200Bissexto() {
        // Act
        DataTerceiraEra data = new DataTerceiraEra(1,1,3200);
        // Assert
        assertTrue(data.ehBissexto());
    }
}
