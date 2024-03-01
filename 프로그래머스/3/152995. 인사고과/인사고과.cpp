#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int> v1, vector<int> v2){
    if(v1[0] == v2[0]){
        return v1[1] < v2[1];
    }
    return v1[0] > v2[0];
}

bool cmp2(vector<int> v1, vector<int> v2){
    return v1[2] > v2[2];
}

int solution(vector<vector<int>> scores) {
    int answer = 1;
    int wan = scores[0][0] + scores[0][1];
    for(int i = 0; i < scores.size(); ++i){
        scores[i].push_back(scores[i][0] + scores[i][1]);
        scores[i].push_back(i);
    }
    
    sort(scores.begin(), scores.end(), cmp);
    int max = scores[0][1];
    for(int i = 1; i < scores.size(); ++i){
        if(scores[i][1] < max){
            scores[i][2] = -1;
        }
        if(max < scores[i][1])
            max = scores[i][1];
    }
    
    for(int i = 0; i < scores.size(); ++i){
        if(scores[i][3] == 0 && scores[i][2] == -1)
            return -1;
        if(wan < scores[i][2])
            answer++;
    }
    
    
    
    return answer;
}