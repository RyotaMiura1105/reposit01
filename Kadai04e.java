//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Kadai04e{
    public static void main(String[] args){
        Range r = new Range();
        r.setMax(250.0);
        r.setMin(50.0);
        double a = Double.parseDouble(args[0]);
        if(r.isOK(a)){
            System.out.println("範囲内");
        }else{
            System.out.println("範囲外");
        }
    }
}

// java Kadai04e 75.0
// 範囲内
