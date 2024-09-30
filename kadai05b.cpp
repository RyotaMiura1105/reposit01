/*kadai05b,5/15,22D8101040E,ryota miura*/
#include <iostream>
#include <vector>
#include <cstdlib>
int main(int argc, char* argv[]){
	if(argc != 1){
		std::string str = argv[1];
		int n = str.length();
	    int a = 0;
	    if(str[0] == '-' && str[1] == 'n' && n == 2){
		    a = 1;
	    }
	    for(int i = 1 + a; i < argc; i++){
		    if(i != 1 + a)std::cout << " " << argv[i];
		    if(i == 1 + a)std::cout << argv[i];
	    }
	    if(str[0] != '-' && str[1] != 'n' && n != 2){
		    std::cout << "\n";
	    }
	}
}
/*
g++ -o kadai05b kadai05b.cpp                                       
./kadai05b -n Clang GCC MSVC
Clang GCC MSVC*/
