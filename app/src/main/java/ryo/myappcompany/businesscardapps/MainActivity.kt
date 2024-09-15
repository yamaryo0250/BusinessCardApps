package ryo.myappcompany.businesscardapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ryo.myappcompany.businesscardapps.ui.theme.BusinessCardAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard("Android")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFccffd5)),
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                Modifier
                    .background(Color(0xFF223a70))
                    .size(150.dp)
            )
            Text(
                text = stringResource(R.string.name),
                fontSize = 40.sp
            )
            Text(
                text = stringResource(R.string.title),
                color = Color(0xFF3ddc84),
                modifier = Modifier
                    .padding(top = 16.dp)

            )
        }
        Column(
            Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Row{
                InquiryItem(
                    Icons.Rounded.Call,
                    stringResource(R.string.phone_number)
                )
            }
            Row{
                InquiryItem(
                    Icons.Rounded.Share,
                    stringResource(R.string.share)
                )
            }
            InquiryItem(
                Icons.Rounded.Email,
                stringResource(R.string.email_address)
            )
        }
    }
}


@Composable
private fun InquiryItem(
    iCon: ImageVector,
    item: String
) {
    Row {
        Icon(
            iCon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier
                .padding(end = 16.dp)
        )
        Text(
            text = item
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppsTheme {
        BusinessCard("Android")
    }
}