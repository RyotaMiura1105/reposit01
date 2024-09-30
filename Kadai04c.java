//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Kadai04c{
    public static void main(String[] args){
        HealthRecord h1 = new HealthRecord(157.0, 56.0);
        HealthRecord h2 = new HealthRecord(185.0);
        HealthRecord h3 = new HealthRecord("鈴木", 165.5, 75.5);
        HealthRecord h4 = new HealthRecord();

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
    }
}