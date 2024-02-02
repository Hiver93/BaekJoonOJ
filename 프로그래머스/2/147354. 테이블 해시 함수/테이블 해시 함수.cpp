#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int c;

bool cmp(vector<int> a, vector<int> b){
    if(a[c] < b[c]){
        return 1;
    }
    if(a[c] == b[c]){
        return a[0] > b[0];
    }
    return 0;
}

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    c = col-1;
    
    sort(data.begin(),data.end(),cmp);
    for(int i = row_begin-1; i < row_end; ++i){
        int tmp = 0;
        for(int j = 0; j < data[0].size(); ++j){
            tmp += data[i][j] % (i+1);
        }
        answer ^= tmp;
    }
    
    
    return answer;
}