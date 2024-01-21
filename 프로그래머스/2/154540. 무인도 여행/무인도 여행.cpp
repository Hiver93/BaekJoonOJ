#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int dr[4] = {-1,1,0,0};
int dc[4] = {0,0,-1,1};
bool visit[100][100]{0};
vector<string> m;
vector<int> ans;
int cnt = 0;

bool isBoundOK(int y, int x){
    return y < m.size() && x < m[0].size() && 0 <= y && 0 <= x && m[y][x] != 'X';
}

void dfs(int y, int x){
    cnt += m[y][x]-'0';
    visit[y][x] = 1;
    for(int i = 0;i < 4; ++i){
        int nY = y + dr[i];
        int nX = x + dc[i];
        if(!visit[nY][nX] && isBoundOK(nY,nX)){
            dfs(nY,nX);
        }
    }
}

vector<int> solution(vector<string> maps) {
    m = maps;
    for(int i = 0; i < m.size(); ++i){
        for(int j = 0; j < m[i].size(); ++j){
            if(m[i][j] != 'X' && !visit[i][j]){
                dfs(i,j);
                ans.push_back(cnt);
                cnt = 0;
            }
        }
    }
    if(ans.size() == 0)
        ans.push_back(-1);
    sort(ans.begin(),ans.end());
    return ans;
}