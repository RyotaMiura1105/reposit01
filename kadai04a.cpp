/*kadai4a,22D8101040E,5/29,RyotaMiura*/
#include <iostream>
#include <stdlib.h>
struct RandomMemberGenerator{
    int val;
    int generate_random_value(){
        val = (val * 16807LL) % 2147483647LL;
        return val;
    }
    void seed(int seed_val){
        val = seed_val;
    }
};
int main(int argc, char* argv[]){
    if(argc == 1 || argc > 3){
        std::cout << "usage: " << argv[0] << " count [seed]\n";
    }else if(argc == 2 || argc == 3){
        int n = atoi(argv[1]);
        RandomMemberGenerator random;
        if(argc == 2){
            random.seed(1);
        }else{
            int s = atoi(argv[2]);
            random.seed(s);
        }
        for(int i = 0; i < n; i++){
            std::cout << random.generate_random_value() << "\n";
        }
    }
}
/*
g++ -o kadai04a kadai04a.cpp
./kadai04a 7 5489
92253623
23448627
1111566588
1139399263
771732942
1861811961
489408090*/