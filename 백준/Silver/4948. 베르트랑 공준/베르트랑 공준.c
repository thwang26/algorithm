#include <stdio.h>

int sosu(int M)
{
    int n;
    n = 2;
    while(M >= n*n)
    {
        if(M % n == 0)
            return (0);
        n++;
    }
    return(M);
}

int main()
{
    int M, N, sum;
    while (1)
    {
        scanf("%d", &M);
        if (M == 0)
            return (0);
        sum = 0;
        N = 2*M;
        M++;
        while(M <= N)
        {
            if (M>7&&(M%2==0||M%3==0||M%5==0||M%7==0))
            {
                M++;
                continue;
            }
            if (sosu(M) != 0)
                sum++;
            M++;
        }
        printf("%d\n", sum);
    }
}