package com.bilgeadam.sayisalloto;

import java.util.Arrays;
import java.util.Random;

public class SayisalLoto_array {

    // static değişkene, obje oluşturmadan
    // Class_adı.değişken diye erişebiliyoruz.
    private static final int MAX_SAYI = 90;
    private static final int KAC_SAYI = 6;


    Random rnd = new Random();


    public int sayiGetir()
    {
        // nextInt(90) metodu 0-89 arası üretir.
        // 1'den başlasın diye 1 ekliyoruz.
        return rnd.nextInt(MAX_SAYI)+1;
    }

    public boolean arraydeVarmi(int[] sayilar, int sayi)
    {
        // binarySearch ile arayacağız.
        // binarySearch kullanmanın şartı, arrayin sıralı olması

        // gelen array'i sıralıyorum.
        Arrays.sort(sayilar);

        int sonuc = Arrays.binarySearch(sayilar, sayi);

        if(sonuc>=0)
            return true;
        else
            return false;


    }

    public void testArraydeVarmı()
    {
        int sayilar[] = {13, 45, 67, -4, 41, 70};

        int sayi = 68;

        boolean sonuc = arraydeVarmi(sayilar, sayi);

        if (sonuc==true)
            System.out.println("Arrayde var!");
        else
            System.out.println("Arrayde yok!");
    }

    public static void main(String[] args) {

        // Yeni Çılgın Sayısal Loto'ya uygun,
        // 90 sayıdan 6 tane seçeceğiz.
        //
        // https://www.millipiyangoonline.com/sayisal-loto/sonuclar

        SayisalLoto_array loto = new SayisalLoto_array();

        // Sayıları tutacağımız bir array tanımlıyoruz.
        int sayilar[] = new int[KAC_SAYI];

        // Döngüyle array'a rastgele sayıları atalım.
        for (int i = 0; i < sayilar.length; i++) {

            int rastgeleSayi = loto.sayiGetir();

            // rastgele sayı arrayde varsa döngüyle tekrar sayı alınacak.
            // arrayde olmayan sayı bulana kadar döngüden çıkamaz.
            boolean sonuc = loto.arraydeVarmi(sayilar, rastgeleSayi);
            while(sonuc == true)
            {
                rastgeleSayi = loto.sayiGetir();
                sonuc = loto.arraydeVarmi(sayilar, rastgeleSayi);
            }

            // Hep arrayin ilk elemanına yazalım rastgele sayıyı
            // Çünkü sıralanınca sayı sonlara gidiyor.
            sayilar[0] = rastgeleSayi;

            // 6. sayıyı sıfır indekse yazınca, tekrar sıralanması için bunu ekledik.
            Arrays.sort(sayilar);
        }

        // array yazdır
        for (int i = 0; i < sayilar.length; i++) {

            if(i == sayilar.length-1)
                System.out.print(sayilar[i]);
            else
                System.out.print(sayilar[i]+"-");
        }



        //loto.testArraydeVarmı();





    }
}