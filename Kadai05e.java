//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

class Dice{
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

public class Kadai05e{
    public static void main(String[] args){
        Dice d = new Dice();
        // d.n = 1;
        // System.out.println("n="+d.n);
        d.setN(1);
        System.out.println("n="+d.getN());
    }
}

// Kadai05e.java:3: エラー: クラス Diceはpublicであり、ファイルDice.java
// で宣言する必要があります
// public class Dice{
//        ^
// エラー1個