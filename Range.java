//22D81011040E Miura Ryota 三浦僚太　2024年5月10日

public class Range{
    private double min;
    private double max;
    public void setMin(double x){
        min = x;
    }
    public void setMax(double x){
        max = x;
    }
    public boolean isOK(double v){
        if(min <= v && v < max){
            return true;
        }else{
            return false;
        }
    }
    public String outputRange(){
        return ("min:"+min+" -- max:"+max);
    }
}