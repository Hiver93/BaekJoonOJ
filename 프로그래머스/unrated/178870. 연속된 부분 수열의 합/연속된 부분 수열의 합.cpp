#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer(2);
    
    int st = 0, ed = 0;
    int current = 0;
    int dis = 2147483647;
    
    // st에서 ed까지 더한 값이 k보다 크면 st증가
    // 작으면 ed만 증가
    while(ed < sequence.size()){
        current += sequence[ed];
        
        // st에서 ed까지의 합이 k인경우
        if(current == k)
        {
            // 길이가 짧은지 비교 짧으면 교체
            if(ed-st < dis)
            {
                answer[0] = st;
                answer[1] = ed;
                dis = ed-st;
            }
            
            // ed 증가하여 다음단계로
            ed++;
        }
        // k 보다 합이 큰경우
        else if(k < current)
        {
            // st만큼 빼주고 st증가
            current -= sequence[st++];
            // ed 값도 빼주어 다음 반복 시 중복 덧셈이 되지 않도록 한다.
            current -= sequence[ed];
        }
        // 작은 경우 ed 증가
        else
        {
            ed++;
        }
    }
    return answer;
}