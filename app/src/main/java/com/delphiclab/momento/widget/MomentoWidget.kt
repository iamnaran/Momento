package com.delphiclab.momento.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MomentoWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MomentoClock()
        }
    }


}

@Composable
private fun MomentoClock() {

    Column(
        modifier = GlanceModifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var currentTime by remember { mutableStateOf(LocalTime.now()) }
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

        Text(text = "My Clock Style", modifier = GlanceModifier.padding(12.dp))
        Text(
            text = currentTime.format(formatter),
        )

        LaunchedEffect(key1 = Unit) {
            while (true) {
                currentTime = LocalTime.now()
                delay(1000)
            }
        }

    }

}
