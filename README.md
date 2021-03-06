# CardHunterUtils
Deck manager and party builder utility for Card Hunter by Blue Manchu

# What It Does
* Complete listing of all items and cards in the game
* Search and sort items by name, rarity, type, tokens, etc.
* Import parties from the game/forum bbCode format (using `partybbcode` command)
* Save/load parties
* Generate an HTML view of item cards / all cards, for searching in card text

# What It Looks Like

## Party View
<img width="1552" alt="partyview" src="https://cloud.githubusercontent.com/assets/750196/9563854/c2cc30dc-4e60-11e5-9d32-f518419be975.png">

## Item Search/Filter
<img width="1552" alt="filters" src="https://cloud.githubusercontent.com/assets/750196/9564090/befbb808-4e68-11e5-9007-025a2b7eaf98.png">

## Item Card Inspector
<img width="1524" alt="itemcards" src="https://cloud.githubusercontent.com/assets/750196/9569977/1a5b25d0-4f4a-11e5-887e-e0a3c93c0394.png">

## HTML Card Viewer
<img width="1552" alt="allcards" src="https://cloud.githubusercontent.com/assets/750196/9569953/bb4246dc-4f49-11e5-8edc-c504c6f43147.png">

# How To Run It
Grab the latest published `cardhunterutils.jar` file from [our Card Hunter Forums thread](http://forums.cardhunter.com/threads/card-hunter-utility-program.7377/).  Get a fairly recent [version of Java](https://java.com/en/download/), if you don't have one already.  

Mix lightly in a command prompt, separating ingredients with spaces (` `).  Add the `java` first, followed by `-jar`.  Finally, add the path to the downloaded `cardhunterutils.jar` file.  Press enter and serve immediately.

We'll get builds published here on Github... you know, ... *Real Soon Now*.

**ALSO**: For the utmost in gorgeous card art, make sure you have a non-crappy version of the Garamond font installed.  We highly recommend the beautiful [Garamond No. 8](http://garamond.org/), available as a free download [here](http://garamond.org/urw/). [This Garamond](http://www.fontage.com/_zips/garamond.zip), on the other hand, is hella crappy.  We warned you.

# What's Happening Now
Check out the current issues list on [the Github page](https://github.com/Xayrn/CardHunterUtils/issues), or check out [the thread](http://forums.cardhunter.com/threads/card-hunter-utility-program.7377/) at the Card Hunter forums.

# Can I Help?
Yup.  See below for getting started as a developer.

-----

# Developer Setup

## For Windows:
Follow the steps in [this guide](http://javapapo.blogspot.com/2013/03/setup-your-java-development-environment.html) to get a Java development environment.
    
### Note: 
One small gotcha is that the Maven cmd, `mvn`, gets unhappy if the path you are running from has no spaces or is a drive root.
    
If you're planning to work in such a path as your dev folder, work around this by modifying the `mvn.cmd` file in `%MAVEN_HOME%\bin\mvn.cmd` as follows:
    
1. Find the line that starts with

    `%MAVEN_JAVA_EXE% %JVM_CONFIG_MAVEN_PROPS% %MAVEN_OPTS%`
    
2.    Remove the quotes around

    `"-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%"`
    
    So that it becomes
    
    `-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%`
    
## For Mac OSX:
Install the latest [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
	
1. Set your `JAVA_HOME` variable in your shell's rc file (e.g. `.zshrc`):

	`export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home`
	
	(Note your Java SDK version may be different)
	
2. Install ant and maven via brew:

	`brew install ant`

	`brew install maven`
	
	(you may need to `brew update` before you do these)
	
3. Set your `MAVEN_HOME` variable in your rc file as well:

	`export MAVEN_HOME=/usr/local/Cellar/maven/3.3.3`

(If you didn't install ant via homebrew, you will also need to set your `ANT_HOME` variable to wherever your manual ant install lives.  For whatever reason, homebrew doesn't set it, because [homebrew doesn't like that](https://github.com/Homebrew/homebrew/issues/32851).

## Confirming Environment
You should now be able to run the following:

`echo %JAVA_HOME%` (Win) or `echo $JAVA_HOME` (OSX)

`ant -version`

`mvn -version`

and see happy responses.  