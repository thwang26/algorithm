#include <stdio.h>

int main()
{
    int N1, N2, N3;
    scanf("%d%d%d", &N1, &N2, &N3);
    if (N1 != N2 && N1 != N3 && N2 != N3)
    {
        if (N1 > N2 && N1 > N3)
            printf("%d", N1*100);
        else if (N2 > N1 && N2 > N3)
            printf("%d", N2*100);
        else if (N3 > N2 && N3 > N1)
            printf("%d", N3*100);
    }
    if (N1 == N2 && N1 == N3)
    {    
        printf("%d", 10000+(N1*1000));
        return (0);
    }
    if (N1 == N2)
        printf("%d", 1000+(N1*100));
    else if (N1 == N3)
        printf("%d", 1000+(N1*100));
    else if (N3 == N2)
        printf("%d", 1000+(N2*100));
}