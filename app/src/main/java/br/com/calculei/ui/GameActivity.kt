package br.com.calculei.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.calculei.R

class GameActivity : ComponentActivity() {

    var answers: MutableList<Int> = mutableListOf()


    fun updateAnswers(updatedAnswers: List<Int>) {
        answers = updatedAnswers
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                Modifier.background(color = colorResource(R.color.app_background)).fillMaxSize(),
                verticalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.padding(4.dp))
                Game()
                Spacer(modifier = Modifier.padding(4.dp))
                Question("1 + 1 + 1")
                Spacer(modifier = Modifier.padding(4.dp))
                Answers(listOf(1, 2, 3))
                Spacer(modifier = Modifier.padding(4.dp))
                Result()
            }
        }
    }
}

@Composable
fun Game() {
    Column(modifier = Modifier.fillMaxWidth()) {
        val gameViewModel = GameViewModel()
        val matrix = gameViewModel.createMatrixOfQuestions()
        for (i in matrix.indices) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (j in matrix[i].indices) {
                    Button(
                        onClick = {
                            gameViewModel.updateAnswers(matrix[i][j].answers)
                        },
                        modifier = Modifier.padding(4.dp),
                        shape = CircleShape
                    ) {
                        Text(
                            text = matrix[i][j].answers[0].toString()
                        )
                    }
                }
            }
        }
//        Row(modifier = Modifier.fillMaxWidth(),  horizontalArrangement = Arrangement.Center) {
//            Button(
//                onClick = {
//                    // Here we need to show the answers we generated on GameViewModel on the bottom
//
//                },
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//        }
//        Spacer(Modifier.padding(4.dp))
//        Row(modifier = Modifier.fillMaxWidth(),  horizontalArrangement = Arrangement.Center) {
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//        }
//        Spacer(Modifier.padding(4.dp))
//        Row(modifier = Modifier.fillMaxWidth(),  horizontalArrangement = Arrangement.Center) {
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
//            Button(
//                onClick = {},
//                modifier = Modifier.padding(4.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "15s"
//                )
//            }
//            Spacer(Modifier.padding(4.dp))
        }
    }
}

@Composable
fun Question(text: String) {
    Text(modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        text = text
    )
}

@Composable
fun Answers(answers: List<Int>, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = {}, modifier = Modifier.padding(4.dp)) {
            Text(
                text = answers[0].toString()
            )
        }
        Button(onClick = {},  modifier = Modifier.padding(4.dp)) {
            Text(
                text = answers[1].toString()
            )
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(4.dp),
        ) {
            Text(
                text = answers[2].toString()
            )
        }
    }
}

@Composable
fun Result() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.correct_answer),
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = Color.Magenta
    )
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    Column(Modifier.background(color = colorResource(R.color.app_background))) {
        Game()
        Spacer(modifier = Modifier.padding(4.dp))
        Question("1 + 1 + 1")
        Spacer(modifier = Modifier.padding(4.dp))
        Answers(listOf(1, 2, 3))
        Spacer(modifier = Modifier.padding(4.dp))
        Result()
    }
}