public class DoubleLinkedListPesanan {

    NodePesanan head;
    NodePesanan tail;

    public DoubleLinkedListPesanan() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // === Tambah pesanan di belakang ===
    public void tambahPesanan(Pesanan dataPesanan) {
        NodePesanan nodeBaru = new NodePesanan(dataPesanan);

        if (isEmpty()) {
            head = tail = nodeBaru;
        } else {
            nodeBaru.prev = tail;
            tail.next     = nodeBaru;
            tail          = nodeBaru;
        }
    }

    // === Sorting manual Bubble Sort berdasarkan namaPesanan A-Z ===
    public void sortingPesanan() {
        if (isEmpty() || head == tail) return;

        boolean adaPenukaran;
        do {
            adaPenukaran = false;
            NodePesanan current = head;

            while (current.next != null) {
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    // Tukar referensi data (bukan pointer node-nya)
                    Pesanan temp       = current.data;
                    current.data       = current.next.data;
                    current.next.data  = temp;
                    adaPenukaran       = true;
                }
                current = current.next;
            }
        } while (adaPenukaran);
    }

    // === Tampil laporan pesanan terurut + total pendapatan ===
    public void tampilLaporan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        sortingPesanan();

        int totalPendapatan = 0;

        System.out.println("============================================");
        System.out.println("              LAPORAN PESANAN               ");
        System.out.println("============================================");

        NodePesanan current = head;
        while (current != null) {
            System.out.println("Kode Pesanan : " + current.data.kodePesanan);
            System.out.println("Nama Pesanan : " + current.data.namaPesanan);
            System.out.println("Harga        : Rp " + current.data.harga);
            System.out.println("--------------------------------------------");
            totalPendapatan += current.data.harga;
            current = current.next;
        }

        System.out.println("Total Pendapatan : Rp " + totalPendapatan);
        System.out.println("============================================");
    }
}