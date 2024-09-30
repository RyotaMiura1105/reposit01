/*kadai07c,5/30,22D8101040E,RyotaMiura*/
#include <iostream>
#include <cstdlib>
#include <vector>
#include <string>
int main(){
    int i = 1;
    std::string path_env_var = std::getenv("PATH");
    std::cout << "(" << i << ") ";
    for(auto x : path_env_var){
        if(x == ':'){
            std::cout << "\n(" << i << ") ";
            i++;
        }else{
            std::cout << x;
        }
    }
    std::cout << "\n";
}
/*
g++ -o kadai07c kadai07c.cpp
./kadai07c
(1) C
(1) \Program Files\x86_64-13.1.0-release-win32-seh-msvcrt-rt_v11-rev1.7z\mingw64\bin;C
(2) \Program Files\Python310\Scripts\;C
(3) \Program Files\Python310\;C
(4) \Program Files\Microsoft\jdk-11.0.12.7-hotspot\bin;C
(5) \Windows\system32;C
(6) \Windows;C
(7) \Windows\System32\Wbem;C
(8) \Windows\System32\WindowsPowerShell\v1.0\;C
(9) \Windows\System32\OpenSSH\;C
(10) \Program Files\dotnet\;C
(11) \Users\Ryota\AppData\Local\Microsoft\WindowsApps;C
(12) \Users\Ryota\AppData\Local\Programs\Microsoft VS Code\bin;C
(13) \Users\Ryota\Downloads\mingw64\bin;
*/