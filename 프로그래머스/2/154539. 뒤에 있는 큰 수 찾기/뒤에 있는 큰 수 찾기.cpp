#include <string>
#include <vector>
#include <stack>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size());;
    stack<int> idxs;
    
    for(int i =0; i < numbers.size(); ++i){
        while(!idxs.empty()){
            if(numbers[idxs.top()] < numbers[i]){
                answer[idxs.top()] = numbers[i];
                idxs.pop();
            }
            else{
                break;
            }
        }
        idxs.push(i);
    }
    
    while(!idxs.empty()){
        answer[idxs.top()] = -1;
        idxs.pop();
    }
    
    return answer;
}