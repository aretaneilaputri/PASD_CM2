import java.util.Scanner;

public class MainRoyalDelish {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DoubleLinkedListPembeli daftarAntrian = new DoubleLinkedListPembeli();
        DoubleLinkedListPesanan daftarPesanan = new DoubleLinkedListPesanan();

        daftarAntrian.tambahAntrian("Andi Pratama",   "081234567890");
        daftarAntrian.tambahAntrian("Budi Santoso",   "082345678901");
        daftarAntrian.tambahAntrian("Citra Dewi",     "083456789012");
        daftarAntrian.tambahAntrian("Dian Rahayu",    "084567890123");

        int pilihanMenu;

        do {
            System.out.println();
            System.out.println("============================================");
            System.out.println("         SISTEM ANTRIAN ROYAL DELISH        ");
            System.out.println("============================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian & Input Pesanan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Keluar");
            System.out.println("============================================");
            System.out.print("Pilih Menu : ");
            pilihanMenu = input.nextInt();
            input.nextLine();

            switch (pilihanMenu) {

                case 1: // ---- Tambah Antrian ----
                    System.out.println();
                    System.out.println("===== TAMBAH ANTRIAN =====");
                    System.out.print("Nama Pembeli : ");
                    String namaPembeli = input.nextLine();
                    System.out.print("No. HP       : ");
                    String noHp = input.nextLine();
                    daftarAntrian.tambahAntrian(namaPembeli, noHp);
                    break;

                case 2: // ---- Cetak Antrian ----
                    System.out.println();
                    daftarAntrian.cetakAntrian();
                    System.out.println("Jumlah Antrian : " + daftarAntrian.jumlahAntrian());
                    break;

                case 3: // ---- Hapus Antrian & Input Pesanan ----
                    System.out.println();
                    if (daftarAntrian.isEmpty()) {
                        System.out.println("Antrian kosong, tidak ada pembeli yang bisa dipanggil.");
                        break;
                    }

                    daftarAntrian.cetakAntrian();

                    System.out.print("Masukkan No. Antrian yang dipanggil : ");
                    int nomorDipanggil = input.nextInt();
                    input.nextLine();

                    Pembeli pembeliDilayani = daftarAntrian.hapusAntrian(nomorDipanggil);

                    if (pembeliDilayani != null) {
                        System.out.println();
                        System.out.println("Pembeli dipanggil ke kasir:");
                        System.out.println("Nama : " + pembeliDilayani.namaPembeli);
                        System.out.println();

                        System.out.print("Kode Pesanan : ");
                        int kodePesanan = input.nextInt();
                        input.nextLine();

                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = input.nextLine();

                        System.out.print("Harga        : ");
                        int harga = input.nextInt();
                        input.nextLine();

                        // Buat object Pesanan menggunakan konstruktor
                        Pesanan pesananBaru = new Pesanan(kodePesanan, namaPesanan, harga);
                        daftarPesanan.tambahPesanan(pesananBaru);

                        System.out.println();
                        System.out.println(pembeliDilayani.namaPembeli + " berhasil memesan " + namaPesanan);
                        System.out.println("Sisa Antrian : " + daftarAntrian.jumlahAntrian());
                    }
                    break;

                case 4: // ---- Laporan Pesanan ----
                    System.out.println();
                    daftarPesanan.tampilLaporan();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan Sistem Antrian Royal Delish!");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihanMenu != 5);

        input.close();
    }
}