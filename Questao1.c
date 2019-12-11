#include  <stdio.h>

int main(void)
{
    float celsius, fahrenheit;

    printf("Informe uma temperatura em Celsius: ");
    scanf("%f", &celsius);

    fahrenheit = (9 * celsius + 160) / 5;

    printf("\n%.2f Celsius = %.2f Fahrenheit", celsius, fahrenheit);

    return 0;
}
