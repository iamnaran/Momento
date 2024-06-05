package com.delphiclab.momento.widget

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.appWidgetBackground
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontStyle
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.time.LocalTime

class MomentoWidget : GlanceAppWidget() {

    companion object {
        private val squareMode = DpSize(80.dp, 80.dp)
        private val rectangleMode = DpSize(100.dp, 100.dp)
    }

    override val sizeMode: SizeMode = SizeMode.Responsive(
        setOf(squareMode, rectangleMode),
    )

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MomentoClock()
        }
    }


    @Composable
    private fun MomentoClock() {
        val size = LocalSize.current
        when (size) {
            rectangleMode -> RectangleClockContent()
            squareMode -> SquareModeContent()
            // others size clock
        }

    }


    @Composable
    private fun RectangleClockContent() {
        val currentDate by remember { mutableStateOf(LocalDate.now()) }
        var currentTime by remember { mutableStateOf(LocalTime.now()) }
        val currentDay = DateUtils.getCurrentDay(currentDate)
        val currentMonth = DateUtils.getFormattedCurrentDate(currentDate)

        Box(
            modifier = GlanceModifier.fillMaxSize()
                .cornerRadius(14.dp)
                .padding(8.dp)
                .appWidgetBackground()
        ) {

            Column(
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal
                    ),
                    text = currentMonth,
                )

                Text(
                    style = TextStyle(
                        fontSize = 38.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    ),
                    text = currentDay,
                )



                LaunchedEffect(key1 = Unit) {
                    while (true) {
                        currentTime = LocalTime.now()
                        delay(1000)
                    }
                }

            }

        }


    }


    @Composable
    private fun SquareModeContent() {
        val currentDate by remember { mutableStateOf(LocalDate.now()) }
        var currentTime by remember { mutableStateOf(LocalTime.now()) }
        val currentDay = DateUtils.getCurrentDay(currentDate)
        val currentMonth = DateUtils.getFormattedCurrentDate(currentDate)

        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .width(200.dp)
                .height(200.dp)
                .cornerRadius(50.dp)
                .appWidgetBackground()
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {

            Column(
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal
                    ),
                    text = currentMonth,
                )

                Text(
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    ),
                    text = currentDay,
                )



                LaunchedEffect(key1 = Unit) {
                    while (true) {
                        currentTime = LocalTime.now()
                        delay(1000)
                    }
                }

            }

        }


    }

}

