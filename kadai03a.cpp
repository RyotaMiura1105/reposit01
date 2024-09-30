/*kadai03a,4/24,22D8101040E,RyotaMiura*/
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
int main(){
    Circle a;
    Point p;
    std::cout << "Enter a circle: \n";
    std::cin >> a.center.x >> a.center.y >> a.radius;
    std::cout << "enter a point: \n";
    std::cin  >> p.x >> p.y;
    std::cout << "contains?: ";
    std::cout << std::boolalpha;
    std::cout << a.contains(p);
}