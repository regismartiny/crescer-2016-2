import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void inventarioAdicionar1Item() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        i.adicionarItem(item);
        
        assertTrue(i.temItem(item));
    }
    
    @Test
    public void inventarioAdicionar3Itens() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        Item item2 = new Item("Dardo", 1);
        Item item3 = new Item("Pistola", 1);
        i.adicionarItem(item);
        i.adicionarItem(item2);
        i.adicionarItem(item3);
        
        assertTrue(i.temItem(item));
        assertTrue(i.temItem(item2));
        assertTrue(i.temItem(item3));
    }
    
    @Test
    public void inventarioRemoverItem() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        i.adicionarItem(item);
        i.removerItem(item);
        
        assertFalse(i.temItem(item));
    }
    
    @Test
    public void inventarioRemover2Itens() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        Item item2 = new Item("Dardo", 1);
        i.adicionarItem(item);
        i.adicionarItem(item2);
        i.removerItem(item);
        i.removerItem(item2);
        
        assertFalse(i.temItem(item));
        assertFalse(i.temItem(item2));
    }
    
    @Test
    public void inventarioVisualizarDescricao1Item() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        i.adicionarItem(item);
        
        assertEquals("Faca", i.getDescricoesItens());
    }
    
    @Test
    public void inventarioVisualizarDescricao3Itens() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        Item item2 = new Item("Dardo", 1);
        Item item3 = new Item("Pistola", 1);
        i.adicionarItem(item);
        i.adicionarItem(item2);
        i.adicionarItem(item3);
        
        assertEquals("Faca,Dardo,Pistola", i.getDescricoesItens());
    }
    
}
