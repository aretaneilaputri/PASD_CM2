public class DoubleLinkedListPembeli {

    NodePembeli head;
    NodePembeli tail;
    int         nomorOtomatis;

    public DoubleLinkedListPembeli() {
        head           = null;
        tail           = null;
        nomorOtomatis  = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // === Tambah antrian di belakang, nomor antrian otomatis ===
    public void tambahAntrian(String namaPembeli, String noHp) {
        nomorOtomatis++;
        Pembeli dataBaru = new Pembeli(nomorOtomatis, namaPembeli, noHp);
        NodePembeli nodeBaru = new NodePembeli(dataBaru);

        if (isEmpty()) {
            head = tail = nodeBaru;
        } else {
            nodeBaru.prev = tail;
            tail.next     = nodeBaru;
            tail          = nodeBaru;
        }

        System.out.println("Antrian berhasil ditambahkan! Nomor Antrian: " + nomorOtomatis);
    }

    // === Cetak seluruh antrian ===
    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong.");
            return;
        }

        System.out.println("============================================");
        System.out.println("              DAFTAR ANTRIAN                ");
        System.out.println("============================================");

        NodePembeli current = head;
        while (current != null) {
            System.out.println("No. Antrian  : " + current.data.nomorAntrian);
            System.out.println("Nama Pembeli : " + current.data.namaPembeli);
            System.out.println("No. HP       : " + current.data.noHp);
            System.out.println("--------------------------------------------");
            current = current.next;
        }
    }

    // === Hapus antrian by nomorAntrian ===
    public Pembeli hapusAntrian(int nomorAntrian) {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }

        // Cari node dengan nomorAntrian yang diminta
        NodePembeli current = head;
        while (current != null && current.data.nomorAntrian != nomorAntrian) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Nomor antrian " + nomorAntrian + " tidak ditemukan.");
            return null;
        }

        // Lepas sambungan node dari linked list
        if (current.prev != null) current.prev.next = current.next;
        else                       head              = current.next;

        if (current.next != null) current.next.prev = current.prev;
        else                       tail              = current.prev;

        current.prev = null;
        current.next = null;

        return current.data;
    }

    // === Hitung jumlah antrian yang tersisa ===
    public int jumlahAntrian() {
        int jumlah = 0;
        NodePembeli current = head;
        while (current != null) {
            jumlah++;
            current = current.next;
        }
        return jumlah;
    }
}