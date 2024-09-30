/*kadai02a,4/17,22D8101040E,RyotaMiura*/
#include <iostream>
#include <cmath>
bool is_pythagorean_prime(int x, int* ptr_a, int* ptr_b){
    int b,n;
    for(int i = 2; i < x; i++){
                if(x % i == 0){
                    return false;
                }
            }
    for(int i = 1; i < x; i++){
        b = x*x - i*i;
        n = sqrt(b);
        if(n*n == b){
            *ptr_a = i;
            *ptr_b = n; 
            return true;
        }
    }
    return false;
}
int main(){
    int a,b,n;
    std::cout << "Enter a positive integer:\n";
    std::cin >> n;
    if(is_pythagorean_prime(n,&a,&b)){
    std::cout << n << " is a Pythagorean prime.\n";
    std::cout << n << "\u00B2 = " << a << "\u00B2 + " << b << "\u00B2\n";
    }else{
        std::cout << n << " is not a Pythagorean prime.\n";
    }
}