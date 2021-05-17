Auteur : Aboelnaga Ahmed

Les objectifs principaux du TP sont l'organisation des différents fichiers nécessaires dans un projet. Ici principalement l'utilisation de plusieurs classes dans une classe avec une arborescence cohérente. L'importation de ceux-ci en package pour l'usage. Savoir écrire soi-même des fichiers tests pour les classes. La création d'une archive java (JAR) pour le TP. Ainsi qu'un JAR exécutable.

Remarque : Le dossier tmp et son contenu est volontairement laissé dans le rendu car fait parti de question demander dans le TP


La compilation des différents fichiers avec redirection dans un dossier classes se fait de la façon suivante dans en utilisant la commande qui suit dans un terminal en se trouvant dans le dossier src :
    
    $ javac example/Robot.java -d ../classes

Pour la compilation de BoxTest et en supposant l'existance du dossier classes utiliser la commande ci-dessous en vous plaçant dans le dossier racine du projet :

    javac -classpath test-1.7.jar test/BoxTest.java

Pour l'exécution des tests de BoxTest par exemple. Utiliser cette commande en étant toujours dans le dossier du projet :

    java -jar test-1.7.jar BoxTest

Remarque : Une barre verte est affiché si tous les tests sont réussis dans la fênetre JUnit suite à l'exécution de la commande.

Toujours dans le même dossier (src) l'exécution de la commande qui suit permet la génération de la documentation du paquetage example et de tous ses sous-paquetages :

    $ javadoc -d ../docs -subpackages example
    
(où L'option -d docs permet dans placer les fichiers générés dans un dossier docs)

L'exécution d'un fichier class (Robot.class par exemple) peut se faire en se plaçant dans le dossier source du projet et en utilisant la commande :

    java -classpath classes example.Robot

Pour créer un fichier (appli.jar par exemple) qui contient, compressés, tous les fichiers de l'arborescence dont la racine est le dossier example dans notre exemple. Utiliser cette commande en vous plaçant dans la dossier classes. Qui va créer ce fichier .jar dans la dossier du projet :

    jar cvf ../appli.jar example

Pour visualiser le contenu de l'archive appli.jar créé dans notre exemple ci-dessus. Utiliser la commande :

    jar tvf appli.jar

Pour permettre l'exécution d'un .jar donc de permettre la définition d'un main à exécuter. Il faut créer un fichier manifest (dans notre exemple manifest-ex). Contenant les informations nécessaire pour permettre l'exécution d'une fonction main d'une classe à l'exécution de notre archive .jar, dans notre exemple la main de Robot:

    Main-Class: example.Robot

Placez vous dans le dossier classes, exécutez la commande :
    
    jar cvfm ../appli.jar ../manifest-ex example

Vous avez créé la même archive que précédemment mais en y ajoutant les informations contenues dans le fichier manifest-ex. Ces informations sont stockées dans le fichier META-INF/MANIFEST.MF de l’archive.

Allez dans le dossier tp4 et exécutez la commande : 

    java -jar appli.jar
    
le manifeste de l’archive est automatiquement utilisé pour déterminer le main à exécuter. Le CLASSPATH utilisé intègre automatiquement
les fichiers de l’archive, il est donc inutile de préciser quoi que ce soit ici. Et la fonction main du fichier Robot.java est bien exécutée.
