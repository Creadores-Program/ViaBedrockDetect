# ViaBedrockDetect
Detects when a Java player joins your server!


Compatible with Nukkit, Pocketmine and ViaProxy!

## Installation (ViaProxy)
Simply put the jar file in the plugins folder and restart the server

## Installation (Nukkit)
Simply place the plugin in the plugins folder!
### API usage
Implement in your project:
Maven:
Place the plugin's jar file in the libs folder and run this command:
```bash
mvn install:install-file -Dfile=libs/ViaBedrockDetect-x.x.x.jar -DgroupId=org.CreadoresProgram -DartifactId=ViaBedrockDetect -Dversion=x.x.x -Dpackaging=jar -DgeneratePom=true # replace x.x.x with the plugin version
```
pom.xml:
```xml
<dependency>
  <groupId>org.CreadoresProgram</groupId>
  <artifactId>ViaBedrockDetect</artifactId>
  <version>x.x.x</version><!--replace x.x.x with the plugin version-->
  <scope>provided</scope>
</dependency>
```
plugin.yml:
```yaml
#...
softdepend:
  - ViaBedrockDetect
loadbefore:
  - ViaBedrockDetect
```
example of use:
```java
//import the class into your plugin
import org.CreadoresProgram.ViaBedrockDetect.NukkitMain;
//...
//is Java Player?
NukkitMain.getInstance().isJavaPlayer(player);//player = cn.nukkit.Player returns boolean

//get all Java Players
NukkitMain.getInstance().getJavaPlayers(); //returns List<cn.nukkit.Player>
```

## Installation (Pocketmine)
Simply place the plugin in the plugins folder!
### API usage
Implement in your plugin:

plugin.yml:
```yaml
#...
softdepend: [ViaBedrockDetect]
```

example of use:
```php
<?php
declare(strict_types=1);
//...
//Use the class in your plugin.
use org\CreadoresProgram\ViaBedrockDetect\PocketmineMain;
//...
//is Java Player?
PocketmineMain::getInstance()->isJavaPlayer(player);//player = pocketmine\player\Player returns bool
//get all Java Players
PocketmineMain::getInstance()->getJavaPlayers(); //returns pocketmine\player\Player[] array
```
