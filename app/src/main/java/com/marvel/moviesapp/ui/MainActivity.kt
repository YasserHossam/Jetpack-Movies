package com.marvel.moviesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.marvel.moviesapp.ui.composable.BottomNavigation
import com.marvel.moviesapp.ui.composable.HomeTopBar
import com.marvel.moviesapp.ui.composable.SearchView
import com.marvel.moviesapp.ui.navigation.NavItem
import com.marvel.moviesapp.ui.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenView()
        }
    }

    @Composable
    fun MainScreenView() {
        val navController = rememberNavController()

        val currentDestination by navController.currentBackStackEntryAsState()

        val title by remember {
            derivedStateOf {
                val route = currentDestination?.destination?.route ?: ""
                NavItem.getObjectFromRoute(route).title
            }
        }

        val isSearch by remember {
            derivedStateOf {
                currentDestination?.destination?.route == NavItem.Search.screen_route
            }
        }

        val textState = remember { mutableStateOf(TextFieldValue("")) }
        Scaffold(
            topBar = {
                if (isSearch)
                    SearchView(state = textState)
                else
                    HomeTopBar(title = stringResource(id = title))
            },
            bottomBar = { BottomNavigation(navController = navController) }
        ) {
            NavigationGraph(navController = navController, textState)
        }
    }
}