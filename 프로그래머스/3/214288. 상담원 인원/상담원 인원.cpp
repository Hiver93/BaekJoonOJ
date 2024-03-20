#include <string>
#include <vector>
#include <queue>
using namespace std;

int K, N;
vector<vector<int>> rVec;
int result[20]{0};
int ans = 2147483647;

vector<priority_queue<int,vector<int>,greater<int>>> pq;


int waitingTime(int end, int st){
    if(end < st){
        return 0;
    }
    return end - st;
}

int getTime(){
    int r = 0;
    for(int i = 0; i < rVec.size(); ++i){
        int type = rVec[i][2]-1;
        int st = rVec[i][0];
        int time = rVec[i][1];
        
        int pr = pq[type].top();
        pq[type].pop();
        int wt = waitingTime(pr, st);
        r += wt;
        pq[type].push(wt + st + time);
    }
    return r;
}

void func(int num, int cur){
    if(K <= num)
        return;
    if(cur == N){
        pq.clear();
        pq.resize(K);
        for(int i = 0; i < N; ++i){
            pq[result[i]].push(0);
        }
        int r = getTime();
        if(r < ans)
            ans = r;
        return;
    }
    if((N - cur) < (K - num)){
        return;
    }
    result[cur] = num;
    func(num, cur+1);
    func(num+1, cur+1);
}

int solution(int k, int n, vector<vector<int>> reqs) {
    K = k;
    N = n;
    rVec = reqs;
    func(0,0);
    return ans;
}