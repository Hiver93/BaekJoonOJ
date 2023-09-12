#include <iostream>

using namespace std;

string str1;

string str2;

int result[1001]{0};

int main() {

    cin >> str1 >>str2;

    int ans = 0;

    for(int i = 0; i<str1.size(); ++i){

        char curA = str1[i];

        int r = 0;

        

        for(int j = 0; j< str2.size(); ++j){

            int cR = result[j];

            if(str2[j] == curA ){

                result[j] = r+1;

            }

            if(r < cR)

                r = cR;

        }

    }

    

    for(int i = 0; i< str2.size(); ++i)

    {

        if(ans < result[i]){

            ans = result[i];

        }

    }

    

    cout << ans;

    

    return 0;

}