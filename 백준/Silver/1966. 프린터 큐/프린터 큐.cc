#include <iostream>
#include <queue>
using namespace std;

int main() {
    int tc;
    cin >> tc;
    while(tc--)
    {
        queue<int> q;
        int n , target;
        int arr[10]{0};
        int idx = 9;
        int ans = 0;
        cin >> n >> target;
        for(int i = 0; i < n; ++i)
        {
            int tmp;
            cin >> tmp;
            arr[tmp]++;
            q.push(tmp);
        }
        while(1)
        {
            while(!arr[idx])idx--;
            
            if(q.front() < idx)
            {
                q.push(q.front());
                q.pop();
                target--;
                if(target < 0)
                    target = q.size() -1;
            }
            else
            {
                ans++;
                arr[idx]--;
                if(target == 0)
                    break;
                q.pop();
                target--;
                if(target == -1)
                    target = q.size()-1;
            }
        }
        cout << ans << endl;
    }
    return 0;
}