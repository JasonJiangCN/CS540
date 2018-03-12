#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*
 * main funtion of the program
 * argc: the number of arguments
 * argv: the array of values of arguments
 */
int main(int argc, char *argv[]) {
    FILE *fp;
    char *buffer1 = malloc(1000);
    FILE *newFile = fopen("./frequency.txt", "w+");
    int j = 0;
    char **token = malloc(230000*1000);
    int multi_count = 0;
    typedef struct word {
        char str[15];
        int freq;
    } word;
    struct word *words = malloc(8*15000000);
    for (int i = 1; i <= 363; i++){

        char filename[100];
        strcpy(filename, "./doc/");
        if (i < 10)
            strcat(filename, "00");
        if (i >= 10 && i < 100)
            strcat(filename, "0");
        char buffer[400];
        sprintf(buffer, "%d", i);
        strcat(filename, buffer);
        strcat(filename, ".txt");
        fp = fopen(filename, "r");

       // printf("%s", filename);
        if (fp == NULL) {
            //if failed to open an file, exit
            printf("my-cat: cannot open file\n");
            exit(1);
        }
        int k = 0;
         
        while (1){
            //if there is a line, print it.
            if (fgets(buffer1, 1000, fp)!= NULL) {
                token[j] = strtok(buffer1, " ");
                while (token[j] != NULL){
                    int isFound = 0;
                    if (token[j][0] != '\0'){
                        for (k = 0; k < j ; k ++){
                            if (strcmp(token[j], words[k].str) == 0){
                                words[k].freq++;
                                isFound = 1;
                                break;
                            }
                        } 
                        if (isFound == 0){
                            strcpy(words[multi_count].str,token[j]);
                            words[multi_count].freq = 1;
                            multi_count++;
                        }

                        j++;
                    } 
                    token[j] = strtok(NULL, " ");
                }
                j = j -1;


                //fprintf(newFile,"%s", buffer1);
            }

            else
                //when reach the end, break the loop 
                break;
        }

        fclose(fp);

        fflush(fp);
    }
    printf("%d words in toal\n", j+1);
    printf("%d distinct words", multi_count);
   // for (int in1 = 0; in1 < j; in1++){
    //    fprintf(newFile, "%s \n", token[in1]);
   // }
    //sort
    for (int in = 0; in < multi_count; in++){
        for (int in2 = in+1; in2 < multi_count; in2++){
            if (words[in].freq < words[in2].freq){
                int temp = words[in].freq;
                words[in].freq = words[in2].freq;
                words[in2].freq = temp;
            }
        }
    }
    for (int in = 0; in < multi_count; in++){
        fprintf(newFile, "%s %d\n", words[in].str, words[in].freq);
    }
}

