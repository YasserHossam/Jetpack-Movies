# Movies App

## Description

This app is a TMDB API consumer to list and search your favourite movies

## How to build (Very Important)
* First, Checkout the project
* Then open TMDB website settings, copy base API url and API_KEY, place them in gradle.properties in place of these keys -> (moviesApi, moviesApiKey) respectively

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
