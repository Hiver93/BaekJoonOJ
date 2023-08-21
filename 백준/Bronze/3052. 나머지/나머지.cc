#include<iostream>
using namespace std;

int main()
{
    int arr[10];
    int len=sizeof(arr)/sizeof(arr[0]);
    int t=len;
    for(int i=0; i<len;i++)
    {
       cin >> arr[i];
    }
    
    for(int i=0; i<len;i++)
    {
       for(int j=i+1; j<len;j++)
         {
           
            
             for(int k=i-1; k>=0; k--)
                {
                  if(arr[i]%42==arr[k]%42)
                    {
                     j = len+1;
                     break;
                     }
                }
            if(j==len+1)
            break;
           
             if(arr[i]%42==arr[j]%42)
             {
            t--;
            
            }
            
        }
    }
    cout << t;
    return 0;
}