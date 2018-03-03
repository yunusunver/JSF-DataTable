
package com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="yb")
@SessionScoped
public class YonetimliBean  implements Serializable{
    String adiSoyadi;
    String numarasi;
    BigDecimal maasi;
    int yasi;
   
    private static final ArrayList<Personel> personelListesi=new ArrayList<Personel>(Arrays.asList(
        new Personel("123", "Ali", new BigDecimal("1999.00"), 23),
        new Personel("345", "Veli", new BigDecimal("1299.00"), 30),
        new Personel("234", "Mehmet", new BigDecimal("83999.00"),34),
        new Personel("634", "Kemal", new BigDecimal("43999.00"), 24)
    )
    );
         
    
    
    public ArrayList<Personel> getPersonelListesi(){
        return personelListesi;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getNumarasi() {
        return numarasi;
    }

    public void setNumarasi(String numarasi) {
        this.numarasi = numarasi;
    }

    public BigDecimal getMaasi() {
        return maasi;
    }

    public void setMaasi(BigDecimal maasi) {
        this.maasi = maasi;
    }

    public int getYasi() {
        return yasi;
    }

    public void setYasi(int yasi) {
        this.yasi = yasi;
    }
    
    public String kayitEkle(){
        Personel personel=new Personel(this.numarasi,this.adiSoyadi,this.maasi,this.yasi);
        personelListesi.add(personel);
        this.numarasi="";
        this.adiSoyadi="";
        this.maasi=null;
        this.yasi=0;
        return null;
    }
    
    public String kayitSil(Personel personel){
        personelListesi.remove(personel);
        return null;
    }
    
    public String kayitDuzenle(Personel personel){
        personel.setDuzenle(true);
        return null;
    }
    
    public String degisikligiKaydet(){
        for(Personel personel:personelListesi){
            personel.setDuzenle(false);
        }
        return null;
    }
    
    private boolean artanSiralama=true;
    
    public String siralaPersonelAdiSoyadi(){
        
        if (artanSiralama) {
            Collections.sort(personelListesi, new Comparator<Personel>(){
                @Override
                public int compare(Personel o1,Personel o2){
                    return o1.getAdiSoyadi().compareTo(o2.getAdiSoyadi());
                }
            });
            artanSiralama=false;
        }
        else{
             Collections.sort(personelListesi, new Comparator<Personel>(){
                @Override
                public int compare(Personel o1,Personel o2){
                    return o2.getAdiSoyadi().compareTo(o1.getAdiSoyadi());
                }
            });
            artanSiralama=true;
        }
        return null;
    }
}
