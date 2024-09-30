/*kadai03c,4/24,22D8101040E,RyotaMiura*/
#include <iostream>
#include <cmath>
struct Point{
    double x;
    double y;
};
double distance(Point a, Point b){
    return std::sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
}
struct Circle{
    Point center;
    double radius;
    bool contains(Point p){
        if(distance(center,p) <= radius) {
            return true;
        }else{
            return false;
        }
    }
};
struct Ractangle{
    Point min_pt;
    Point max_pt;
};
int main(){
    Circle a;
    Ractangle s;
    Point b,c,d;
    std::cout << "Enter a circle: \n";
    std::cin >> a.center.x >> a.center.y >> a.radius;
    std::cout << "Enter a rectangle: \n";
    std::cin >> s.max_pt.x >> s.max_pt.y >> s.min_pt.x >> s.min_pt.y;
    c.x = s.max_pt.x;
    c.y = s.min_pt.y;
    d.x = s.min_pt.x;
    d.y = s.max_pt.y;
    if(distance(a.center,b) < distance(a.center,s.min_pt)){
        b = s.max_pt;
    }else if(distance(a.center,b)> (distance(a.center,c))){
        b = c;
    }else if(distance(a.center,b)> (distance(a.center,d))){
        b = d;
    }
    std::cout << "intersect?: ";
    std::cout << std::boolalpha;
    std::cout << a.contains(b);
}