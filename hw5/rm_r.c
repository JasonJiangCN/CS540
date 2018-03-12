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
    FILE *newFile;
    for (int i = 1; i <= 363; i++){
        char filename[100];
        strcpy(filename, "./docs/");
        if (i < 10)
            strcat(filename, "00");
        if (i >= 10 && i < 100)
            strcat(filename, "0");
        char buffer[400];
        sprintf(buffer, "%d", i);
        strcat(filename, buffer);
        strcat(filename, ".txt");
        fp = fopen(filename, "r");
        char newfilename[100];
        char* temp = strchr(filename, 's');
        strcpy(newfilename, "./doc");
        temp = temp + 1;
        strcat(newfilename, temp);
        newFile = fopen(newfilename, "w+");
        if (fp == NULL) {
            //if failed to open an file, exit
            printf("my-cat: cannot open file\n");
            exit(1);
        }


        char ch;
        while((ch = fgetc(fp)) != EOF && ch != '\0') {
            if (ch == '\t')
                continue;
            if (ch == '\r')
                fputc('\n', newFile);
            fputc(ch, newFile);

        }
        fclose(fp);
        fclose(newFile);
    }
}

