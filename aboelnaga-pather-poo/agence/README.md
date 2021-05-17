Auteur : Aboelnaga Ahmed

Les objectifs principaux du TP sont de savoir des Interfaces, des Collections. Comprendre le principe de super classe et de sous classe. Et de savoir à partir d'une super classe comment organiser et quelle méthode réécrire avec modification dans les sous classes en fonction de l'intérêt de la sous classe.

Question 7) Comment gérer au mieux ce surcoût dans le code ?

    Nous proposons de réécrire la méthode rentVehicle de la super classe RentalAgency dans la sous classe SuspiciousRentalAgency pour que celle-ci est sa propre gestion du prix de location qu'elle va renvoyer en fonction de l'âge du client. Ainsi lors de l'appel de la méthode rentVehicle sur un objet du type SuspiciousRentalAgency c'est la méthode de la sous classe SuspiciousRentalAgency qui va être exécuter et non celui  de la super classe RentalAgency qui elle ne fait aucune modification du prix de location.

La compilation des différents fichiers avec redirection dans un dossier classes se fait de la façon suivante dans en utilisant la commande qui suit dans un terminal en se trouvant dans le dossier src :
    
    $ javac rental/NomDeLaClasse.java -d ../classes

Pour la compilation des tests par exemple RentalAgencyTest et en supposant l'existance du dossier classes. Utiliser la commande ci-dessous en vous plaçant dans le dossier racine du projet :

    $ javac -classpath test-1.7.jar test/rental/RentalAgencyTest.java

Pour l'exécution Utiliser la commande ci-dessous en vous plaçant dans le dossier racine du projet :

    $ java -jar test-1.7.jar rental.RentalAgencyTest

Remarque : Une barre verte est affiché si tous les tests sont réussis dans la fênetre JUnit suite à l'exécution de la commande.

Toujours dans le même dossier (src) l'exécution de la commande qui suit permet la génération de la documentation des fichiers dans rental :

    $ javadoc -d ../docs -subpackages rental

(où L'option -d docs permet dans placer les fichiers générés dans un dossier docs)

L'exécution du fichier class RentalAgencyMain peut se faire en se plaçant dans le dossier source du projet et en utilisant la commande :

    $ java -classpath classes rental.RentalAgencyMain

Pour ce faire nous allons créer un fichier appli.jar qui contient, compressés, tous les fichiers de l'arborescence dont la racine est le dossier rental dans notre TP. Utiliser cette commande en vous plaçant dans le dossier classes. Qui va créer ce fichier .jar dans le dossier du projet :

    $ jar cvf ../appli.jar rental

Pour visualiser le contenu de l'archive appli.jar créé dans notre exemple ci-dessus. Utiliser la commande :

    $ jar tvf appli.jar

Pour permettre d'indiquer que le main à executer est RentalAgencyMain. Nous créeons le fichier manifest-ex avec pour contenu :

    Main-Class: rental.RentalAgencyMain

Placez vous dans le dossier classes, exécutez la commande :
    
    jar cvfm ../appli.jar ../manifest-ex rental

Allez dans le dossier agence et exécutez la commande : 

    java -jar appli.jar





