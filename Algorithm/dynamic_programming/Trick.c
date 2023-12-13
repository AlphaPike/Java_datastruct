/**
 * 最佳加法表达式：有一个由1~9组成的数字串。问如果将m个加号插入到这个数字串中，在各种可能形成的表达式中，值最小的那个表达式的值是多少
 */
 #include<cstdio>
 #include<iostream>
 #include<cmath>
 #include<algorithm>
 using namespace std;

 int number[100+1];		//存放输入的数字字符串
 long long num[100+1][100+1];
 long long dp[100+1][100+1];

 int m,n;
 // 存放所有的数的所有组合
 int Num(int i,int j)
 {
 	int k,sum=0,temp;
 	double t=j-i;
 	for(k=i;k<=j;++k,--t)
 	{
 		temp=pow(10,t);
 		sum=sum+number[k]*temp;
 	}
 	return sum;
 }
 void calculate(void)
 {
 	int i,j;
 	for(i=1;i<=n;++i)
 		for(j=i;j<=n;++j)
 			num[i][j]=Num(i,j);

 }
 int main()
 {
 	cin>>n>>m;				//在n个数字中插入m个加号
 	int i,j,p,minn=INT_MAX;
 	for(i=1;i<=n;++i)			//从下标为1开始存放
 		cin>>number[i];
 	calculate();
 	for(i=1;i<=n;++i)			//在i个数字中插入j个加号
 	{
 		for(j=0;j<=m;++j)
 		{
 			if(j==0)
 				dp[i][j]=num[1][i];
 			else if(i<=j)
 				dp[i][j]=INT_MAX;
 			else
 			{
 				minn=INT_MAX;
 				for(p=j;p<=i-1;++p)
 				{
 					if(minn>(dp[p][j-1]+num[p+1][i]))
 						minn=dp[p][j-1]+num[p+1][i];
 				}
 				dp[i][j]=minn;
 			}
 		}
 	}
 	cout<<dp[n][m]<<endl;
 	return 0;
 }
