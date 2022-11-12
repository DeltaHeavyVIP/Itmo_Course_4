#include <stdio.h>
#include <inttypes.h>
#include <string.h>

int main() {
	char* buffer = NULL;
	size_t length = 0;
	ssize_t read;

	int i;

	while(read = getline(&buffer, &length, stdin) > 0) {
		for(i = 0; i < strlen(buffer); i+=2) {
			int a = (buffer[i] >= 'a' && buffer[i] <= 'z' ? buffer[i] - 'a' + 10 : buffer[i] - '0');
			int b = (buffer[i+1] >= 'a' && buffer[i+1] <= 'z' ? buffer[i+1] - 'a' + 10 : buffer[i+1] - '0');
			printf("%c", a*16+b);
		}
	}
	return 0;
}

