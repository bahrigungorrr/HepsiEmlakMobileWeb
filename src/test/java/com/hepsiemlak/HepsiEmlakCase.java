package com.hepsiemlak;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;

public class HepsiEmlakCase extends BasePage {
    public void HepsiEmlakMobileSatilik() throws InterruptedException {
        BasicConfigurator.configure();
        log.info("Satılık testi başlıyor...");
        //Çerez kapama
        webElementiBul("//button[@class='btn btn-red btn-large']");
        webelementiBekle(3);
        log.info("Çerez kapatıldı.");
        //Satilik tiklama
        webElementiBul("//div[@class='link-sliding']/a[@href='/satilik']");
        webelementiBekle(3);
        log.info("Satılık tıklandı.");
        //Filtreleme tiklama
        webElementiBul("//span[@class='val']");
        webelementiBekle(2);
        log.info("Filtreleme açıldı.");
        //İl seçme
        webElementDropDown("//div[@class='city']/select", 3);
        webelementiBekle(2);
        //İzmir seçme
        webElementiBul("//div[@class='city']/select/option[count(preceding-sibling::option)=3]");
        webelementiBekle(2);
        log.info("İl seçildi.");
        //İlçe seçme
        webElementiBul("//section[@class='location']/section[count(preceding-sibling::section)=0]");
        webelementiBekle(2);
        //Bornova seçme
        webElementiBul("//div[@class='district-list-dialog']/li[count(preceding-sibling::li)=6]/label");
        webelementiBekle(2);
        log.info("İlçe seçildi.");
        //Uygula Bas
        webElementiBul("//button[@data-v-1852f1f2][@class='btn btn-red filter-close']");
        webelementiBekle(2);
        webElementiBul("//button[@data-v-1852f1f2][@class='btn btn-red filter-close']");
        log.info("Uygulandı.");
        //işyeri seç
        webElementiBuluncaTikla("//label[@for='category1']");
        webElementiBul("//label[@for='category1']");
        webelementiBekle(3);
        log.info("İş yeri filtresi seçildi.");
        //min fiyat gir
        webElementineGonder("//div[@class='wrapper']/section[count(preceding-sibling::section)=1]/div/div[count(preceding-sibling::div)=0]/input", "100000");
        webelementiBekle(2);
        log.info("Minimum fiyat değeri filtresi girildi.");
        //maks fiyat gir
        webElementineGonder("//div[@class='wrapper']/section[count(preceding-sibling::section)=1]/div/div[count(preceding-sibling::div)=1]/input", "2000000");
        webelementiBekle(1);
        log.info("Maximum fiyat değeri filtresi girildi.");
        //Bina yaşına git ve tıkla
        webElementiBuluncaTikla("//section[@class='building-age']/section");
        webelementiBekle(1);
        webElementiBul("//section[@class='building-age']/section/div");
        log.info("");
        //Sıfır bina
        webElementiBul("//div[@class='dropdown-wrap']/ul[@class='list']/li[count(preceding-sibling::li)=0]/label");
        //1-5
        webElementiBul("//div[@class='dropdown-wrap']/ul[@class='list']/li[count(preceding-sibling::li)=1]/label");
        //6-10
        webElementiBul("//div[@class='dropdown-wrap']/ul[@class='list']/li[count(preceding-sibling::li)=2]/label");
        webelementiBekle(2);
        //Uygula tikla
        webElementiBul("//div[@id='dropdown-lightbox-filter']/button[@class='btn btn-red filter-close']");
        webelementiBekle(2);
        log.info("Bina yaşı filtresi seçilip; Sıfır bina, 1-5 , 6-10 yaşları seçildi.");
        //Sonuçlari listele
        webElementiBul("//div[@class='filter-button']/button[@class='btn btn-red cardShadow3 get-result']");
        webelementiBekle(2);
        log.info("Sonuçlar listelendi.");
        //Filtrele
        webElementiBul("//span[@class='val']");
        webelementiBekle(2);
        //kontroller
        log.info("Filtre Kontrolleri başladı...");
        webElementControl("6-10", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=0]/div/div/p")).getText());
        webElementControl("1-5", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=1]/div/div/p")).getText());
        webElementControl("Sıfır Bina", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=2]/div/div/p")).getText());
        moveToElement("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=2]/div/div/p");
        webElementControl("2.000.000 TL", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=3]/div/div/p")).getText());
        webelementiBekle(1);

        webElementControl("100.000 TL", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=4]/div/div/p")).getAttribute("innerHTML"));
        webElementControl("İşyeri", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=5]/div/div/p")).getAttribute("innerHTML"));
        webElementControl("Satılık", webDriver.findElement(By.
                xpath("//div[@class='swiper-wrapper']/div[count(preceding-sibling::div)=6]/div/div/p")).getAttribute("innerHTML"));
        log.info("Filtre kontrolleri sonuçlandı.");
        log.info("Test bitti.");

    }

    public void HepsiEmlakMobileKiralik() throws InterruptedException {
        BasicConfigurator.configure();
        //Çerez kapama
        log.info("Kiralık testi başlıyor...");
        webElementiBul("//button[@class='btn btn-red btn-large']");
        webelementiBekle(2);
        log.info("Çerez kapatıldı.");
        //Kiralık Tıklama
        webElementiBul("//span[@class='he-svg left-icon he-svg--kiralik']");
        webelementiBekle(2);
        log.info("Kiralık buttonuna tıklandı");
        //Filtrele tıklama
        webElementiBul("//span[@class='val']");
        webelementiBekle(2);
        log.info("Filtreleme işlemi başıyor...");
        //İl seçme
        webElementDropDown("//div[@class='city']/select", 2);
        log.info("İl seçildi.");
        webelementiBekle(1);
        //İlçe seçme
        webElementiBul("//section[@class='location']/section[count(preceding-sibling::section)=0]");
        webElementiBul("//div[@class='district-list-dialog']/li[count(preceding-sibling::li)=6]/label");
        webelementiBekle(2);
        log.info("İlçe seçildi.");
        //Uygula Bas
        webElementiBul("//button[@data-v-1852f1f2][@class='btn btn-red filter-close']");
        webelementiBekle(2);
        webElementiBul("//button[@data-v-1852f1f2][@class='btn btn-red filter-close']");
        webelementiBekle(2);
        log.info("Uygulandı.");
        //Oda sayısı filtresine gitme ve tıklama
        log.info("Oda sayısı seçiliyor...");
        webElementiBuluncaTikla("//section[@class='room-type']/section/div");
        webelementiBekle(1);
        webElementiBul("//section[@class='room-type']/section/div");
        webelementiBekle(1);
        //2+1 seçme
        webElementiBul("//div[@class='dropdown-wrap']/ul[@class='list']/li[count(preceding-sibling::li)=2]/label");
        webelementiBekle(2);
        //Uygulaya basma
        webElementiBul("//div[@id='dropdown-lightbox-filter']/button[@class='btn btn-red filter-close']");
        webelementiBekle(2);
        //Site içinde filtresine gidip tıklma
        log.info("Site içinde filtresi seçiliyor.");
        webElementiBuluncaTikla("//section[@class='within-site d-flex']/label");
        webelementiBekle(1);
        webElementiBul("//section[@class='within-site d-flex']/label");
        webelementiBekle(1);
        //Sonuçları Göster tıklama
        log.info("Sonuçlar gösteriliyor...");
        webElementiBul("//div[@class='filter-button']/button[@class='btn btn-red cardShadow3 get-result']");
        webelementiBekle(2);
        //3. ilanı seçme
        log.info("3. ilan seçiliyor.");
        webElementiBuluncaTikla("//div[@class='reality-list']/div[count(preceding-sibling::div)=2]/div[@class='inner']/div[count(preceding-sibling::div)=0]");
        webelementiBekle(2);
        webElementiBul("//div[@class='reality-list']/div[count(preceding-sibling::div)=2]/div[@class='inner']/div[count(preceding-sibling::div)=0]/div/a");
        webelementiBekle(3);
        //İlan Sahibi ara
        //Telefon numarası Kontrol
        webElementControl("+905052319151", webDriver.findElement(By.
                xpath("//div[@class='call-owner sticky-owner-call']/a/span[count(preceding-sibling::span)=1]")).getAttribute("innerHTML"));
        log.info("Telefon numarası doğru.");
        isValidPhoneNumb("+905052319151");
    }


}
