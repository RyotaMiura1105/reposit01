//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

public class Player{
    private String name;
    private int level;
    private int hp;

    public Player(String name, int level, int hp){
        this.name = name;
        this.level = level;
        this.hp = hp;
    }
    public Player(String name){
        this(name, 1, 10);;
    }
    public void damage(int p, double r){
        double s = Math.random();
        if(s < r){
            hp -= p;
            if(hp < 0){
                hp = 0;
            }
        }else{
            System.out.println("ダメージを受けない");
        }
    }
    public void damage(int p){
        damage(p, 0.8);
    }
    public String toString(){
        return name+":level"+level+" HP="+hp;
    }
}