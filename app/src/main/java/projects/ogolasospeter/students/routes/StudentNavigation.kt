package projects.ogolasospeter.students.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import projects.ogolasospeter.students.HomePage
import projects.ogolasospeter.students.filepackages.DashboardPage
import projects.ogolasospeter.students.filepackages.SettingsPage
import projects.ogolasospeter.students.filepackages.StudentProfilePage
import projects.ogolasospeter.students.filepackages.WelcomePages

@Composable
fun NavStudent(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "land",
        builder = {
            composable("land"){ WelcomePages(navController)}
            composable("home"){ HomePage(navController )}
            composable("settings"){ SettingsPage(navController)}
            composable("profile"){ StudentProfilePage(navController)}
            composable("dash"){ DashboardPage(navController) }
        })
}