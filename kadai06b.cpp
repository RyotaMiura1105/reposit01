/*kadai06b,5/30,22D8101040E,RyotaMiura*/
#include <iostream>
#include <vector>
struct Point{
    double x;
    double y;
};
std::istream& operator >> (std::istream& in, Point& p){
	in >> p.x >> p.y;
	return in;
}
std::ostream& operator << (std::ostream& out, Point p){
	out << p.x << ", " <<  p.y;
	return out;
}
Point centroid(std::vector<Point>& points){
    int n = points.size();
    double sumx = 0;
    double sumy = 0;
    Point c;
    for(auto p : points){
        sumx += p.x;
        sumy += p.y;
    }
    c.x = sumx / n;
    c.y = sumy / n;
    return c;
}
int main(){
    std::vector<Point> points;
    int n;
    std::cout << "Enter the number of points:\n";
    std::cin >> n;
    points.resize(n);
    std::cout << "Enter the numbers:\n";
    for(Point& p : points){
        std::cin >> p;
    }
    std::cout << "centroid: (" << centroid(points) << ")\n";
}
/*
g++ -o kadai06b kadai06b.cpp
./kadai06b
Enter the number of points:
7
Enter the numbers:
0 0  1 4  2 2  3 6  5 3  9 0  9 6
centroid: (4.14286, 3)
*/