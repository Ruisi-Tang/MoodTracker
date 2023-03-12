# Mood Tracker App

This Mood Tracker App is an Android application developed for the BCIT Hack the Break 2023 Hackathon. This app allows users to track their daily moods and store the information in a local database on their device for later review. 


## Inspiration

People nowadays are busy and stressful all the time due to a fast-paced, highly competetive social environment. Especially in Winter time in Vancouver, the lacking of sunlight can make people moody for weeks. In this case, many people find that tracking their moods can be important in managing their mental health and overall well-being. By recording and monitoring their moods over time, people can gain insight into patterns and triggers that may be impacting their emotional state. This information can then be used to make lifestyle adjustments, seek professional help if necessary, or simply to become more self-aware. Additionally, a mood tracker app can serve as a reminder to check in with oneself and prioritize self-care in a busy and often stressful world.


## What it does

* Record your mood for each day
* View your mood history

## How I built it 

The project was coded by Java on Android Studio. I implemented the front-end user interface with XML and programed the behaviour of the XML elements with Activity Java files. This app will generate a light-weighted database on user's device once finished installation. This database is for user to store their past data (their moods). I utilized the SQLite library to implemented the Creating and Reading of the database.

## Challange I run into 

The biggest chanllage I ran into was to create the custom ListView to list the user's past moods. To override the getView method inside the ArrayAdaptor has confused me a lot. Luckly with the help of Youtubers, StackOverFlow, Android Studio Docs and ChatGPT, I was able to eventually figured it out after three hours of struggling. 🤓

## Accomplishments that i was proud of

As a beginner developer, the Mood Tracker App is the first App I have ever made in my life and I coded it from scracth by myself in less than 48 hours. This is also my first-time Hackathon. It may be a toy project, but I do learn a lot and it also means a lot to me!

## What I learned

*Use of Android Studio
*Android Frontend implementation
*SQLite Database
*Git

##What's next for Mood Tracker App

There are certainly a lot still can be improved for this app, things like:
*Utilize a open source graph generator library to generate a report for database data for a better visualization. 
*Add a login feature to protect the user's pravicy
*Improve the UI/UX design of the app for a smoother user experience. 
