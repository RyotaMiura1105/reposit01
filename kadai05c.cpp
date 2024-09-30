/*kadai05c,5/18,22SD8101040E,miura ryota*/
#include <iostream>
#include <cmath>
double pi = std::acos(-1.0);
double R = 20000 / pi;

struct PointOnEarth{
	double lat;
	double lon;
};

std::istream& operator >> (std::istream& in, PointOnEarth& p){
	in >> p.lat >> p.lon;
	return in;
}

double deg_to_rad(double deg){
	return deg * pi / 180;
}

double euclidean_distance(PointOnEarth a, PointOnEarth b){
	double x,y,z;
	double R = 20000 / pi;
	x = R * (std::cos(deg_to_rad(a.lat))*std::cos(deg_to_rad(a.lon)) - std::cos(deg_to_rad(b.lat))*std::cos(deg_to_rad(b.lon)));
	y = R * (std::cos(deg_to_rad(a.lat))*std::sin(deg_to_rad(a.lon)) - std::cos(deg_to_rad(b.lat))*std::sin(deg_to_rad(b.lon)));
	z = R * (std::sin(deg_to_rad(a.lat)) - std::sin(deg_to_rad(b.lat)));
	return std::hypot(x,y,z);
}

double geodesic_distance(PointOnEarth a, PointOnEarth b){
	double l = euclidean_distance(a,b);
	double y = 2 * std::asin(l/(2*R));
	return y * R;
}

int main(){
	PointOnEarth a,b;
	std::cout << "Enter two points in the Earth:\n";
	std::cin >> a >> b;
	std::cout << "Geodesic distance: " << geodesic_distance(a,b) << " km\n";
}
/*
 g++ -Wall -o kadai05c kadai05c.cpp
 ./kadai05c
 Enter two points in the Earth:
35.65861 139.74556
34.65254 135.50632
Geodesic distance: 400.964 km
 */
	

