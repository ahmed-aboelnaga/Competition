Auteur : PATHER Stevenson et Aboelnaga Ahmed

Le but du TP est d'apprendre à écrire une classe, la documentation et d’utiliser une méthodologie rigoureuse basée sur les tests unitaires.

La compilation des différents fichiers se fait de la façon suivante dans en utilisant la commande qui suit un terminal à l'emplacement du dossier qui contient le fichier :

    $ javac nomDuFichier.java

La documentation d'un fichier java peut être générée à l'aide de l'outil javadoc. Dans le dossier contenant le fichier Bike.java par exemple
exécution de la commande :

    javadoc Bike.java -d docs
    
(où L'option -d docs permet dans placer les fichiers générés dans un dossier docs) permet de générer la documentation du fichier indiqué (ici Bike.java).

Question 4

    On peut constater que suite à la compilation de la classe Bike, le type BikeModel a lui aussi été compilé. Le fichier BikeModel.java définit les différents modèles de Bike possibles dans une variable du type enum. Qui contient les trois modèles de Bike possibles à savoir CLASSICAL, ELECTRIC et TANDEM.

Question 8

    8.1) On peut définir cette information en mettant une variable dans
         la classe Bike contenant le prix de la location.

    8.2) static double price=10 (voir Bike.java)

Le reste du travail demandé (écriture de code) se trouve dans les fichiers BikeMain.java, BikeStation.java et BikeStationMain.java. Les tests nécessite la compilation du fichier contenant la classe. Mais aussi du fichier contenant les tests grâce à la commande :

    $ javac -classpath test-1.7.jar test/BikeStationTest.java

Et l'exécution de ceux-ci grâce à la commande :

    $ java -jar test-1.7.jar BikeStationTest

(pour les tests de BikeStationTest par exemple).