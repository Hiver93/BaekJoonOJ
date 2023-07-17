#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int y1 = 987654321,y2 = 0,x1=987654321,x2=0;
    
    for(int i = 0; i < wallpaper.size(); ++i)
    {
        for(int j = 0; j < wallpaper[i].size(); ++j)
        {
            if(wallpaper[i][j] == '#')
            {
                if(i < y1)
                    y1 = i;
                if(y2 < i)
                    y2 = i;
                if(j < x1)
                    x1 = j;
                if(x2 < j)
                    x2 = j;
            }
        }
    }
    return {y1,x1,y2+1,x2+1};
}