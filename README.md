# Lab4_HW_MovieApp

## Overview

This repository contains the Lab 4 homework project for Android mobile development.

The project is a **Movie Application** that allows users to browse movie information from an online movie API. Users can view movie posters, movie details, ratings, release dates, and other related information.

The main purpose of this project is to practice Android development using Jetpack Compose, API integration, navigation, asynchronous networking, and modern UI design.

---

## Features

- Browse movie list
- Display movie posters
- View movie details
- Show movie information:
  - Title
  - Overview
  - Rating
  - Release date
  - Poster image
- Online API integration
- Smooth scrolling movie list
- Navigation between screens
- Jetpack Compose UI
- Asynchronous data loading
- Error handling for API requests
- Loading state support

---

## Tech Stack

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Retrofit
- Gson Converter
- Coroutines
- Navigation Compose
- Coil Image Loading
- ViewModel
- Gradle Kotlin DSL

---

## Project Structure

```text
Lab4_HW_MovieApp/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/movieapp/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── network/
│   │   │   │   │   └── repository/
│   │   │   │   ├── navigation/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── screens/
│   │   │   │   │   ├── components/
│   │   │   │   │   └── theme/
│   │   │   │   └── viewmodel/
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   └── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md
```

---

## Main Components

### MainActivity.kt

`MainActivity.kt` is the main entry point of the application.

It initializes the Compose UI and controls the navigation flow between movie screens.

Main responsibilities:

- Start the Compose application
- Apply app theme
- Initialize navigation
- Load the movie list screen

---

### data/model

The `model` package contains movie-related data classes.

It may include:

- Movie item model
- Movie response model
- Genre information
- API response parsing models

---

### data/network

The `network` package handles API communication.

It may include:

- Retrofit API service
- API request configuration
- Base URL setup
- Response parsing

The app fetches movie data from an external movie API.

---

### data/repository

The `repository` package acts as a bridge between the API and UI layer.

Responsibilities include:

- Fetching movie data
- Handling API responses
- Returning movie information to ViewModel

---

### navigation

The `navigation` package controls screen navigation.

Typical navigation flow:

```text
Movie List Screen → Movie Detail Screen
```

Users can select a movie and navigate to its detailed information page.

---

### ui/screens

The `screens` package contains app screens.

Possible screens include:

- Home screen
- Movie list screen
- Movie detail screen

---

### ui/components

The `components` package contains reusable UI elements.

Examples:

- Movie card
- Poster image component
- Rating section
- Top app bar

---

### viewmodel

The `viewmodel` package manages UI state and business logic.

Responsibilities include:

- Fetching movie data
- Managing loading state
- Handling API responses
- Updating Compose UI

---

## API Key Setup

This app requires a movie API key.

If using **TMDB API**, create an API key from:

:contentReference[oaicite:1]{index=1}

Do not commit API keys directly to GitHub.

Recommended approach:

Add the API key to `local.properties`:

```properties
MOVIE_API_KEY=your_api_key_here
```

Then load it through `BuildConfig`.

Example:

```kotlin
val apiKey = BuildConfig.MOVIE_API_KEY
```

This helps avoid exposing private keys publicly.

---

## How to Run

### Requirements

Before running the project, make sure you have installed:

- Android Studio
- Android SDK
- JDK 17 or higher
- Android Emulator or a real Android device
- Internet connection
- Movie API key

---

### Run with Android Studio

1. Clone this repository:

```bash
git clone https://github.com/izjoe/Lab4_HW_MovieApp.git
```

2. Open **Android Studio**.

3. Choose **Open an Existing Project**.

4. Select the cloned project folder:

```text
Lab4_HW_MovieApp
```

5. Configure the API key.

Add your movie API key in:

```properties
local.properties
```

Example:

```properties
MOVIE_API_KEY=your_api_key_here
```

6. Wait for Gradle sync.

7. Select an Android emulator or connect a real Android device.

8. Click the **Run** button.

9. The application will be built and launched.

---

### Run with Terminal

For macOS or Linux:

```bash
./gradlew build
```

For Windows:

```bash
gradlew.bat build
```

To install the debug version:

```bash
./gradlew installDebug
```

---

## How to Use

1. Open the application.
2. Wait for the movie list to load.
3. Browse available movies.
4. Scroll through movie posters.
5. Tap a movie card.
6. View movie details such as:
   - Poster
   - Overview
   - Rating
   - Release date
7. Return to browse more movies.

---

## Demo

Demo folder:

```text
https://drive.google.com/drive/u/0/folders/1OWWOfUnb6ZgYrqEV3iq92Jf93EvwMupE
```

---

## Notes

- This is a Lab 4 Android homework project.
- The app requires internet connection.
- A valid movie API key is required.
- The app is for browsing movie information, not movie streaming.
- API keys should not be pushed to GitHub.
- Real Android devices may provide smoother performance than emulators.

---

## Future Improvements

- Add movie search feature
- Add movie category filter
- Add favorite movie list
- Add watchlist
- Add dark mode customization
- Add pagination for more movies
- Improve loading animation
- Add trailer preview
- Add actor and cast information
- Improve UI design
- Add offline cache support

---

## Author

**Nguyễn Bảo Châu**

- University: University of Information Technology – VNUHCM
- Major: Information System
- Email: baochaune21@gmail.com

---

## License

This project is used for educational purposes.
