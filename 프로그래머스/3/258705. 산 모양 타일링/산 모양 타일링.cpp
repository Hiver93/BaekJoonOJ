#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> tops) {
    int answer = 0;
    int arr[300002]{0,1,2,(tops[0] == 1 ? 3 : 2),0};
    
    for(int i = 4; i < 3*n+2; ++i){
        if(i % 3 == 0){
            if(tops[i/3-1] == 1){
                arr[i] = (arr[i-1] + arr[i-2]) % 10007;
            }
            else{
                arr[i] = arr[i-1] % 10007;
            }
        }
        else if(i % 3 == 1){
            arr[i] = (arr[i-3] + arr[i-1]) % 10007;
        }
        else{
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
    return arr[3*n+1];
}