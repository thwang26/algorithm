#include <stdio.h>

int sosu(int N)
{
    int n;
    n = 2;
    while(N >= n*n)
    {
        if(N % n == 0)
            return (0);
        n++;
    }
    return(N);
}

int main()
{
    int T, A, B, N;
    scanf("%d", &T);
    while(T != 0)
    {
        scanf("%d", &N);
        A = N/2;  
        while(1)
        {
            B = N-A;
            if (sosu(A) != 0 && sosu(B) != 0)
            {
                printf("%d %d\n", A, B);
                break;
            }
            else
                A--;
        }
        T--;
    }
}