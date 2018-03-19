package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void kortinSaldoKasvaaOikein() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 10.10", kortti.toString());
    }
    
    @Test
    public void kortinSaldoEiMuutuJosHintaYlittaaSaldon() {
        kortti.otaRahaa(2000);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void kortinSaldoVaheneeOikein() { // ei vähene!
        kortti.otaRahaa(8);
        assertEquals("saldo: 0.02", kortti.toString());
    }
    
    @Test
    public void ostoPalauttaaFalseJosSaldoEiRiitaMaukkaaseen() {
        Kassapaate kassa = new Kassapaate();
        assertFalse(kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void ostoPalauttaaTrueJosSaldoRiitaaMaukkaaseen() {
        Kassapaate kassa = new Kassapaate();
        Maksukortti kortti2 = new Maksukortti(2000);
        assertTrue(kassa.syoMaukkaasti(kortti2));
    }

    @Test
    public void ostoPalauttaaFalseJosSaldoEiRiitaEdulliseen() {
        Kassapaate kassa = new Kassapaate();
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void ostoPalauttaaTrueJosSaldoRiitaaEdulliseen() {
        Kassapaate kassa = new Kassapaate();
        Maksukortti kortti2 = new Maksukortti(2000);
        assertTrue(kassa.syoEdullisesti(kortti2));
    }
}

