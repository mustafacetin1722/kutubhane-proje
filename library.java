import java.util.Locale;
import java.util.Scanner;

public class library {

    private static final int MAX_ITEMS=1000;
    public static String[] baslik=new String[MAX_ITEMS];
    public static String[] yazar=new String[MAX_ITEMS];
    public static String[] isbn=new String[MAX_ITEMS];
    public static int[] miktar=new int[MAX_ITEMS];
    public static String[] patronAdi=new String[MAX_ITEMS];
    public static int kitapSayisi=0;



    public static void addBook(String kitapBaslik,String kitapYazar,String kitapISBN,int kitapMiktar){
        baslik[kitapSayisi]=kitapBaslik;
        yazar[kitapSayisi]=kitapYazar;
        isbn[kitapSayisi]=kitapISBN;
        miktar[kitapSayisi]=kitapMiktar;
        kitapSayisi++;
    }






    public static void checkOutBook(String ISBN,String patron,int kitapMiktari){
       for (int i=0; i<kitapSayisi; i++){
           if (isbn[i].equals(ISBN)){
               if ( miktar[i]>=kitapMiktari){
                   miktar[i]-=kitapMiktari;
                   patronAdi[i]=patron;
                   System.out.println("Patron : "+patron);
                   System.out.println("Alınan Kitap : "+kitapMiktari);
               }
               else {
                   System.out.println("Yetersiz kitap miktarı veya geçersiz işlem.");
               }
           }
        else {
                System.out.println("Geçersiz işlem.");
            }
        }
    }





    public static void returnBook(String ISBN,String patron,int kitapIadeMiktari){
        for (int i=0; i<kitapSayisi; i++){
            if (isbn[i].equals(ISBN)){
                miktar[i]+=kitapIadeMiktari;
                System.out.println(kitapIadeMiktari+" kitap iade edildi.");
                System.out.println("Kullanıcı : "+patron);
            }
        else {
            System.out.println("Kitap bulunmamaktadır.");
        }
    }
    }



    public static void generateReports(){
        int toplamKitap=0;
        for (int i=0; i<kitapSayisi; i++){
            toplamKitap+=miktar[i];
        }
        System.out.println("Toplam kitap sayısı : "+toplamKitap);
        // DENKLEM KURAMADIM
        /*int mevcutKitap=0;
        for (int i=0; i<yazar.length; i++){

        }
        System.out.println("Toplam kitap sayısı : ");*/
    }




git 
    public static void viewAvailableBooks(){
        for (int i=0; i<kitapSayisi; i++){
            System.out.println("Başlık: " + baslik[i] +
                    ", Yazar: " + yazar[i] +
                    ", ISBN: " + isbn[i] +
                    ", Miktar: " + miktar[i]);
        }
    }






    public static void searchBooks(String aranacakKitap){

   for (int i=0; i<kitapSayisi; i++){
       if (isbn[i].equals(aranacakKitap) || yazar[i].toLowerCase().contains(aranacakKitap.toLowerCase()) || baslik[i].toLowerCase().contains(aranacakKitap.toLowerCase())){
       System.out.println("Başlık: " + baslik[i] +", Yazar: " + yazar[i] +", ISBN: " + isbn[i] +", Miktar: " + miktar[i]);
       }
     }
   }




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String islemler="1. Kitap Ekle\n"+
                        "2. Kitap Alma\n"+
                        "3. Kitap İade Et\n"+
                        "4. Mevcut Kitapları Görüntüle\n"+
                        "5. Kitap Ara\n"+
                        "6. Rapor Oluştur\n"+
                        "0. Çıkış\n";

        while (true){

            System.out.println(islemler);
            System.out.print("Lütfen bir seçenek girin: ");
            int secim=scanner.nextInt();
            scanner.nextLine();


            switch (secim){
                case 1:
                    System.out.println();
                    System.out.println("Kitap başlığını giriniz.");
                    String baslik=scanner.nextLine();
                    System.out.println("Yazar ismini giriniz.");
                    String yazar=scanner.nextLine();
                    System.out.println("ISBN kodunu giriniz.");
                    String isbn= scanner.nextLine();
                    System.out.println("Kitap miktarını giriniz.");
                    int miktar=scanner.nextInt();
                    scanner.nextLine();
                    addBook(baslik,yazar,isbn,miktar);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Almak istedipiniz kitabın ISBN kodunu giriniz.");
                    String isbn2=scanner.nextLine();
                    System.out.println("Kullanıcı ismini giriniz.");
                    String patron=scanner.nextLine();
                    System.out.println("Alınıcak kitap sayısı.");
                    int alinanKitap=scanner.nextInt();
                    checkOutBook(isbn2,patron,alinanKitap);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("İade istedipiniz kitabın ISBN kodunu giriniz.");
                    String isbn3=scanner.nextLine();
                    System.out.println("Kullanıcı ismini giriniz.");
                    String patron1=scanner.nextLine();
                    System.out.println("İade kitap sayısı.");
                    int iadeKitap=scanner.nextInt();
                    returnBook(isbn3,patron1,iadeKitap);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    viewAvailableBooks();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Aramak istediğiniz kitabın ISBN,Yazar veya Başlığını yazaınız.");
                    String isbn1= scanner.nextLine();
                    System.out.println("Kitap aranıyor...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    searchBooks(isbn1);
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    generateReports();
                    System.out.println();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz işlem...");
                    break;
            }
        }

    }
}