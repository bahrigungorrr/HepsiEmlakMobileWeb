package com.hepsiemlak;

import org.junit.Test;

public class HepsiEmlakTestCase extends HepsiEmlakCase {
    @Test
    public void mobileSatilikTest() throws InterruptedException {
        Thread.sleep(3000);
        HepsiEmlakMobileSatilik();
        Thread.sleep(3000);
    }

    @Test
    public void mobileKiralikTest() throws InterruptedException {
        Thread.sleep(3000);
        HepsiEmlakMobileKiralik();
    }

}
