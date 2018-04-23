#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){
    char *d = malloc(4);
    *d  = ' '; 
    FILE* fp = fopen("data.txt", "r");
    char str[20];

    while (fgets(str, 20, fp) != NULL){
        if (str[8] == '\n');
        str[8] = '\0';
        if (str[9] == '\n');
        str[9] = '\0';
        if (str[7] == '\n');
        str[7] = '\0';


        char* a = strtok(str, d);
        char* b = strtok(NULL, d);
        printf("put(%s, %s);",a, b);
    }


}
