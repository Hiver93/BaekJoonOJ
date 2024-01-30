#include <string>
#include <vector>
#include <list>
#include <map>

using namespace std;

const int DONUT = 1, BAR = 2, EIGHT = 3;
vector<int> answer = {0,0,0,0};
list<int> arr[1000001];
int visit[1000001]{0};
map<int,int> m;
int cur;

void func(int idx){
    if(arr[idx].size() == 0){
        answer[BAR]++;
        return;
    }
    
    for(auto i = arr[idx].begin(); i != arr[idx].end(); ++i){
        auto tmp = m.find(*i);
        if(tmp != m.end()){
            if(tmp->second == 0){
                tmp->second = 1;
                answer[EIGHT]++;
            }
            visit[*i] = cur;
            continue;
        }
        
        if(visit[*i]){        
            if(visit[*i] == cur&&tmp == m.end()){
                answer[DONUT]++;
            }
            continue;
        }
        visit[*i] = cur;
        func(*i);
    }
}

vector<int> solution(vector<vector<int>> edges) {    
    for(int i = 0; i < edges.size(); ++i){
        arr[edges[i][0]].push_back(edges[i][1]);
        if(arr[edges[i][0]].size() == 2){
            m.insert({edges[i][0],0});
        }
    }
    
    for(int i = 1; i < 1000001; ++i){
        if(visit[i] || arr[i].size() == 0)
            continue;
        cur = i;
        func(i);
    }
    
    for(int i = 1; i < 1000001; ++i){
        if(!visit[i] && arr[i].size() == answer[1] + answer[2] + answer[3]){
            answer[0] = i;
            break;
        }
    }
    
    return answer;
}