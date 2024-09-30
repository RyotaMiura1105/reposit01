/*22D8101040E,4/20,RyotaMiura,kadai02x*/
#include <iostream>
#include <vector>
struct MinmaxIndexResult{
	int min_idx;
	int max_idx;
};
MinmaxIndexResult minmax_index(std::vector<double>& values){
	int n = values.size();
	MinmaxIndexResult x;
	x.min_idx = 0;
	x.max_idx = 0;
	for(int i = 1; i < n; i++){
		if(values[x.min_idx] > values[i]){
			x.min_idx = i;
		}
		if(values[x.max_idx] <= values[i]){
			x.max_idx = i;
		}
		}
	return x;
}
int main(){
	std::vector<double> values;
	double tmp;
	int n;
	std::cout << "Enter the number of elements:\n";
	std::cin >> n;
	std::cout << "Enter real numbers:\n";
	for(int i = 0; i < n; i++){
		std::cin >> tmp;
		values.push_back(tmp);
	}
	MinmaxIndexResult x = minmax_index(values);
	std::cout << "min index: " << x.min_idx << "\nmax index: " << x.max_idx << "\n";
}
