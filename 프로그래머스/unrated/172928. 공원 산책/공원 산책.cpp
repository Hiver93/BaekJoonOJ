#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    map<char,int> dr, dc;
    dr['S'] = 1; dc['S'] = 0;
    dr['E'] = 0; dc['E'] = 1;
    dr['W'] = 0; dc['W'] = -1;
    dr['N'] = -1; dc['N'] = 0;
    int sX, sY = -1;
    int rMax = park.size(), cMax = park[0].size();
    for(int i = 0; i < park.size(); ++i)
    {
        if(sY != -1)
            break;
        for(int j = 0; j < park[i].size(); ++j)
        {
            if(park[i][j] == 'S')
            {
                sY = i;
                sX = j;
                break;
            }
        }
    }
        for(int i = 0; i < routes.size(); ++i)
        {
            if(sY + dr[routes[i][0]] * (routes[i][2]-'0') < 0||
              rMax <= sY + dr[routes[i][0]] * (routes[i][2]-'0')||
              sX + dc[routes[i][0]] * (routes[i][2]-'0') < 0 ||
              cMax <= sX + dc[routes[i][0]] * (routes[i][2]-'0'))
                continue;
            int j;
            for(j = 1; j <= routes[i][2]-'0'; ++j)
            {
                if(park[sY + dr[routes[i][0]] * j][sX + dc[routes[i][0]] * j] == 'X')
                    break;
            }
            if(j == routes[i][2]-'0'+1)
            {
                sY = sY + dr[routes[i][0]] * (routes[i][2]-'0');
                sX = sX + dc[routes[i][0]] * (routes[i][2]-'0');
            }
        }
    return {sY,sX};
}