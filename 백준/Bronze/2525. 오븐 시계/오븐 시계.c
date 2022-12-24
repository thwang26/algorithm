#include <stdio.h>

int main()
{
    int H, M, T;
    int time;
    scanf("%d%d%d", &H, &M, &T);
    time = M + T;
    if(time >= 60)
    {   
        while (time >= 60)
        {
            time = time - 60;
            H++;
            if (H == 24)
                H = 0;
        }
    }
    printf("%d %d", H, time);
}