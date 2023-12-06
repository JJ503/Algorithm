#include <stdio.h>

int main(void) {
    int a;
    int b;
    int i, j;
    
    scanf("%d %d", &a, &b);
    
    for (i = 1; i <= b; i++)
    {
        for (j = 1; j <= a; j++)
        {
            printf("*");
        }
        
        printf("\n");
    }
    
    return 0;
}