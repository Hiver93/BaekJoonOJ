#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool comp(string str1, string str2){
    if(str1.size() != str2.size()){
        return 0;
    }
    for(int i = 0; i < str1.size(); ++i){
        if(str1[i] != str2[i]){
            return 0;
        }
    }
    return 1;
}

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    int idx1 =0, idx2=0;
    
    for(int i = 0; i < goal.size(); ++i){
        if(idx1 < cards1.size() && comp(cards1[idx1],goal[i])){
            idx1++;
        }
        else if(idx2 < cards2.size() && comp(cards2[idx2],goal[i])){
            idx2++;
        }
        else{
            return "No";
        }
    }
    
    return "Yes";
}