//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Kadai04a{
    public static void main(String[] args){
        Dice d = new Dice();
        // d.n = 1;
        // System.out.println("n="+d.n);
        d.setN(1);
        System.out.println("n="+d.getN());
    }
}

// Kadai04a.java:6: エラー: nはDiceでprivateアクセスされます
//         d.n = 1;
//          ^
// Kadai04a.java:7: エラー: nはDiceでprivateアクセスされます
//         System.out.println("n="+d.n);
//                                  ^
// エラー2個

//n=1

