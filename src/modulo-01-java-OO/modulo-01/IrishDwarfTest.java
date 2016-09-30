

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfTemMuitaSorte3Itens() {
        IrishDwarf irish = new IrishDwarf("Irish", new DataTerceiraEra(1,1,3200));
        Item item1 = new Item("Faca", 3);
        Item item2 = new Item("Martelo", 4);
        Item item3 = new Item("Espada", 5);
        irish.adicionarItem(item1);
        irish.adicionarItem(item2);
        irish.adicionarItem(item3);
        irish.levarFlechada();
        irish.levarFlechada();
        irish.levarFlechada();
        irish.tentarSorte();
        Inventario i = irish.getInventario();
        
        assertEquals(6003, i.getLista().get(0).getQuantidade());
        assertEquals(10004, i.getLista().get(1).getQuantidade());
        assertEquals(15005, i.getLista().get(2).getQuantidade());
    }
    
    @Test
    public void irishDwarfTemMuitaSorte2Itens() {
        IrishDwarf irish = new IrishDwarf("Irish", new DataTerceiraEra(1,1,3200));
        Item item1 = new Item("Faca", 3);
        Item item2 = new Item("Martelo", 4);
        irish.adicionarItem(item1);
        irish.adicionarItem(item2);
        irish.levarFlechada();
        irish.levarFlechada();
        irish.levarFlechada();
        irish.tentarSorte();
        Inventario i = irish.getInventario();
        
        assertEquals(6003, i.getLista().get(0).getQuantidade());
        assertEquals(10004, i.getLista().get(1).getQuantidade());
    }
    
    @Test
    public void irishDwarfNaoTemMuitaSorte3Itens() {
        IrishDwarf irish = new IrishDwarf("Irish", new DataTerceiraEra(1,1,3000));
        Item item1 = new Item("Faca", 3);
        Item item2 = new Item("Martelo", 4);
        Item item3 = new Item("Espada", 5);
        irish.adicionarItem(item1);
        irish.adicionarItem(item2);
        irish.adicionarItem(item3);
        irish.levarFlechada();
        irish.levarFlechada();
        irish.levarFlechada();
        irish.tentarSorte();
        Inventario i = irish.getInventario();
        
        assertEquals(3, i.getLista().get(0).getQuantidade());
        assertEquals(4, i.getLista().get(1).getQuantidade());
        assertEquals(5, i.getLista().get(2).getQuantidade());
    }
    
    @Test
    public void irishDwarfQuantidadeNegativaComMuitaSorte() {
        IrishDwarf dwarf = new IrishDwarf("Mongo", new DataTerceiraEra(1, 1, 3200));
        dwarf.adicionarItem(new Item("Garrafa de Jack Daniels", -5));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.tentarSorte();
        assertEquals(14995, dwarf.getInventario().getLista().get(0).getQuantidade());
    }
}
