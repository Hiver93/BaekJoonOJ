#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int dr[4]{-1,1,0,0};
int dc[4]{0,0,-1,1};
int op[5]{1,0,3,2,4};
int R[2]{0};
bool check[100][100]{0};


int solution(vector<string> board) {
    queue<int> x,y,dir,dis;
        
    // R, G를 찾아낸다.
    for(int i = 0; i < board.size(); ++i)
    {
        for(int j = 0; j < board[0].size(); ++j)
        {
            if(board[i][j] == 'R')
            {
                R[0] = i;
                R[1] = j;                
            }
        }
    } 
    
    // q에 시작지점을 넣고 방문처리.
    y.push(R[0]);
    x.push(R[1]);
    dir.push(4);
    dis.push(0);
    check[R[0]][R[1]] = 1;
    while(!y.empty())
    {
        // 여기가 골이면 리턴
        if(board[y.front()][x.front()] == 'G')
            return dis.front();
        
        for(int i = 0; i < 4; ++i)
        {
            // 못가는 곳 조건(왔던 길, 가장자리, 막힌 길)
            int nextY = y.front()+dr[i];
            int nextX = x.front()+dc[i];
            if(i == op[dir.front()] || nextY < 0 || nextX < 0|| 
               board.size() <= nextY || board[0].size() <= nextX||
              board[nextY][nextX] == 'D')
                continue;
            
            // 막힌곳까지 진행
            while(!(board.size() <= nextY || board[0].size() <= nextX||
              board[nextY][nextX] == 'D'))
            {
                nextY+=dr[i];
                nextX+=dc[i];
            }
            // 막힌곳 직전상태로
            nextY-=dr[i];
            nextX-=dc[i];
            
            // 방문한 곳이면 다른 곳 알아보기
            if(check[nextY][nextX])
                continue;
            
            // 아니면 큐에 넣고 방문처리
            y.push(nextY);
            x.push(nextX);
            dir.push(i);
            dis.push(dis.front()+1);
            check[nextY][nextX] = 1;            
        }
        // 큐에서 현재 위치 제거
        y.pop();
        x.pop();
        dir.pop();
        dis.pop();    
    }
    
    
    return -1;
}