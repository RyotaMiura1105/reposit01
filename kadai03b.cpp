/*kadai03b,4/24.22D8101040E,RyotaMiura*/
#include <iostream>
#include <cmath>
struct Point{
    double x;
    double y;
};
struct Ractangle{
    Point min_pt;
    Point max_pt;
    Point center(Point max_pt,Point min_pt){
        Point mid;
        mid.x = (max_pt.x - min_pt.x) / 2;
        mid.y = (max_pt.y - min_pt.y) / 2;
        return mid;
    }
    double area(Point max_pt,Point min_pt){
        return (max_pt.x - min_pt.x)*(max_pt.y - min_pt.y);
    }
    void squarify(Ractangle* s){
        double a = std::sqrt(area(max_pt,min_pt));
        Point c = center(max_pt,min_pt);
        s.max_pt.x = c.x + a;
        s.max_pt.y = c.y + a;
        s.min_pt.x = c.x - a;
        s.min_pt.y = c.y - a;
    }
};
int main(){
    Ractangle s;
    std::cout << "Enter a rectangle: \n";
    std::cin >> s.max_pt.x >> s.max_pt.y >> s.min_pt.x >> s.min_pt.y;
    s.squarify(&s);
    std::cout << "min_pt: (" << s.min_pt.x << ", " <<  s.min_pt.y << ")\n";
    std::cout << "max_pt: (" << s.max_pt.x << ", " <<  s.max_pt.y << ")\n";
}