#include <string>
#include <vector>
using namespace std;
int arr[1000001]{0};

int solution(int x, int y, int n) {
    int answer = 0;
    
    for(int i = 0; i <= y; ++i){
        arr[i] = -1;
    }
    arr[x] = 0;
    for(int i = x+1; i <= y; ++i){
        int tmp = 987654321;
        if(x <= i-n && arr[i-n] != -1){
            tmp = arr[i-n] + 1;
        }
        if(i % 2 == 0 && x <= i / 2 && arr[i/2] != -1 && arr[i/2] + 1 < tmp){
            tmp = arr[i/2] + 1;
        }
        if(i % 3 == 0 && x <= i / 3 && arr[i/3] != -1 && arr[i/3] + 1 < tmp){
            tmp = arr[i/3] + 1;
        }
        if(tmp == 987654321){
            arr[i] = -1;
        }
        else{
            arr[i] = tmp;
        }
    }
    
    return arr[y];
}