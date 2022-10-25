# Movies App

## Description

This app is a TMDB API consumer to list and search your favourite movies

## Design

<p float="left" align="middle">
  <img src="https://user-images.githubusercontent.com/12577690/197887291-b24f644e-bf99-44b6-b4b8-accaa9ff1b8a.png" width="32%" />
  <img src="https://user-images.githubusercontent.com/12577690/197888296-29691950-b2d1-4889-a9f2-5e7ce9f1d4ac.png" width="32%" /> 
  <img src="https://user-images.githubusercontent.com/12577690/197889217-6e8a77b6-e2b0-4da5-8bb8-79c1fc45c09d.png" width="32%" />
</p>

## How to build (Very Important)
* First, Checkout the project
* Then open TMDB website settings, copy base API url and API_KEY, place them in gradle.properties in place of these keys -> (moviesApi, moviesApiKey) respectively

## UI Notes
* You can favorite item by long click on a movie on any screen other than favorites screen
* You can remove item from favorites by long clicking on a movie on favorites screen

## Development

### Architecture
* MVVM
* Repository
* Clean Architecture

### Libraries 

#### UI
* Jetpack Compose
* Paging 3
* Material
* Coil for images

#### APIs
* Retrofit 
* OkHttp
* Gson

#### Async Tasks
* Coroutines and Flows

#### Dependency Injection
* Hilt

### Unit testing
* JUnit
* Mockito-Kotlin
* Note -> I didn't have the needed time to make unit tests for all the application, this is just a sample of unit testing

#### Other
* (Gradle version catalog TOML file) for sharing dependencies.
