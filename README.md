# README
To open the app please clone it from the master branch :)
# Overview
* __Gustavo Rangel__
* YourDestiny
* The app that helps you understand your daily destiny.
* You can read all the zodiac signs, save them, and calculate people's zodiac signs using their date of birth. 

# Introduction:
YourDestiny is an innovative Android application that brings the mystical world of horoscopes to the fingertips of users, offering a personalized and immersive experience. It works with a sophisticated API to deliver daily horoscope readings for each zodiac sign, presented in a captivating and engaging user interface. As a premier horoscope app, I aim to provide users with insights into their daily lives, fostering a sense of connection with the cosmos.
## Key Features:
- Accurate Horoscope Predictions.
- Intuitive User Interface.
- Compatibility with all Android devices.
- Free and no ads.

# Development:
## API:
for my API I used https://horoscope-app-api.vercel.app/ it's a free API designed by Ashutosh Krishna. It was a great tool to use which I am thankful for. Simply adding the zodiac sign into the URL would return us a JSON file e.g. Aries would be:  https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=Aries&day=TODAY
We used Volley for pulling and displaying the data after the user has clicked on the zodiac sign they wish to read.

## Database: 
I used SQLite to store and display the horoscope that the users wished to see. This is displayed on the home screen “MainFragment” only when a horoscope has been saved.
for the database, I used a small database called "YourDestinyDB" and a table called "HoroscopesSaved" with 2 columns "Id" (auto-ascending generated) and "name" where I store the saved horoscopes by the user. which are identical to the call made to the API.
![DB](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot%202023-12-04%20021252.png)

## Professionalism:
One of the main aims of this project was to follow a professional approach when designing and developing the app. Therefore certain recommendations were put in place, such as, consistent commenting throughout the code along with a clean and organized code, The use of RecyclerViews for listening items or data with similarities, and the use of a single MainActivity and several fragments with a navigation resource file.

## User interface and interaction:	
### Landscape vs Portrait mode: 
I used Android Studio’s tool “Create Land Qualifier” in order to create an alternative Layout for the UI when the phone is on landscape or horizontal. This benefits heavily the user experience and usability among diverse Android devices.

### Layout:
It counts with an adaptive Layout that will fit in harmony with any Android device without looking clumsy

### Navigation: 
Users can move from fragment to fragment simply using the GUI buttons. Which was designed using the Resource Manager Navigation. It has in all the fragments a Bottom navigation bar which was implemented on each fragment individually rather than simply adding it to the MainActivity for reasons like, the size of the project, complexity, and room for more customization. The only fragment that doesn't have a bottom navigation bar is the HoroscopeDetail fragment. which only can be exited when using the back button or pressing the save button.

![Nav](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot%202023-12-04%20021045.png)

### Colors:
I chose a selection of dark colors to give the user a mythical and mysterious vibe, used grey, dark green, and white text mainly as you will see on the screenshots. 

### Font:
I chose cursive, sans-serif-black (which was used in white font color, black is just part of the name), and the standard one, Robot.

### Use case:

![usecase](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/UML%20class.png)

# Screenshots:
![1](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_133924.png)
![2](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_133956.png)
![3](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134031.png)
![4](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134116.png)
![5](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134157.png)
![6](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134215.png)
# Landscape:
![7](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134239.png)
![8](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134254.png)
![9](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134303.png)
![10](https://github.com/RobertGordonUniversity/cm3110-coursework-DefoNotGus/blob/main/images/Screenshots/Screenshot_20231203_134317.png)



