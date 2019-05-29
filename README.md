# Trivia
# Minor Programmeren
# By Levy van der Linde

Trivia is a game of questions that are provided through a Trivia Question API in JSON format.
Once someone opens the app ‘’Trivia’’ it’ll show a welcome screen! 

The user can choose to play a game  of see the current highscores.

### Playing the game

The game has two types of questions, multiple choice questions and questions which are ‘false or true’.
Also every question had it’s own difficulty that’s presented on the screen.

So how do you create a new highscore? Well the app keeps track of your scores! Everytime you answer a question you can earn points by chosing the right answer.

### Welcoming screen

<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58593338-e9abb780-826a-11e9-91b3-8fa77a412657.png">

### Press start to play trivia

<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58593374-0647ef80-826b-11e9-803f-4922fdef59c5.png">

### Answering the first question
The app will tell if the user had answered the question incorrect or not. Depending on that the score will be updated if the answer was correct.

<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58593409-15c73880-826b-11e9-8fb5-2f5c4e73232d.png">

<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58593446-2b3c6280-826b-11e9-92c6-cb7dafc696f7.png">

### Submitting your score after playing trivia

<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58593537-6e96d100-826b-11e9-94e3-0e0b105a3430.png">

### Online storage of the highscores
Unfortunately the online storage doesn't work as planned. The implementation isn't done yet so the user can submit his or hers highscore with a name but it won't show in the highscore list. This is because the connection with the database failed.
It was supposed to show the highscores in the white listview:

<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58593640-bfa6c500-826b-11e9-9151-df1f33f33f28.png">
