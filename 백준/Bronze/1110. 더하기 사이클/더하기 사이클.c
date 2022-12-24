#include <stdio.h>

int main()
{
    int N;
    int MN;
    int FN = -1;
    int cnt = 0;
    scanf("%d", &N);
    MN = N;
    while (N != FN)
    {
        FN = (MN % 10) * 10 + (MN / 10 + MN % 10) % 10;
        MN = FN;
        cnt++;
    }
    printf("%d\n", cnt);
}