/*kadai06a,5/30,22D8101040E,RyotaMiura*/
#include <iostream>
#include <vector>
#include <cmath>
void mean_and_sigma(std::vector<int>& scores, double& mean, double& sigma){
    int sum1 = 0;
    int sum2 = 0;
    int n = scores.size();
    for(auto x : scores){
        sum1 += x;
    }
    mean = (double)sum1 / n;
    for(auto x : scores){
        sum2 += std::pow(x - mean, 2);
    }
    sigma = std::sqrt((double)sum2 / n);
}
int main(){
    int n;
    std::vector<int> scores;
    double mean,sigma;
    int tmp;
    std::cout << "Enter the number of scores:\n";
    std::cin >> n;
    std::cout << "Enter the scores:\n";
    for(int i = 0; i < n; i++){
        std::cin >> tmp;
        scores.push_back(tmp);
    }
    mean_and_sigma(scores,mean,sigma);
    std::cout << "Conversion results:\n";
    for(auto x : scores){
        std::cout << "score " << x << " => T-score " << 50 + 10 * ((x - mean) / sigma) << "\n";
    }
}
/*
g++ -o kadai06a kadai06a.cpp
./kadai06a
Enter the number of scores:
3
Enter the scores:
90 85 95
Conversion results:
score 90 => T-score 50
score 85 => T-score 37.7526
score 95 => T-score 62.2474
*/