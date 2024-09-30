//22D81011040E Miura Ryota 三浦僚太　2024年5月10日
public class HealthRecord{
    private String name;
    private double height;
    private double weight;

    public HealthRecord(String name, double height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
    public HealthRecord(double height, double weight){
        this("データなし", height, weight);
    }
    public HealthRecord(double height){
        this("データなし", height, 60);
    }
    public HealthRecord(){
        this("データなし", 170, 60);
    }

    public String toString(){
        return name+"/"+height+"/"+weight;
    }

    public double bmi(){
        return 10000*weight/Math.pow(height, 2);
    }
}