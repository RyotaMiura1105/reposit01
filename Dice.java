//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Dice{
    private int n;
    private String size;

    public void play(){
        n = (int)(Math.random()*6)+1;
    }
    public int getN(){
        return n;
    }
    public String getSize(){
        return size;
    }
    public void setN(int m){
        n = m;
    }
    public void setSize(String s){
        size = s;
    }
}