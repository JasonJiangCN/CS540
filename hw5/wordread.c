#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE *fp = NULL;
    int i = 1;

    char **token = malloc(1000000);
    for (int a = 0; a < 1000000; a++){
        token[a] = malloc(1000);
    }

    int j = 0;
    int k = 0;
    int multi_count = 0;
    for (i = 1; i <= 363; i++){

        char filename[100];

        strcpy(filename, "./docs/");
        if (i < 10)
            strcat(filename, "00");
        if (i >= 10 && i < 100)
            strcat(filename, "0");
        char buffer[20];
        sprintf(buffer, "%d", i);
        strcat(filename, buffer);
        strcat(filename, ".txt");
        fp = fopen(filename, "r");


        char line[100000];
        fgets(line, 100000, fp);
        for (int c = 0; c < strlen(line); c++){
            if (line[c] == '\r')
                line[c] = ' ';
        }
        token[j] = strtok(line, " ");
        while (token[j] != NULL){
            for (k = 0; k < j -1; k++){
                if (strcmp(token[j],token[k]) == 0)
                    multi_count++;
            }
            j++;
            token[j] = strtok(NULL, " ");
        }

        fclose(fp);
    }
    for (i = 1; i <= 363; i++){
        printf("%i words in total", j);
        printf("%i distinct words", j - multi_count);
    }
    return 0;
}
