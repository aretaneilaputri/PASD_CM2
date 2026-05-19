public class Pesanan {

    // Atribut
    int    kodePesanan;
    String namaPesanan;
    int    harga;
    String namaPemesan;

    // Konstruktor Pesanan(int a, String b, int d)
    public Pesanan(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga       = harga;
    }
}