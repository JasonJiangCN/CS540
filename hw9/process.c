#include<stdio.c>
int main(){
    
    FILE* fp = fopen("data.txt", r+){
        char* str = malloc(10000);
        
        while (fgets(str, 10, fp) != NULL){
            char* a = strtok(str, ' ');
            char* b = strtok(NULL, ' ');
            printf("put(%s, %s);",a, b);
        }
    
    }
}
