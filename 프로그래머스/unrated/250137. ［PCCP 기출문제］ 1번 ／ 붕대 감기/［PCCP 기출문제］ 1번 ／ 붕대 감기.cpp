#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int t = bandage[0], x = bandage[1], y = bandage[2];
    int idx = 0;
    int time = 0;
    int max = health;
    for(int i = 1; i < 1001; ++i){
        if(attacks[idx][0] == i){
            health -= attacks[idx][1];
            if(health < 1){
                return -1;
            }
            time = 0;
            if(++idx == attacks.size()){
                return health;
            }
            continue;
        }
        
        
        time++;
        health += x;
        if(time == t){
            health += y;
            time = 0;
        }
        
        if(max<health){
            health = max;
        }
    }
    return health;
}