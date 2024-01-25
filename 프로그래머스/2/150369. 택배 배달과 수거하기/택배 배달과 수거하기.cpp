#include <string>
#include <vector>
#include <iostream>
using namespace std;

int maxV(int a, int b){
    return a > b ? a : b;
}

int lastIdx(vector<int> v, int idx){
    for(idx; idx >= 0; --idx){
        if(v[idx])
            break;
    }
    return idx;
}

int capSize(int value, int cap){
    if(value <= cap)
        return cap;
    if(value % cap == 0)
        return value;
    return value + (cap - (value % cap));
}

int lastIdx(vector<int> &v, int idx, int cap){
    for(idx; idx >= 0; --idx){
        if(v[idx] <= cap){
            cap -= v[idx];
        }
        else{
            v[idx] -= cap;
            break;
        }
    }
    return idx;
}

long long solution(int cap, int n, vector<int> dV, vector<int> pV) {
    long long answer = 0;
    int dIdx = lastIdx(dV, dV.size()-1);
    int pIdx = lastIdx(pV, pV.size()-1);
    while(0 <= pIdx || 0<= dIdx){
        int c = 0;
        if(pIdx < dIdx){
            c = capSize(dV[dIdx],cap);
            answer += (long long)((dIdx+1) * c / cap * 2);
            dIdx = lastIdx(dV,dIdx,c);
            pIdx = lastIdx(pV,pIdx,c);
        }
        else{
            c = capSize(pV[pIdx],cap);
            answer += (long long)((pIdx+1) * c / cap * 2);
            dIdx = lastIdx(dV,dIdx,c);
            pIdx = lastIdx(pV,pIdx,c);
        }

    }
    
    
    return answer;
}