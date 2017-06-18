#include<string>
#include<cmath>
#include<iostream>
#include<cstdlib>
#include<vector>

using namespace std;

class InterestingDigits{
    public:
    vector<int> temp;

    vector <int> digits(int base)
    {
        for(int ii=2;ii<base;ii++)
        {
            select(ii,base);
        }
        return temp;
    }
    private:
    int select(int a,int b)
    {
        int ttt=0;
        int tmp=0;
        int tag=0;
        for(int i=0;i<999;i++)
        {
            ttt=0;
            tmp=a*i;
            while(tmp!=0)
            {
                ttt+=tmp%b;
                tmp/=b;
            }
            if(ttt%a!=0)
                tag=1;
        }
        if(tag==0)
            temp.push_back(a);
        return 0;
    }
};