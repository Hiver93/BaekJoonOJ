#include <string>
#include <vector>

using namespace std;

int ans = 2147483647;
int idx = 0;
int input;
void func(int cur, int sum){
    if(!input || cur == idx+1){
        if(sum < ans)
            ans = sum;
        return;
    }
    int tmp = input % 10;
    input /= 10;
    func(cur + 1, sum + tmp);
    input += 1;
    func(cur + 1, sum + (10 - tmp));
    input -= 1;
    input *= 10;
    input += tmp;
}

int solution(int storey) {
    input = storey;
    while(storey){
        idx++;
        storey /= 10;
    }
    func(0,0);
    
    
    return ans;
}