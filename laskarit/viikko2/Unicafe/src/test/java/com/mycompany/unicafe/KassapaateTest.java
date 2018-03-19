package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;

    public KassapaateTest() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @Test
    public void AlkukassanSaldoTasmaa() {
        assertEquals(1000_00, kassa.kassassaRahaa());
    }
    
    @Test
    public void AlkukassanMyydytMaukkaatTasmaa() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void alkukassanMyydytEdullisetTasmaa() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myyntiseurantaPaivittyyMaukastaOstettaessa() {
        kassa.syoMaukkaasti(5_00);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahaSiirtyyKassaanMaukastaOstettaessa() {
        kassa.syoMaukkaasti(5_00);
        assertEquals(1004_00, kassa.kassassaRahaa());
    }
    
    @Test
    public void myyntiseurantaPaivittyyEdullistaOstettaessa() {
        kassa.syoEdullisesti(5_00);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void rahaSiirtyyKassaanEdullistaOstettaessa() {
        kassa.syoEdullisesti(5_00);
        assertEquals(1002_40, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahaPalautetaanKunEiRiitaMaukkaaseen() {
        assertEquals(3_00, kassa.syoMaukkaasti(3_00));
    }
    
    @Test
    public void rahaPalautetaanKunEiRiitaEdulliseen() {
        assertEquals(2_00, kassa.syoMaukkaasti(2_00));
    }
    
    @Test
    public void myyntitilastoaEiKasvatetaKunMaukkaanOstoEpaonnistuu() {
        kassa.syoMaukkaasti(3_00);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void myyntitilastoaEiKasvatetaKunEdullisenOstoEpaonnistuu() {
        kassa.syoEdullisesti(2_00);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassaanEiLisataRahaaKunMaukkaanOstoEpaonnistuu() {
        kassa.syoMaukkaasti(3_00);
        assertEquals(1000_00, kassa.kassassaRahaa());
    }

    @Test
    public void kassaanEiLisataRahaaKunEdullisenOstoEpaonnistuu() {
        kassa.syoEdullisesti(2_00);
        assertEquals(1000_00, kassa.kassassaRahaa());
    }
    
    
}
