#include <string>
#include <vector>
#include <set>

using namespace std;
bool check[500][500]{0};
int result[500][500]{0};
int arr[250000]{0};
int dr[4] {-1,1,0,0};
int dc[4] {0,0,-1,1};
int idx = 0;
int r,c;
vector<vector<int>> l;
bool IsBoundOk(int y, int x){
    if(y < 0 || x < 0 || r <= y || c <= x){
        return false;
    }
    return true;
}

void Dfs(int y, int x){
    // 현재 석유덩어리의 값을 증가
    arr[idx]++;
    // 방문처리
    check[y][x] = 1;
    // 현재 위치가 어느덩어리에 속하는지 메모
    result[y][x] = idx;
    
    for(int i = 0; i < 4; ++i){
        if(!IsBoundOk(y+dr[i],x+dc[i]) || check[y+dr[i]][x+dc[i]] || !l[y+dr[i]][x+dc[i]]){
            continue;
        }
        // 다음 위치로 함수 호출
        Dfs(y+dr[i],x+dc[i]);
    }
}

int solution(vector<vector<int>> land) {
    int answer = 0;
    l = land;
    r = land.size();
    c = land[0].size();
    
    for(int i = 0; i < land.size(); ++i){
        for(int j = 0; j < land[0].size(); ++j){
            // 방문하지 않았고, 석유가 있는 위치라면
            if(check[i][j] == 0 && l[i][j]){
                idx++;
                Dfs(i,j);
            }
        }
    }
    for(int i = 0; i < land[i].size(); ++i){
        // 이번 시추관이 방문한 덩어리인지 저장할 set
        set<int> visit;
        int sum = 0;
        for(int j = 0; j < land.size(); ++j){
            //set에 값이 없다면 처음 만난 덩어리
            if(visit.find(result[j][i]) == visit.end()){
                // 방문처리 후 sum에 값 더함
                visit.insert(result[j][i]);
                sum += arr[result[j][i]];
            }
        }
        // 답보다 많다면 변경
        if(answer < sum)
            answer = sum;
    }
    
    return answer;
}