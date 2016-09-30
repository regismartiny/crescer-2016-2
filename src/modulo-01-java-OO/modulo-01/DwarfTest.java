

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class DwarfTest
{
    @Test
    public void dwarfNascemCom110DeVida() {
        // Act
        Dwarf dwarf = new Dwarf();
        // Assert
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void dwarfLevaFlechada() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        int vida = dwarf.getVida();
        // Act
        dwarf.levarFlechada();
        // Assert
        assertEquals(vida - 10, dwarf.getVida());        
    }
    
    @Test
    public void dwarfMachucadoMasVivo() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        dwarf.levarFlechada();
        // Assert
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorto() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getStatus() != Status.MORTO) {
            dwarf.levarFlechada();
        }
        // Assert
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfAlvejadoAposMortoContinuaMorto() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getStatus() != Status.MORTO) {
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        // Assert
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfAlvejadoUmaVezAposMortoTemVida0() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getVida() > 0) {
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        // Assert
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void dwarfAlvejado5VezesAposMortoTemVida0() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        while(dwarf.getVida() > 0) {
            dwarf.levarFlechada();
        }
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void dwarfNascidoDia1Mes2Ano3000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(1,2,3000));
        // Assert
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(3000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfNascidoDia10Mes12Ano4000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(1,2,4000));
        // Assert
        assertEquals(1, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(4000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfComNomeNascidoDia15Mes11Ano3000() {
        // Act
        Dwarf dwarf = new Dwarf("Frodo", new DataTerceiraEra(15,11,3000));
        // Assert
        assertEquals("Frodo", dwarf.getNome());
        assertEquals(15, dwarf.getDataNascimento().getDia());
        assertEquals(11, dwarf.getDataNascimento().getMes());
        assertEquals(3000, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfComNomeNascidoDia10Mes2Ano3201() {
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(10,2,3201));
        // Assert
        assertEquals("Anão", dwarf.getNome());
        assertEquals(10, dwarf.getDataNascimento().getDia());
        assertEquals(2, dwarf.getDataNascimento().getMes());
        assertEquals(3201, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void dwarfNascidoAno3000Vida80() { // ano nao bissexto - 101.0
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(1,1,3000));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertFalse(dwarf.getDataNascimento().ehBissexto());
        assertEquals("Anão", dwarf.getNome());
        assertTrue(101.0 == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNascidoAno3200Vida90() { // ano bissexto - 101*-33
        // Act
        Dwarf dwarf = new Dwarf("Anão", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        assertEquals(90, dwarf.getVida());
        assertTrue((101.0*-33) == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeSeixasNascidoAno3200Vida100() { // ano bissexto - 101.0
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        assertFalse(dwarf.getVida() >= 80 && dwarf.getVida() <= 90);
        assertTrue((101.0) == dwarf.getNumeroSorte());
    } 
    
    
    @Test
    public void dwarfNomeSeixasNascidoAno3000Vida110() { // (101*33)%100
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,3000));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertFalse(dwarf.getDataNascimento().ehBissexto());
        assertEquals(110, dwarf.getVida());
        assertTrue((101.0*33)%100 == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeMeirelesNascidoAno3200Vida90() { //ano bissexto - 101*-33
        // Act
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        //assertEquals(90, dwarf.getVida());
        assertTrue((101.0*-33) == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeMeirelesNascidoAno3200Vida90NumeroDaSorte() { // numero < 0, sem flechada, exp += 2
        // Act
        Dwarf dwarf = new Dwarf("Meireles", new DataTerceiraEra(1,1,3200));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertTrue(dwarf.getDataNascimento().ehBissexto());
        assertEquals(90, dwarf.getVida());
        assertTrue((101.0*-33) == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfNomeSeixasNascidoAno3000Vida110NumeroDaSorte() { // // numero entre 0 e 100, sem flechada, sem exp
        // Act
        Dwarf dwarf = new Dwarf("Seixas", new DataTerceiraEra(1,1,3000));
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        dwarf.levarFlechada();
        // Assert
        assertFalse(dwarf.getDataNascimento().ehBissexto());
        assertEquals(110, dwarf.getVida());
        assertTrue((101.0*33)%100 == dwarf.getNumeroSorte());
    }
    
    @Test
    public void dwarfComVida0EstaMorto() {
        Dwarf d = new Dwarf();
        for(int i=0; i < 11; i++){
            d.levarFlechada();
        }
        assertEquals(0, d.getVida());
        assertEquals(Status.MORTO, d.getStatus());
    }
    
    @Test
    public void dwarfAlvejadoUmaVezAposMortoNaoTemVidaNegativa() {
        Dwarf d = new Dwarf();
        for(int i=0; i < 12; i++){
            d.levarFlechada();
        }
        assertEquals(0, d.getVida());
        assertEquals(Status.MORTO, d.getStatus());
    }
    
    @Test
    public void dwarfAlvejadoDezVezesAposMortoNaoTemVidaNegativa() {
        Dwarf d = new Dwarf();
        for(int i=0; i < 21; i++){
            d.levarFlechada();
        }
        assertEquals(0, d.getVida());
        assertEquals(Status.MORTO, d.getStatus());
    }
    
    @Test
    public void dwarfGanha1Item() {
        Dwarf d = new Dwarf();
        Item i = new Item("Revólver", 1);
        d.adicionarItem(i);
        
        assertTrue(d.getInventario().getLista().contains(i));
    }
    
    @Test
    public void dwarfGanha2Itens() {
        Dwarf d = new Dwarf();
        Item i = new Item("Revólver", 1);
        Item i2 = new Item("Faca", 1);
        d.adicionarItem(i);
        d.adicionarItem(i2);
        ArrayList<Item> lista = d.getInventario().getLista();
        
        assertTrue(lista.contains(i));
        assertTrue(lista.contains(i2));
    }
    
    @Test
    public void dwarfPerde1Item() {
        Dwarf d = new Dwarf();
        Item i = new Item("Revólver", 1);
        d.adicionarItem(i);
        d.perderItem(i);
        
        assertFalse(d.getInventario().getLista().contains(i));
    }
    
    @Test
    public void dwarfPerde2Itens() {
        Dwarf d = new Dwarf();
        Item i1 = new Item("Revólver", 1);
        Item i2 = new Item("Faca", 1);
        d.adicionarItem(i1);
        d.adicionarItem(i2);
        d.perderItem(i1);
        d.perderItem(i2);
        ArrayList<Item> lista = d.getInventario().getLista();
        
        assertFalse(lista.contains(i1));
        assertFalse(lista.contains(i2));
    }
    
    @Test
    public void dwarfComSorte() {
        Dwarf d = new Dwarf("Legolas", new DataTerceiraEra(1,1,3200));
        Item i1 = new Item("Revólver", 1);
        Item i2 = new Item("Faca", 2);
        d.adicionarItem(i1);
        d.adicionarItem(i2);
        d.levarFlechada();
        d.levarFlechada();
        Inventario inv = d.getInventario();
        
        assertTrue(d.tentarSorte());
        assertEquals(1001, inv.getLista().get(0).getQuantidade());
        assertEquals(1002, inv.getLista().get(1).getQuantidade());
        
    }
    
    @Test
    public void dwarfSemSorte() {
        Dwarf d = new Dwarf("Legolas", new DataTerceiraEra(1,1,3000));
        Item i1 = new Item("Revólver", 3);
        Item i2 = new Item("Faca", 2);
        d.adicionarItem(i1);
        d.adicionarItem(i2);
        d.levarFlechada();
        d.levarFlechada();
        Inventario inv = d.getInventario();
        
        assertFalse(d.tentarSorte());
        assertEquals(3, inv.getLista().get(0).getQuantidade());
        assertEquals(2, inv.getLista().get(1).getQuantidade());
        
    }
}
