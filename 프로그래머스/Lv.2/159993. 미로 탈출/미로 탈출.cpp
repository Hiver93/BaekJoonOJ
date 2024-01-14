#include <string>
#include <vector>
#include <queue>

#include <iostream>


using namespace std;
int dr[4] = {-1,1,0,0};
int dc[4] = {0,0,-1,1};
vector<string> m;
class Node{
    public:
    int x;
    int y;
    int dis;
    Node(int y, int x, int dis){
        this->y = y;
        this->x = x;
        this->dis = dis;
    }
};

bool isBoundOk(int y, int x){
    return 0 <= y && 0 <= x && y < m.size() && x < m[0].size() && m[y][x] != 'X';
}

int solution(vector<string> maps) {
    m = maps;
    int ans = 0;
    int visit1[100][100]{0};
    int visit2[100][100]{0};
    queue<Node*> q;
    for(int i = 0; i < m.size(); ++i){        
        for(int j = 0;j < m[0].size(); ++j){
            if(m[i][j] == 'S'){
                visit1[i][j] = 1;
                q.push(new Node(i,j,0));
                break;
            }
        }
    }
    
    while(!q.empty()&&!ans){
        Node* node = q.front();
        q.pop();
        int y = node->y;
        int x = node->x;
        int dis = node->dis;
        for(int i = 0; i < 4; ++i){
            int nextY = y + dr[i];
            int nextX = x + dc[i];
            if(isBoundOk(nextY,nextX) && !visit1[nextY][nextX]){
                if(m[nextY][nextX] == 'L'){
                    ans += dis+1;
                    q = queue<Node*>();
                    q.push(new Node(nextY,nextX,dis+1));
                    break;
                }
                visit1[nextY][nextX] = 1;
                q.push(new Node(nextY,nextX,dis+1));
            }
        }
    }

     while(!q.empty()){
        Node* node = q.front();
        q.pop();
        int y = node->y;
        int x = node->x;
        int dis = node->dis;
        for(int i = 0; i < 4; ++i){
            int nextY = y + dr[i];
            int nextX = x + dc[i];
            if(isBoundOk(nextY,nextX) && !visit2[nextY][nextX]){
                if(m[nextY][nextX] == 'E'){
                    return dis + 1;
                }
                visit2[nextY][nextX] = 1;
                q.push(new Node(nextY,nextX,dis+1));
            }
        }
    }
    
    return -1;
}