Auteur: Vincent Ha-Vinh 3305492

#Comment compiler et tester le projet :

Le code source est séparé en 2 dossiers indépendants :um et sum.
Pour les compiler, 2 options :
	-1: manuellement (avec les Makefile)
	-2: automatiquement (script de test ./auto.sh à la racine)

##1: manuellement

Dans le dossier ./um/, utiliser make.
prérequis : 
	-on compile avec gcc -m32.
	 ce flag permet entre autres d'utiliser les tailles 
	 en octets dans un système 32 bits des différents types C.
	 (notamment uint sur 4 octets)
	-MAIS gcc a besoin du package "gcc-multilib" pour compiler
	 des executables 32bits sur des OS 64 bits.
	 Donc si à la compilation, cette erreur est obtenue :
	 "fatal error: sys/cdefs.h: No such file or directory"
	 Il faut faire : sudo apt-get install gcc-multilib

après compilation, on peut tester directement la UM avec :
./um sandmark.umz
(chmod peut-être nécessaire)

Dans le dossier ./sum/, utiliser make.
prérequis :
	-avoir ocaml, ocamlyacc et ocamllex installés.
	 (si problème alors qu'ils sont déjà installés, changer les
	  variables d'accès aux commandes dans le Makefile)

après compilation, on peut tester directement le compilateur SUM avec :
./toSum
(chmod peut-être nécessaire)
puis en tapant: print "test abc"
Cela produira un fichier test-stdin.um exécutable par une UM.


##2: automatiquement

à la racine du projet, lancer le script ./auto.sh
ce script : 
	-lance les commandes make des Makefiledes 2 dossiers
	-déplace les exécutables um et toSum dans le dossier ./tests
	-compile les test*.sum en test*.um avec toSum
	-exécute chaque test*.um avec la machine universelle UM et redirige 
	 la sortie sur test*.um.out
	-compare chaque sortie produite test*.um.out à la sortie attendue
	 test.output
	-propose de supprimer les fichiers temporaires produits dans ./tests

.
