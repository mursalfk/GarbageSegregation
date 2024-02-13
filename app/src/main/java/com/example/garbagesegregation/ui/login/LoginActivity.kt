import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.rememberBackPressedDispatcher
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.icons.MaterialIcons
import androidx.compose.material3.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.garbagesegregation.ui.theme.GarbageSegregationTheme

class LoginActivity : ComponentActivity(), OnBackPressedDispatcherOwner {
    private val backDispatcher = rememberBackPressedDispatcher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GarbageSegregationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LoginContent(onBackPressedDispatcher)
                }
            }
        }
    }

    override fun getOnBackPressedDispatcher(): OnBackPressedDispatcher {
        return backDispatcher
    }
}

@Composable
fun LoginContent(onBackPressedDispatcher: OnBackPressedDispatcher) {
    val context = LocalContext.current

    Surface {
        IconButton(
            onClick = { onBackPressedDispatcher.onBackPressed() },
            contentColor = Color.White // Set button color
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack, // Use arrow back icon
                contentDescription = "Back" // Provide content description
            )
        }

        // Rest of your content
        Greeting("Login Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GarbageSegregationTheme {
        LoginContent(rememberBackPressedDispatcher())
    }
}
