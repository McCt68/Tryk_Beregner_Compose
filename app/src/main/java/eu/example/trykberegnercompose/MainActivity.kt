package eu.example.trykberegnercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.example.trykberegnercompose.ui.theme.TrykBeregnerComposeTheme

// About Column and Row..

// The "Row" Layout
// The "Row" layout stacks children in a horizontal sequence.
// All child items will be aligned vertically at Top and arranged horizontally at Start, by default.

// The "Column" layout
// The "Column" layout stacks children in a vertical sequence.
// All child items will be arranged vertically at Top and aligned horizontally at Start, by default.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrykBeregnerComposeTheme {
                MainScreen()

        }
    }
}

@Composable
fun MainScreen(){
    Scaffold(modifier = Modifier
        .fillMaxSize(),

        // Not sure how to achieve this with themes
        backgroundColor = Color(0xFF00004B)

    )
    // Not 100 % sure if this should be row or column
    {
        // values of what will be shown inside the scaffold
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically, // lodret position
            horizontalArrangement = Arrangement.SpaceEvenly //
        ) {
            Column(Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,

            ) {
                Modifier
                    .weight(0.5f)
                    .fillMaxSize()
                Column(

                ) {
                    MyCard()
                    
                }
                Modifier
                    .weight(0.5f)
                    .fillMaxSize()
                MyCard()

            }

        }


    }
}

@Composable
fun MyCard(){
    Card (
        // These parameters describe how the card is layouted
        modifier = Modifier
            .height(300.dp)
            //.fillMaxHeight(0.5f)
            .padding(8.dp),
            backgroundColor = Color(0xFF90CAF9),
            shape = RoundedCornerShape(24.dp),
            elevation = 5.dp
    ){ // These parameters describe what is inside the actual card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
                ) {
            TestText("Tank Nr.", colorInput = Color(0xFF1976D2))
            TestText(textInput = "Tank Nr.", colorInput = Color(0xFF0D47A1))
            MyEditText("Start Tryk")
            // Spacer(16.dp)
            MyEditText("Start Temp")
        }
    }
}

// This Composable is to create a text I can set into a Composable card
@Composable
fun TestText(textInput:String, colorInput: Color){
    Text(modifier = Modifier
        .padding(0.dp,8.dp),
        //color = Color(0xFF1976D2),
        fontSize = 24.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        color = colorInput,
        text = textInput)
}
    
// Testing edit Text
@Composable
fun MyEditText(hint: String) {

    // state variable, it updates everytime the UI recompose
    var text by remember { mutableStateOf(TextFieldValue("")) }

    // defining a TextField ( Similar to EditText in XML) outlined is just graphics change to a line border
    OutlinedTextField(modifier = Modifier
        .width(150.dp),
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold),
        // textStyle = TextStyle(textAlign = TextAlign.Center),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        // keyboardActions = KeyboardActions(), // Not used here

        // set the initial value to the value of the var text
        // and update the value to newText with a Lambda
        value = text,
        onValueChange = { text = it /*newText -> text = newText*/ },

        // label is similar to hint in XML
        label = { Text(
            // text = hint,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            text = hint
        ) }
        //placeholder = { Text(text = "Your Placeholder/Hint") }
    )
}
    



@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainScreen()
    }
}