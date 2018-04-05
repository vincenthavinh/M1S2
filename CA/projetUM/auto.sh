#!/bin/bash

#on cree les executables de la um et du compilateur toSum
cd ./um;
make;
cd ../sum;
make;
cd ..;

#on les deplace dans le dossier tests/
mv -f ./um/um ./tests;
mv -f ./sum/toSum ./tests;

cd ./tests;

chmod u+x um;
chmod u+x toSum;

#on compile les fichiers test*.sum en test*.um
for file in ./*.sum 
do
	./toSum "$file";
done	

#on execute les test*.um par la UM et on redirige la sortie dans test*.um.out
for file in ./*.um 
do
	./um "$file" > "$file.out";
done

#on compare chaque fichier test*.um.out avec son test*.output (sortie attendue)
printf "\n\n=====COMPARAISON sortie UM produite / sortie .output attendue=====\n";
printf "      (test-Negatif.sum rate, temoin negatif)\n\n";
for file in ./*.um
do
	printf "=====processing ${file%.*}.sum.....=====\n"
	diff "${file%.*}.um.out" "${file%.*}.output";
done
printf "\n=====Fin de la COMPARAISON =====\n\n";

#nettoyage des fichiers temporaires dans le repertoire tests/
read -p "nettoyer fichiers sorties UM et executables ?(y/n) " varname
rm -f ./*.um.out ./*.um;
rm -f ./toSum ./um;