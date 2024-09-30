//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

public class Kadai05a{
    public static void main(String[] args){
        Player taro = new Player("Taro");
        System.out.println(taro);
        Player Jiro = new Player("Jiro", 5, 30);
        System.out.println(Jiro);
        System.out.println("敵の攻撃");
        Jiro.damage(8);
        System.out.println(Jiro);
        System.out.println("敵の攻撃. 痛恨の一撃");
        Jiro.damage(50);
        System.out.println(Jiro);
    } 
}