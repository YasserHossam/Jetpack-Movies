package com.marvel.moviesapp.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.marvel.moviesapp.ui.navigation.NavItem
import com.marvel.moviesapp.ui.theme.BottomNavigationColor

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        NavItem.NowPlaying,
        NavItem.TopRated,
        NavItem.Search,
        NavItem.Favorites
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = BottomNavigationColor.background,
        contentColor = Color.Black,
        modifier = Modifier.height(60.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val title = stringResource(item.title)
            val icon = ImageVector.vectorResource(item.icon)
            BottomNavigationItem(
                icon = { Icon(icon, title, modifier = Modifier
                    .size(28.dp)
                    .padding(top = 6.dp, bottom = 3.dp, start = 3.dp, end = 3.dp)) },
                label = { Text(text = stringResource(item.title), fontSize = 12.sp) },
                selectedContentColor = BottomNavigationColor.selected,
                unselectedContentColor = BottomNavigationColor.unselected,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}