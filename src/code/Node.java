package code;

public class Node{
    private int dStart, dEnd, total;
    private boolean start, end, obstacle, open, closed, path;
    private int x, y;
    private Node prev; // p1,p2,p3,p4,p5,p6,p7,p8;

    public Node(int dEnd, int x, int y){
        this.dEnd = dEnd;
        dStart = 190;
        this.x = x;
        this.y = y;
    }
    public int getdEnd() {
        return dEnd;
    }
    public int getdStart() {
        return dStart;
    }
    public Node getPrev() {
        return prev;
    }
    public int getTotal() {
        return total;
    }
    public void setdEnd(int dEnd) {
        this.dEnd = dEnd;
    }
    public void setdStart(int dStart) {
        this.dStart = dStart;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public void setEnd(boolean end) {
        this.end = end;
    }
    public void setStart(boolean start) {
        this.start = start;
    }
    public boolean getEnd(){
        return end;
    }
    public boolean getStart(){
        return start;
    }
    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }
    public boolean getObstacle()
    {
        return obstacle;
    }
    public void setTotal()
    {
        total = dStart + dEnd;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean getClosed()
    {
        return closed;
    }
    public boolean getOpen()
    {
        return open;
    }
    public void setPath(boolean path) {
        this.path = path;
    }
    public boolean getPath(){
        return path;
    }
    

/*    public Node getP1() {
        return p1;
    }
    public Node getP2() {
        return p2;
    }
    public Node getP3() {
        return p3;
    }
    public Node getP4() {
        return p4;
    }
    public Node getP5() {
        return p5;
    }
    public Node getP6() {
        return p6;
    }
    public Node getP7() {
        return p7;
    }
    public Node getP8() {
        return p8;
    }
    public void setP1(Node p1) {
        this.p1 = p1;
    }
    public void setP2(Node p2) {
        this.p2 = p2;
    }
    public void setP3(Node p3) {
        this.p3 = p3;
    }
    public void setP4(Node p4) {
        this.p4 = p4;
    }
    public void setP5(Node p5) {
        this.p5 = p5;
    }
    public void setP6(Node p6) {
        this.p6 = p6;
    }
    public void setP7(Node p7) {
        this.p7 = p7;
    }
    public void setP8(Node p8) {
        this.p8 = p8;
    }*/
}
