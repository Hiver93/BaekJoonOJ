#include <string>
#include <vector>
#include <iostream>

using namespace std;

int xCount = 0;
int oCount = 0;
vector<string> b;

int checkOver(char c){
    oCount = 0;
    xCount = 0;
    int num = 0;
    if(b[0][0] == c && b[1][1] == c && b[2][2] == c)
        num++;
    if(b[0][2] == c && b[1][1] == c && b[2][0] == c)
        num++;
    for(int i = 0; i < 3; ++i){
        int count1 = 0;
        int count2 = 0;
        for(int j = 0; j < 3; ++j){
            if(b[i][j] == 'O')
                oCount++;
            if(b[i][j] == 'X')
                xCount++;
            if(b[i][j] == c)
                count1++;
            if(b[j][i] == c)
                count2++;
        }
        if(count1 == 3)
            num++;
        if(count2 == 3)
            num++;
    }
    return num;
}

void check(){
}

int solution(vector<string> board) {
    b = board;
    int oOver = checkOver('O');
    int xOver = checkOver('X');
    
    cout << oOver <<endl;
    cout << xOver << endl;
    if(xOver && oOver)
        return 0;
    
    if(oOver && oCount -1 != xCount)
        return 0;
    if(xOver && oCount != xCount)
        return 0;
    if(!(xCount == oCount ||xCount+1 == oCount))
        return 0;
    
    return 1;
}