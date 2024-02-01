#include <string>
#include <vector>
#include <map>

using namespace std;

long long st, ed;
map<long long, long long> m;

int func(long long length, long long left, long long right){    
    int result = 0;
    
    long long tmp = length / 5;
    long long stIdx = left;
    long long edIdx = left + tmp - 1;
    for(int i = 0; i < 5; ++i){
        if(edIdx < st || ed < stIdx || i == 2){
        }
        else if(st <= stIdx && edIdx <= ed){
            result += m[tmp];
        }
        else{
            result += func(tmp,stIdx,edIdx);
        }
        stIdx += tmp;
        edIdx += tmp;
    }
    
    return result;
}

int solution(int n, long long l, long long r) {
    st = l;
    ed = r;
    long long len = 1;
    m.insert({1,1});
    for(int i = 0; i < n; ++i){
        len *= 5;
        m[len] = m[len/5] * 4; 
    }
    
    return func(len,1,len);
}


