import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest
{
    @Test
    public void inventarioAdicionar1Item() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        i.adicionarItem(item);
        
        assertTrue(i.getLista().contains(item));
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
        ArrayList<Item> lista = i.getLista();
        
        assertTrue(lista.contains(item));
        assertTrue(lista.contains(item2));
        assertTrue(lista.contains(item3));
    }
    
    @Test
    public void inventarioAdicionar1ItemERemover() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        i.adicionarItem(item);
        i.removerItem(item);
        
        assertFalse(i.getLista().contains(item));
    }
    
    @Test
    public void inventarioRemoverItem() {
        Inventario i = new Inventario();
        Item item = new Item("Faca", 1);
        i.adicionarItem(item);
        i.removerItem(item);
        ArrayList<Item> lista = i.getLista();
        
        assertFalse(lista.contains(item));
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
        ArrayList<Item> lista = i.getLista();
        
        assertFalse(lista.contains(item));
        assertFalse(lista.contains(item2));
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
        Item item2 = new Item("Dardo", 2);
        Item item3 = new Item("Pistola", 1);
        i.adicionarItem(item);
        i.adicionarItem(item2);
        i.adicionarItem(item3);
        
        assertEquals("Faca,Dardo,Pistola", i.getDescricoesItens());
    }
    
    @Test
    public void inventarioItemMaisPopularFaca() {
        Inventario i = new Inventario();
        Item item1 = new Item("Faca", 10);
        Item item2 = new Item("Dardo", 2);
        Item item3 = new Item("Pistola", 1);
        i.adicionarItem(item1);
        i.adicionarItem(item2);
        i.adicionarItem(item3);
        
        assertEquals(item1, i.getItemMaisPopular());
    }
    
    @Test
    public void inventarioItemMaisPopularPistola() {
        Inventario i = new Inventario();
        Item item1 = new Item("Faca", 10);
        Item item2 = new Item("Dardo", 2);
        Item item3 = new Item("Pistola", 12);
        i.adicionarItem(item1);
        i.adicionarItem(item2);
        i.adicionarItem(item3);
        
        assertEquals(item3, i.getItemMaisPopular());
    }
    
    @Test
    public void inventarioItemMaisPopularDardo() {
        Inventario i = new Inventario();
        Item item1 = new Item("Faca", 10);
        Item item2 = new Item("Dardo", 20);
        Item item3 = new Item("Pistola", 1);
        i.adicionarItem(item1);
        i.adicionarItem(item2);
        i.adicionarItem(item3);
        
        assertEquals(item2, i.getItemMaisPopular());
    }
    
    @Test
    public void aumentar1000UnidadesItem() {
        Inventario i = new Inventario();
        Item item1 = new Item("Faca", 10);
        i.adicionarItem(item1);
        i.aumentar1000UnidadesDosItens();
        
        assertEquals(1010, i.getLista().get(0).getQuantidade());
    }
    
    @Test
    public void aumentar2000UnidadesItem() {
        Inventario i = new Inventario();
        Item item1 = new Item("Faca", 20);
        i.adicionarItem(item1);
        i.aumentar1000UnidadesDosItens();
        i.aumentar1000UnidadesDosItens();
        
        assertEquals(2020, i.getLista().get(0).getQuantidade());
    }
    
    @Test
    public void aumentar2000Unidades2Itens() {
        Inventario i = new Inventario();
        Item item1 = new Item("Faca", 20);
        Item item2 = new Item("Martelo", 20);
        i.adicionarItem(item1);
        i.adicionarItem(item2);
        i.aumentar1000UnidadesDosItens();
        i.aumentar1000UnidadesDosItens();
        
        assertEquals(2020, i.getLista().get(0).getQuantidade());
        assertEquals(2020, i.getLista().get(1).getQuantidade());
    }
    
    
    
}
