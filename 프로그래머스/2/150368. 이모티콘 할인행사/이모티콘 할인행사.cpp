#include <string>
#include <vector>

using namespace std;
int p = 0;
int sum = 0;
int arr[100]{0};
vector<vector<int>> u;
vector<int> e;
pair<int,int> ans = {0,0};

int salePrice(int price, int per){
    return price / 100 * (100 - per);
}

pair<int,int> getResult(){
    pair<int,int> r = {0,0};
    for(int i = 0; i < u.size(); ++i){
        int v = u[i][1];
        if(v <= arr[i]){
            r.first++;
        }
        else{
            r.second+=arr[i];
        }
    }
    return r;
}

void func(int idx){
    if(idx == e.size()){
        pair<int,int> tmp = getResult();
        if(ans.first < tmp.first){
            ans.first = tmp.first;
            ans.second = tmp.second;
        }
        else if(ans.first == tmp.first && ans.second < tmp.second){
            ans.first = tmp.first;
            ans.second = tmp.second;
        }
        return;
    }
    
    for(int i = 1; i <= 4; ++i){
        int per = i*10;
        int price = salePrice(e[idx],per);
        for(int j = 0; j < u.size(); ++j){
            if(u[j][0] <= per){
                arr[j] += price;
            }
        }
        func(idx+1);
        for(int j = 0; j < u.size(); ++j){
            if(u[j][0] <= per){
                arr[j] -= price;
            }
        }
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    u = users;
    e = emoticons;
    func(0);
    answer.push_back(ans.first);
    answer.push_back(ans.second);
    return answer;
}