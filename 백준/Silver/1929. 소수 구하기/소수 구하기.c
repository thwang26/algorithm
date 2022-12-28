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
    int M, N;
    scanf("%d %d", &M, &N);
    if (M == 1)
        M++;
    while(M <= N)
    {
        if (sosu(M) != 0)
            printf("%d\n", M);
        M++;
    }
}