//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Kadai04f{
    public static void main(String[] args){
        Range r = new Range();
        r.setMin(18.5);
        r.setMax(25.0);
        HealthRecord[] health = new HealthRecord[4];
        health[0] = new HealthRecord(157.0, 56.0);
        health[1] = new HealthRecord(185.0);
        health[2] = new HealthRecord("鈴木", 165.5, 75.5);
        health[3] = new HealthRecord();
        for(int i=0; i<4; i++){
            if(r.isOK(health[i].bmi())){
                System.out.println(health[i]+" --- O");
            }else{
                System.out.println(health[i]+" --- X");
            }
            
        }
    }
}