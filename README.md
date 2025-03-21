# BirdList
## Description
A webapp made to be able to store a large amount of characters, outfits of characters and versioning of said outfits informations. Sort of a character card system to keep track of the progression of your Original Characters.

## Way to launch the app
- Compile it yourself on linux with "mvn springboot:run" command (needs maven and java 18). You will also need to setup a mysql server with identifications of it changed in the "application.properties" file (URL, username, password of said database).
- Use docker: with docker installed and running (on any devices) use the docker compose file. Or if you're on windows just double click the "start.bat" and when you're done with the application or want to stop it form using your ressources double-click the "stop.bat".
- In both cases when it's launched, open your browser on "http://localhost:8080/"