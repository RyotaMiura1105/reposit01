/*22D8101040E,kadai07a,6/1,RyotaMiura*/
#include <iostream>
#include <chrono>
#include <cmath>
#include <iomanip>
#include <cstdlib>
int days_since_1900_01_01(int y, int m, int d){
    if(m <= 2){
        m += 9;
        --y;
    }else{
        m -= 3;
    }
    int e = (y >= 0 ? y : y - 399) / 400;
    int f = y - 400 * e;
    int g = (153 * m + 2) / 5 + d - 1;
    int h = f * 365 + f / 4 - f / 100 + g;
    return e * 146097 + h - 693901;
}
int main(int argc, char* argv[]){
    double Tmoon = 29.530589;
    char moon_emojis[8][5] = {"\U0001F311", "\U0001F312", "\U0001F313", "\U0001F314", "\U0001F315", "\U0001F316", "\U0001F317", "\U0001F318", };
    if(argc == 2){
        int y = std::atoi(&(argv[1][0]));
        int m = std::atoi(&(argv[1][5]));
        int d = std::atoi(&(argv[1][8]));
        double z = std::fmod(days_since_1900_01_01(y,m,d),Tmoon);
        if(z < 0.0){
            z += y;
        }
        int n = z / (Tmoon / 8);
        if(n == 8){
            n = 0;
        }
        std::cout << std::fixed << std::setprecision(1);
        std::cout << moon_emojis[n] << " (" << z <<"/29.5)\n";
    }else if(argc == 1){
        using namespace std::chrono_literals;
        auto now = std::chrono::system_clock::now();
        auto unix_time = now.time_since_epoch() / 1s;
        int num_days = (unix_time + 9 * 60 * 60) / (24 * 60 * 60);
        num_days += days_since_1900_01_01(1970, 1, 1);
        double z = std::fmod(num_days,Tmoon);
        if(z < 0.0){
            z += Tmoon;
        }
        int n = z / (Tmoon / 8);
        if(n == 8){
            n = 0;
        }
        std::cout << std::fixed << std::setprecision(1);
        std::cout << moon_emojis[n] << " (" << z <<"/29.5)\n";
    }else{
        std::cout << "usage: ./kadai04c [YYYY-MM-DD]\n";
        std::exit(1);
    }
}
/*
g++ -o kadai04c kadai04c.cpp
./kadai04c 2023-05-15       
🌗 (24.9/29.5)*/