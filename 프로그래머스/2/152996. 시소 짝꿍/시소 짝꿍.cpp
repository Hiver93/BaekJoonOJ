#include <string>
#include <vector>

using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    long long arr2[4001]{0};
    long long arr3[4001]{0};
    long long arr4[4001]{0};
    for(int i = 0; i < weights.size(); ++i){
        arr2[weights[i] * 2]++;
        arr3[weights[i] * 3]++;
        arr4[weights[i] * 4]++;
    }
    for(int i = 200; i < 4001; ++i){
        long long tmp = answer;
        answer += arr2[i] * arr3[i];
        answer += arr2[i] * arr4[i];
        answer += arr3[i] * arr4[i];
    }
    for(int i = 200; i < 2001; ++i){
        if(arr2[i]){
            long long tmp = 0;
            for(int j = arr2[i] -1; j > 0; --j){
                tmp += j;
            }
            answer += tmp;
        }
    }
    return answer;
}