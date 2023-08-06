#include <string>
#include <vector>

using namespace std;

// 원의 테두리를 따라가며 점을 세자

long long solution(int r1, int r2) {
    long long answer = 0;
    
    // 초기화 
    long long x=0, y=r2;
    
    // 피타고라스의 정리를 이용할 것 (c * c = a * a + b * b)
    long long rr2 = (long long)r2*(long long)r2, rr1 = (long long)r1*(long long)r1;
    
    long long n1=0, n2=0;
    
    // 1사분면의 r2원 내부 점들의 수를 구할 것
    // y가 0이 되기 전까지 반복
    while(y != 0)
    {
        // r2의 제곱보다 x제곱+y제곱이 작다면 원 내부의 점이다
        //내부에 있다는 것을 알게되었다면 그 아래에 있는 점들은 모두 원 내부에 있다는 것. x를 1증가 
        if(x*x + y*y <= rr2)
        {
            n2 += y;
            x++;
        }
        // 원 밖에 있다면
        else
        {
            y--;
        }
    }
    x = 0;
    y = r1;
    // r1 내부 점
    while(y != 0)
    {
        if(x*x + y*y < rr1)
        {
            n1 += y;
            x++;
        }
        else
        {
            y--;
        }
    }
    
    // 구한 점 갯수에 4를 곱하여 바깥에서 안의 원을 뺀다
    return (n2 - n1)*4;
}