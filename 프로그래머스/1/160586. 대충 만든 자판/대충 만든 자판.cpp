#include <string>
#include <vector>
#include <iostream>

using namespace std;

int findAlp(string str, char target){
    
    for(int i = 0; i < str.size(); ++i){
        if(str[i] == target){
            return i+1;
        }
    }
    return 0;
}

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    int alph[30]{0};
    for(int i = 0; i < keymap.size(); ++i){
        for(int j = 'A'; j <= 'Z'; ++j){
            int r = findAlp(keymap[i],j);
            if(!alph[j-'A']){
                alph[j-'A'] = r;
            }
            else if(r&&r < alph[j-'A']){
                alph[j-'A'] = r;
            }
        }
    }
    
    for(int i = 0; i < targets.size(); ++i){
        int r = 0;
        for(int j =0; j < targets[i].size(); ++j){
            if(alph[targets[i][j]-'A']){
                r+=(alph[targets[i][j]-'A']);
            }
            else{
                r = -1;
                break;
            }               
        }
        answer.push_back(r);

    }
    
    return answer;
}