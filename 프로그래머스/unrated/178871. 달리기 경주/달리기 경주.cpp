#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    map<string,int> m;
    
    for(int i = 0; i < players.size(); ++i)
    {
        m.insert({players[i],i});
    }
    
    for(int i = 0; i < callings.size(); ++i)
    {
        auto p1 = m.find(callings[i]);
        auto p2 = m.find(players[(p1->second) - 1]);     
        
        int j = p1->second;
        int tmpN = p1->second;        
        p1->second = p2->second;
        p2->second = tmpN;
        
        string tmp = players[j];
        players[j] = players[j-1];
        players[j-1] = tmp;
    }
    return players;
}