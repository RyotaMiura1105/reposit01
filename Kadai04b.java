//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Kadai04b{
    public static void main(String[] args){
        Dice2 d1 = new Dice2();
        Dice2 d2 = new Dice2(52);
        Dice2 d3 = new Dice2("S");
        Dice2 d4 = new Dice2(3, "L", 1000);

        System.out.println("d1="+d1.play());
        System.out.println("d2="+d2.play());
        System.out.println("d3="+d3.play());
        System.out.println("d4="+d4.play());
    }
}