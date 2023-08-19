#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>
using namespace std;

int dArr[10]{0};
int iArr[10]{0};
int sArr[10]{0};
int idx = -1;
vector<int> p;
int ans = 214748364;

void func(int current, int sum)
{
    // 더한 값을 전부 사용하였거나, 사용가능한 곡괭이가 더이상 없다면 끝
    if(current == idx || (!p[0]&&!p[1]&&!p[2]))
    {
        if(sum < ans)
            ans = sum;
        return;
    }
    
    // 사용 가능한 곡괭이가 있다면 그 곡괭이를 사용한 경우로 다음 함수 호출
    if(p[0])
    {
        p[0]--;
        func(current+1,sum+dArr[current]);
        p[0]++;
    }
    if(p[1])
    {
        p[1]--;
        func(current+1,sum+iArr[current]);
        p[1]++;
    }
    if(p[2])
    {
        p[2]--;
        func(current+1,sum+sArr[current]);
        p[2]++;
    }
}

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    p = picks;
    
    // 배열 3개에 각각 5광물씩 곡괭이별 노동력 더한 값을 저장해놓음
    for(int i = 0; i < minerals.size(); ++i)
    {
        if(i % 5 == 0)
            idx++;
        dArr[idx] += 1;
        if(minerals[i][0] == 'd')
        {
            iArr[idx] += 5;
            sArr[idx] += 25;
        }
        else if(minerals[i][0] == 'i')
        {
            iArr[idx] += 1;
            sArr[idx] += 5;
        }
        else
        {
            iArr[idx] += 1;
            sArr[idx] += 1;
        }
    }
    idx++;
    
    // 재귀로 순서 바꾸어가며 가장 저렴한 것을 찾음
    func(0,0);
    
    return ans;
}