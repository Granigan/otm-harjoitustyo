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
        assertEquals(1002_50, kassa.kassassaRahaa());
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
    
    
    // KORTTIOSTOTESTIT
    
    @Test
    public void kortiltaVeloitetaanOikeaSummaMaukkaasta() {
        Maksukortti kortti = new Maksukortti(5_00);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1_00, kortti.saldo());
    }
    
    @Test
    public void kortiltaVeloitetaanOikeaSummaEdullisesta() {
        Maksukortti kortti = new Maksukortti(5_00);
        kassa.syoEdullisesti(kortti);
        assertEquals(2_50, kortti.saldo());
    }
    
    @Test
    public void kortillaVoiOstaaMaukkaan() {
        Maksukortti kortti = new Maksukortti(5_00);
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kortillaVoiOstaaEdullisen() {
        Maksukortti kortti = new Maksukortti(5_00);
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void maukkaanMyyntiseurantaPaivittyyKorttiostolla() {
        Maksukortti kortti = new Maksukortti(5_00);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenMyyntiseurantaPaivittyyKorttiostolla() {
        Maksukortti kortti = new Maksukortti(5_00);
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukastaEiSaaKunKortillaEiRiitaSaldo() {
        Maksukortti kortti = new Maksukortti(2_00);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void edullistaEiSaaKunKortillaEiRiitaSaldo() {
        Maksukortti kortti = new Maksukortti(2_00);
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void maukastaEiVeloitetaKunKortillaEiRiitaSaldo() {
        Maksukortti kortti = new Maksukortti(2_00);
        kassa.syoMaukkaasti(kortti);
        assertEquals(2_00, kortti.saldo());
    }

    @Test
    public void edullistaEiVeloitetaKunKortillaEiRiitaSaldo() {
        Maksukortti kortti = new Maksukortti(2_00);
        kassa.syoEdullisesti(kortti);
        assertEquals(2_00, kortti.saldo());
    }
    
    @Test
    public void maukkaanMyyntiaEiLisataKunKortinSaldoEiRiita() {
        Maksukortti kortti = new Maksukortti(2_00);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenMyyntiaEiLisataKunKortinSaldoEiRiita() {
        Maksukortti kortti = new Maksukortti(2_00);
        kassa.syoEdullisesti(kortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    // RAHANLATAUS KASSAN KAUTTA
    
    @Test
    public void kortinSaldoKasvaa() {
        Maksukortti kortti = new Maksukortti(2_00);
        kassa.lataaRahaaKortille(kortti, 5_00);
        assertEquals(7_00, kortti.saldo());
    }

    @Test
    public void kassanSaldoKasvaa() {
        Maksukortti kortti = new Maksukortti(2_00);
        kassa.lataaRahaaKortille(kortti, 5_00);
        assertEquals(1005_00, kassa.kassassaRahaa());
    }
    
}
