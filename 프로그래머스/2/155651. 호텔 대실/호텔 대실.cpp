#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
vector<vector<string>> bt;

int toInt(string a){
    int i = (a[0]-'0') * 1000 + (a[1] - '0') * 100 + (a[3] - '0') * 10 + (a[4]-'0');
    return i;
}

bool comp(vector<string> a, vector<string> b){
    int ai, bi;
    ai = toInt(a[0]);
    bi = toInt(b[0]);
    if(ai < bi)
        return 1;
    if(ai == bi){
        ai = toInt(a[1]);
        bi = toInt(b[1]);
        return ai < bi;
    }
    return 0;
}

string cleaning(string str){
    int h = (str[0]-'0')*10 + str[1] - '0';
    int m = (str[3]-'0')*10 + str[4] - '0';
    m += 10;
    if(60 <= m){
        h += 1;
        m %= 60;
    }
    str[0] = h / 10 + '0';
    str[1] = h % 10 + '0';
    str[3] = m / 10 + '0';
    str[4] = m % 10 + '0';
    return str;
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    bt = book_time;
    sort(bt.begin(),bt.end(),comp);
    int max = 1;
    string arr[1001];
    arr[0] = cleaning(bt[0][1]);
    for(int i= 1; i < bt.size(); ++i){
        int check = 0;
        for(int j = 0; j < max; ++j){
            if(toInt(arr[j]) <= toInt(bt[i][0])){
                cout << j << " " << bt[i][0] << endl;
                arr[j] = cleaning(bt[i][1]);
                check = 1;
                break;
            }
        }
        if(!check){
            cout << max << " " << bt[i][0] << endl;
            arr[max++] = cleaning(bt[i][1]);
        }
    }
    
    
    return max;
}