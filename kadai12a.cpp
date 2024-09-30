//kadai12a,7/3,22D8101040E,RyotaMiura
#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#include <chrono>
#include <thread>
#include "gnuplot.hpp"
void sleep(double t){
    using namespace std::chrono_literals;
    std::this_thread::sleep_for(t * 1s);
}
struct Point {
    double x;
    double y;
};
Point lerp(Point p, Point q, double t){
    Point a;
    a.x = ((1 - t)*p.x) + (t*q.x);
    a.y = ((1 - t)*p.y) + (t*q.y);
    return a;
}
struct BezierCurve2 {
    Point p0, p1, p2;
    Point position_at(double t){
        return lerp(lerp(p0, p1, t), lerp(p1, p2, t), t);
    }
    std::vector<Point> make_polyline(int num_segments){
        std::vector<Point> lines;
        double t0 = 0;
        double t = (double)1 / num_segments;
        int cnt = 0;
        do{
            lines.push_back(position_at(t0));
            t0 += t;
            cnt++;
        }while(cnt <= num_segments);
        return lines;
    }
};
std::istream& operator >> (std::istream& in, BezierCurve2& p){
    in >> p.p0.x >> p.p0.y >> p.p1.x >> p.p1.y >> p.p2.x >> p.p2.y;
    return in;
}
int main(){
    std::vector<Point> values;
    BezierCurve2 a;
    std::cin >> a;
    Gnuplot plotter; 
    values = a.make_polyline(100);
    for(int i = 0; i <= 250; ++i){
        double t = (double)i / 250;
        plotter.add_polyline(lerp(a.p0, a.p1, t), lerp(a.p1, a.p2, t));
        plotter.add_polyline(a.p0, a.p1, a.p2);
        plotter.add_polyline(values);
        plotter.add_point(a.position_at(t));
        plotter.draw();
        sleep(0.02);
    }
}
