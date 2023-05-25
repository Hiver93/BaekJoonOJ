#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>
using namespace std;

bool comp(const pair<string, int>& m1, const pair<string, int>& m2)
{
    return m1.second > m2.second;
}

bool compA(const pair<string, int*>& m1, const pair<string, int*>& m2)
{
    return m1.second[0] > m2.second[0];
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    vector<pair<string,int*>> vec(genres.size());
    map<string,int> m;
    
    for(int i = 0; i < genres.size(); ++i)
    {
        vec[i]={genres[i],new int[2]{plays[i],i}};
        if(m.find(genres[i]) == m.end())
        {
            m.insert({genres[i],plays[i]});
        }
        else
            m.find(genres[i])->second += plays[i];
        
    }
    vector<pair<string,int>> sum(m.begin(), m.end());
    sort(sum.begin(), sum.end(), comp);
    sort(vec.begin(), vec.end(), compA);
    map<string,int*> rMap;
    for(int i = 0; i< vec.size(); ++i)
    {
        auto tmp = rMap.find(vec[i].first);
        if(tmp == rMap.end())
            rMap.insert({vec[i].first,new int[2]{vec[i].second[1],-1}});
        else
            if(tmp->second[1] == -1)
                tmp->second[1] = vec[i].second[1];
    }
    for(int i = 0; i < sum.size(); ++i)
    {
        auto tmp = rMap.find(sum[i].first)->second;
        answer.push_back(tmp[0]);
        if(tmp[1] != -1)
            answer.push_back(tmp[1]);
    }
    
    return answer;
}