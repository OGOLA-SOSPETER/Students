package projects.ogolasospeter.students.filepackages

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import projects.ogolasospeter.students.R



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsPage(navController: NavHostController) {

    Scaffold(
        topBar = { AppBar(title = "Settings") },
        content = { SettingsContent(navController) }
    )

}



@Composable
fun SettingsContent(navController: NavHostController) {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Settings Update..") },
            text = { Text(text = "Settings in Progress.\nCheck back soonest.") },
            confirmButton = {
                OutlinedButton(onClick = {
                    // Handle confirm button click
                    showDialog = false
                },modifier = Modifier.width(100.dp)) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = {
                    // Handle dismiss button click
                    showDialog = false
                },modifier = Modifier.width(100.dp)) {
                    Text(text = "Dismiss.")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "General Settings",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Divider()
        SettingItem(
            title = "Notifications",
            subtitle = "Manage your notification settings",
            icon = Icons.Default.Notifications,
            onClick = { showDialog = true }
        )
        Divider()
        SettingItem(
            title = "Privacy",
            subtitle = "Manage your privacy settings",
            icon = Icons.Default.Info,
            onClick = { /* TODO */ }
        )
        Divider()
        SettingItem(
            title = "Account",
            subtitle = "Manage your account settings",
            icon = Icons.Default.AccountCircle,
            onClick = { /* TODO */ }
        )
        Divider()
        SettingItem(
            title = "About",
            subtitle = "Learn more about the app",
            icon = Icons.Default.Info,
            onClick = { /* TODO */ }
        )

        Divider()
        SettingItem(
            title = "LogOut",
            subtitle = "Exit App",
            icon = Icons.Default.ExitToApp,
            onClick = { navController.navigate("land") }
        )
    }
}

@Composable
fun SettingItem(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp)
        )
        Column(
            modifier = Modifier.padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.body1)
            Text(
                text = subtitle,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id =R.drawable.chevron_right),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.ArrowBack,contentDescription = null)
            }
            Text(text = title)
        Spacer(modifier = Modifier.width(100.dp))
            CircularProgressIndicator(modifier = Modifier.size(25.dp),
                color = Color.White, strokeWidth = 3.dp)

        }

    )
}
@Preview
@Composable
fun PreviewSettingsPage() {
   SettingsPage(navController = rememberNavController())
}
