#include <string>
#include <vector>
#include <iostream>

using namespace std;

int func(int a, int b)
{
    if(a % b == 0)
        return b;
    return func(b, a % b) ;
}

vector<int> solution(int n, int m) {
    vector<int> answer;
    answer.push_back(n > m ? func(n, m) : func(m, n));
    answer.push_back(n * m / answer[0]);
    
    return answer;
}