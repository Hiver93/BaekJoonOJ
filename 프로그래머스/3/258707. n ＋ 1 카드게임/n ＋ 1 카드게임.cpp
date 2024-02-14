#include <string>
#include <vector>
using namespace std;
int addedIdx = 0;
int n;
vector<int> vec1;
vector<int> vec2;

bool find1(){
    for(int i = 0; i < vec1.size(); ++i){
        if(vec1[i] == -1)
            continue;
        for(int j = i+1; j < vec1.size(); ++j){
            if(vec1[j] == -1)
                continue;
            if(vec1[i] + vec1[j] == n+1){
                vec1[i] = -1;
                vec1[j] = -1;
                return 1;
            }
        }
    }
    return 0;
}

bool find2(){
    for(int i = 0; i < vec1.size(); ++i){
        if(vec1[i] == -1)
            continue;
        for(int j = 0; j < addedIdx && j < vec2.size(); ++j){
            if(vec1[i] + vec2[j] == n+1){
                vec1[i] = -1;
                vec2[j] = -1;
                return 1;
            }
        }
    }
    return 0;
}

bool find3(){
    for(int i = 0; i < addedIdx && i < vec2.size(); ++i){
        if(vec2[i] == -1)
            continue;
        for(int j = i+1; j < addedIdx && j < vec2.size(); ++j){
            if(vec2[j] == -1)
                continue;
            if(vec2[i] + vec2[j] == n+1){
                vec2[i] = -1;
                vec2[j] = -1;
                return 1;
            }
        }
    }
    return 0;
}



int func(int coin){
    int result = 0;
    while(true){
        addedIdx += 2;
        result++;
        if(n/3*2 < addedIdx)
            break;
        if(find1()){
            continue;
        }
        if(coin < 1)
            break;
        if(find2()){
            coin--;
            continue;
        }
        if(coin < 2)
            break;
        if(find3()){
            coin -=2;
            continue;
        }
        break;
    }
    return result;
}

int solution(int coin, vector<int> cards) {
    n = cards.size();
    int i;
    vec1.resize(n/3);
    vec2.resize(n/3*2);
    for(i = 0; i < cards.size()/3; ++i){
        vec1[i] = cards[i];
    }
    for(; i < cards.size(); ++i){
        vec2[i-cards.size()/3] = cards[i];
    }
    int ans = func(coin);
    return ans;
}