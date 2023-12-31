#include <string>
#include <vector>
#include <iostream>

using namespace std;
int rX, rY, bX, bY;
int dr[4] {-1,1,0,0};
int dc[4] {0,0,-1,1};
int R_GOAL=3, B_GOAL=4;
bool rIsGoal = 0, bIsGoal = 0;
int rVisit[4][4]{0};
int bVisit[4][4]{0};
vector<vector<int>> m;
int ans = 2147483647;

bool isBoundOk(int y, int x){
    return !(y < 0 || x < 0 || m.size() <= y || m[0].size() <= x || m[y][x] == 5);
}
void rMove(int depth);
void bMove(int depth);
void printMap(int d) {
    cout << d << endl;
    cout << 'r' << ' ' << rY << ' ' << rX << endl;
    cout << 'b' << ' ' << bY << ' ' << bX << endl;
    if (rIsGoal)
        cout << 'R' << endl;
    if (bIsGoal)
        cout << 'B' << endl;
    for (int i = 0; i < m.size(); ++i) {
        for (int j = 0; j < m[0].size(); ++j) {
            if (i == rY && j == rX) {
                cout << 'r';
            }
            else if (i == bY && j == bX) {
                cout << 'b';
            }
            else if (m[i][j] == 3) {
                cout << 'R';
            }
            else if (m[i][j] == 4) {
                cout << 'B';
            }
            else
                cout << 'o';
            cout << ' ';
        }
        cout << endl;
    }
    cout << endl;
}
void move(int depth){    
    if(rIsGoal && bIsGoal){
        if(depth < ans){
            ans = depth;
        }
        rIsGoal = 0;
        return;   
    }
    int lBY = bY;
    int lBX = bX;
    int lRY = rY;
    int lRX = rX;

    if(rIsGoal){
        for(int i = 0; i < 4; ++i){
            if(isBoundOk(bY+dr[i],bX+dc[i])){
                if(!(bVisit[bY+dr[i]][bX+dc[i]])&&(bY+dr[i] != rY || bX +dc[i] != rX)){
                    bY = bY+dr[i];
                    bX = bX+dc[i];
                    bVisit[bY][bX] = 1;
                    if(m[bY][bX] == 4){
                        bIsGoal = 1;
                    }
                    move(depth+1);
                    if(m[bY][bX] == 4){
                        bIsGoal = 0;
                    }
                    bVisit[bY][bX] = 0;
                    bY = bY-dr[i];
                    bX = bX-dc[i];
                }
            }
        }
    }
    else if(bIsGoal){
        for(int i = 0; i < 4; ++i){
            if(isBoundOk(rY+dr[i],rX+dc[i])){
                if(!(rVisit[rY+dr[i]][rX+dc[i]])&&(rY+dr[i] != bY || rX +dc[i] != bX)){
                    rY = rY+dr[i];
                    rX = rX+dc[i];
                    rVisit[rY][rX] = 1;
                    if(m[rY][rX] == 3){
                        rIsGoal = 1;
                    }
                    move(depth+1);
                    if(m[rY][rX] == 3){
                        rIsGoal = 0;
                    }
                    rVisit[rY][rX] = 0;
                    rY = rY-dr[i];
                    rX = rX-dc[i];
                }
            }
        }
    }
    else{
        for(int i = 0; i < 4; ++i){
            if(isBoundOk(bY+dr[i],bX+dc[i])){
                if(!(bVisit[bY+dr[i]][bX+dc[i]])){
                    bY = bY+dr[i];
                    bX = bX+dc[i];
                    bVisit[bY][bX] = 1;
                    if(m[bY][bX] == 4){
                        bIsGoal = 1;
                    }
                    for(int j = 0; j < 4; ++j){                        
                        if(isBoundOk(rY+dr[j],rX+dc[j])){
                            if(!(rVisit[rY+dr[j]][rX+dc[j]])){
                                rY = rY+dr[j];
                                rX = rX+dc[j];
                                rVisit[rY][rX] = 1;
                                if(m[rY][rX] == 3){
                                    rIsGoal = 1;
                                }
                                if((rY != bY || rX != bX)&&
                                   !(lRY == bY && lRX == bX && lBY == rY && lBX == rX))
                                    move(depth+1);
                                if(m[rY][rX] == 3){
                                    rIsGoal = 0;
                                }
                                rVisit[rY][rX] = 0;
                                rY = rY-dr[j];
                                rX = rX-dc[j];
                            }
                        }
                    }
                    if(m[bY][bX] == 4){
                        bIsGoal = 0;
                    }
                    bVisit[bY][bX] = 0;
                    bY = bY-dr[i];
                    bX = bX-dc[i];
                }
            }
        }
    }
}
int solution(vector<vector<int>> maze) {
    m =maze;
    for(int i = 0; i < m.size(); ++i){
        for(int j = 0; j < m[0].size(); ++j){
            switch(m[i][j]){
            case 1:{
                rY = i;
                rX = j;
                break;
            }
            case 2:{
                bY = i;
                bX = j;
                break;
            }
            default:
                break;
            }
        }
    }
    rVisit[rY][rX] = 1;
    bVisit[bY][bX] = 1;
    move(0);
    if(ans == 2147483647){
        return 0;
    }
    return ans;
}