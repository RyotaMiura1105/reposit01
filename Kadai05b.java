//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

public class Kadai05b{
    public static void main(String[] args){
        Dice2.showSum();

        Dice2 d1 = new Dice2();
        Dice2 d2 = new Dice2(52);
        Dice2 d3 = new Dice2("S");
        Dice2 d4 = new Dice2(3,"L",1000);

        Dice2.showSum();
    }    
}