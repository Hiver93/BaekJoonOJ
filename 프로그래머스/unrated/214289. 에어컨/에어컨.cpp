#include <string>
#include <vector>
using namespace std;


// 가능한 온도마다 시간만큼의 배열을 가진다
int memo[51][1001]{ 0 };
bool imp[51][1001]{0};
int T1, T2, A, B, tem, cur, INF = 2147483647;
vector<int> bVec;

int getMin(int l1, int l2, int l3, int r1, int r2, int r3){
    int result;
    r1 = l1 == INF ? INF : l1+r1;
    r2 = l2 == INF ? INF : l2+r2;
    r3 = l3 == INF ? INF : l3+r3;
    
    if(r1 < r2){
        result = r1;
    }
    else{
        result = r2;
    }
    if(r3 < result){
        result = r3;
    }
    return result;
}

// dp를 이용해 해결할 예정
int solution(int temperature, int t1, int t2, int a, int b, vector<int> onboard) {
    int answer = INF;
    // 메모에 편리하게 모든 온도 관련값을 +10하여 다시 저장
    T1 = t1 + 10;
    T2 = t2 + 10;
    cur = temperature + 10;
    tem = cur;
    bVec = onboard;
    
    for(int i = 0; i < 51; ++i){
        if(cur != i)
            imp[i][0] = 1;
    }
    
    for(int i = 1; i < bVec.size(); ++i){
        for(int j = 0; j < 51; ++j){
            
            // 승객이 있는데 적정온도가 아닌경우 불가능
            if( bVec[i] && (j < T1 || T2 < j)){
                memo[j][i] = INF;
                imp[j][i] = 1;
                continue;
            }
            
            // 이전 비용 -1, 0, 1 의 온도 차이
            int l1,l2,l3;
            if(j != 0)
                l1 = imp[j-1][i-1] ? INF : memo[j-1][i-1];
            else
                l1 = INF;
            l2 = imp[j][i-1] ? INF : memo[j][i-1];
            if(j != 50)
                l3 = imp[j+1][i-1] ? INF : memo[j+1][i-1];
            else
                l3 = INF;
            
            // 새로 드는 비용
            int r1,r2,r3;
            r1 = tem < j ? a : 0;
            r2 = tem == j ? 0 : b;
            r3 = tem > j ? a : 0;
            memo[j][i] = getMin(l1,l2,l3,r1,r2,r3);
            if(memo[j][i] == INF){
                imp[j][i] = 1;
            }
        }
    }
    
    // 가장 낮은 비용 찾아낸다
    for(int i = 0; i < 51; ++i){
        if(memo[i][bVec.size()-1] < answer)
            answer = memo[i][bVec.size()-1];
    }
    
    return answer;
}