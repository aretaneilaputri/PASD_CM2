public class NodePesanan {

    Pesanan     data;
    NodePesanan prev;
    NodePesanan next;

    public NodePesanan(Pesanan data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}