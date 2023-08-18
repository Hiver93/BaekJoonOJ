#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

bool comp(vector<string> v1, vector<string> v2)
{
    return v1[1] < v2[1];
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    
    // 남은 시간을 저장할 배열
    int arr[1000];
    // 하고 있는 과제들의 인덱스를 담을 스택
    stack<int> idxs;
    int current = 0;
    // 시간 순 오름차순 정렬
    sort(plans.begin(),plans.end(),comp);
    
    // 반복문 0:00 부터 23:59까지 진행 할 것
    for(int i = 0; i < 10000; ++i)
    {
        for(int j = 0; j < 60; ++j)
        {
           
            // 다음 과제를 시작할 시간이 되었는 지 확인
            if(current != plans.size())
            {
                int h = (plans[current][1][0]-'0')*10 + plans[current][1][1] - '0';
                int m = (plans[current][1][3]-'0')*10 + plans[current][1][4] - '0'; 
                if(h == i && m == j)
                {                
                    arr[current] = atoi(plans[current][2].c_str());
                    idxs.push(current);
                    current++;
                }
            }
            // 해야하는 과제가 있는 지 먼저 확인. 있다면 시간 줄이기
            if(!idxs.empty())
            {        
                // 끝마쳤다면 스택에서 제거
                if(--arr[idxs.top()] == 0)
                {
                    answer.push_back(plans[idxs.top()][0]);
                    idxs.pop();
                }                    
            }
        }
    }
    return answer;
}