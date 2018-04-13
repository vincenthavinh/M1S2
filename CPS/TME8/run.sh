spin -a sfeu.pml
gcc -DSAFETY -O2 pan.c -o pan
./pan -D > feu.dot
dot -Tpdf feu.dot -o feu.dot.pdf
acroread feu.dot.pdf
rm -f pan.*
