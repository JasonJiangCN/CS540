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
    char buffer1[80];
    FILE *newFile = fopen("./output.txt", "w+");
    for (int i = 1; i <= 363; i++){

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

        if (fp == NULL) {
            //if failed to open an file, exit
            printf("my-cat: cannot open file\n");
            exit(1);
        }
        while (1){
            //if there is a line, print it.
            if (fgets(buffer1, 80, fp)!= NULL) 
                fprintf(newFile,"%s", buffer1);
            else
                //when reach the end, break the loop 
                break;
        }
        fclose(fp);
    }
}

