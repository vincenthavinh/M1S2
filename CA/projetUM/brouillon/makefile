um: um.c makefile
	gcc -Wall -m32 -O3 -fomit-frame-pointer $< -o $@

um-i686: um.c makefile
	gcc -Wall -O3 -fomit-frame-pointer -march=i686 $< -o $@
clean: 
	$(RM) um um-i686

all: um um-i686


.PHONY: clean all
