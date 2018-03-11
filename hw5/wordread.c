#include<string.h>
#include<stdio.h>

int main(){
    FILE *fp = NULL;
    int i = 1;
    char filename[100];

    char *token[10000];

    int j = 0;
    int k = 0;
    int multi_count = 0;
    for (i = 1; i <= 363; i++){
        
        if (i < 10)
            strcat(filename, "00");
        if (i >= 10 || i < 100)
            strcat(filename, "0");
        char buffer[20];
        itoa(i, buffer, 10);
        strcat(filename, buffer);
        strcat(filename, ".txt");
        fp = fopen(filename, read);

        char *line = NULL;
        size_t len = 0;
        ssize_t nread;

        while ((nread = getline(&line, &len, stream)) != -1){
            token[j] = strtok(line, " ");
                while (token[j] != NULL){
                    j++;
                    token[j] = strktok(NULL, " ");
                    while (k = 0; k < j; k++){
                        if (strcmp(token[j],token[k] ) == 0)
                            multi_count++;
                    }
                }
        }
    
    }
    for (i = 1; i <= 363; i++){
        printf("%i words in total", j);
        printf("%i distinct words", j - multi_count);
    }
    return 0;
}
