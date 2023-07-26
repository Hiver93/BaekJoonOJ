#include <string>
#include <vector>

using namespace std;

int solution(int chicken) {
    int answer = 0;
    
    while(10 <= chicken)
    {
        int c = chicken /10;
        answer += c;
        chicken %= 10;
        chicken += c;
    }
    
    return answer;
}