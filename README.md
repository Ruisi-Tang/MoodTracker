# Mood Tracker App

This Mood Tracker App is an Android application developed for the BCIT Hack the Break 2023 Hackathon. This App allows users to track their daily moods and store the information in a local database on their device for later review.


## Inspiration

People nowadays are busy and stressed due to a fast-paced, highly competitive social environment. Especially in winter in Vancouver, the lack of sunlight can make people moody for weeks. In this case, many people find tracking their moods important in managing their mental health and overall well-being. By recording and monitoring their moods over time, people can gain insight into patterns and triggers that may impact their emotional state. This information can then be used to make lifestyle adjustments, seek professional help, or become more self-aware. Additionally, a mood tracker app can be a reminder to check in with oneself and prioritize self-care in a busy and often stressful world.


## What it does

* Record your mood for each day
* View your mood history

## How I built it 

I used Java to code the project on Android Studio. I implemented the front-end user interface with XML and programmed the behaviour of the XML elements with Activity Java files. After installation, this App will generate a light-weighted database on the user's device. This database allows users to store their past data (their moods). I utilized the SQLite library to implement the database's Creating and Reading.

## Challange I run into 

My biggest challenge was creating the custom ListView to list the user's past moods. Override the getView method inside the ArrayAdaptor has confused me a lot. Luckily with the help of Youtubers, StackOverFlow, Android Studio Docs and ChatGPT, I was able to eventually figured it out after three hours of struggling. 🤓

## Accomplishments that I was proud of

As a beginner developer, the Mood Tracker App is the first App I have ever made in my life, and I coded it from scratch by myself in less than 48 hours. This is also my first-time Hackathon. It may be a toy project, but I do learn a lot, and it also means a lot to me!

## What I learned

* Use of Android Studio
* Android Frontend implementation
* SQLite Database
* Git

## What's next for Mood Tracker App

There is certainly a lot that still can be improved for this App, things like:

* Utilize an open-source graph generator library to generate a report for database data for better visualization.
* Add a login feature to protect the user's privacy
* Improve the UI/UX design of the App for a smoother user experience.
