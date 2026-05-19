public class Pembeli {

    // Atribut (+ nomorAntrian sebagai tambahan)
    int    nomorAntrian;
    String namaPembeli;
    String noHp;

    // KonstruktorPembeli(String b, String c)
    // + nomorAntrian ditambahkan agar bisa dibuat otomatis
    public Pembeli(int nomorAntrian, String namaPembeli, String noHp) {
        this.nomorAntrian = nomorAntrian;
        this.namaPembeli  = namaPembeli;
        this.noHp         = noHp;
    }
}