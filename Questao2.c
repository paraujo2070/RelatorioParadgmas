#include  <stdio.h>

int main(void)
{
    int x, y;

    printf("\nDigite um número: ");
    scanf("%d", &x);

    printf("\nDigite outro número: ");
    scanf("%d", &y);

    if (x == y) {
        printf("\nOs números informados são iguais");
    }

    else if (x > y) {
        printf("\nOs números são diferentes sendo o primeiro maior que o segundo");
     }

    else {
        printf("\nOs números são diferentes sendo o segundo maior que o primeiro");
     }

    return 0;
}
