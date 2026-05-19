public class NodePembeli {

    Pembeli     data;
    NodePembeli prev;
    NodePembeli next;

    public NodePembeli(Pembeli data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}