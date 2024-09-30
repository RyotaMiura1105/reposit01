/*kadai04b,5/30,22D8101040E,RyotaMiura*/
#include <iostream>
#include <chrono>
#include <thread>
#include <cstdlib>
void sleep(double t){
    using namespace std::chrono_literals;
    std::this_thread::sleep_for(t * 1s);
}
int main(int argc, char* argv[]){
    if(argc == 1 || argc > 2){
        std::cout << "usage: ./kadai04b seconds\n";
        std::exit(1);
    }else{
        double time = std::atof(argv[1]);
        std::cout << "0%  10   20   30   40   50   60   70   80   90  100\n";
        std::cout << "|----|----|----|----|----|----|----|----|----|----|\n";
        std::cout << "^";
        std::cout << std::flush;
        for(int i = 0; i < 50; i++){
            sleep(time/50);
            std::cout << "\b";
            std::cout << "~";
            std::cout << "^";
            std::cout << std::flush;
        }
        std::cout << "\n" << time << " seconds have elapsed.\n";
    }
}
/*
g++ -o kadai04b kadai04b.cpp
./kadai04b 12.5
0%  10   20   30   40   50   60   70   80   90  100
|----|----|----|----|----|----|----|----|----|----|
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^
12.5 seconds have elapsed.*/