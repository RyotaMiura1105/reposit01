/*22D8101040E,kadai07b,5/29,RyotaMiura*/
#include <iostream>
#include <string>
#include <chrono>
#include <thread>
void sleep(double t){
    using namespace std::chrono_literals;
    std::this_thread::sleep_for(t * 1s);
}
int main(int argc, char* argv[]){
    std::string msg;
    int j;
    if(argc > 1){
        for(int i = 1; i < argc; i++){

            if(i == 1){ 
                msg += argv[1];
            }else{
                msg += " ";
                msg += argv[i];
            }
        }
        msg.resize(80, ' ');
        std::cerr << msg;
        for(int i = 0; i <= 80; i++){
            std::cout << "\r";
            j = i;
            int k = 0; 
            do{
               std::cout << msg[j];
               j++;
            }while(j < 81);
            do{
                std::cout << msg[k];
                k++;
            }while(k <= i);
            std::cout << std::flush;
            sleep(0.125);
        }
    }else{
        std::cout << "usage: kadai07b string...\n";
    }
}
/*
g++ -o kadai07b kadai07b.cpp                       
./kadai07b The 2024 spring C++ committee meeting will be held in Tokyo
The 2024 spring C++ committee meeting will be held in Tokyo
*/