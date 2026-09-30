package com.example.tp3myapplication.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp3myapplication.ui.theme.DecorativeShape
import com.example.tp3myapplication.ui.theme.InputBackground
import com.example.tp3myapplication.ui.theme.TP3MyApplicationTheme

// Medidas de la pantalla en Figma
private const val FIGMA_WIDTH = 428f
private const val FIGMA_HEIGHT = 926f

@Composable
fun DecorativeBackground(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .clipToBounds()   // no dibuja nada fuera de la pantalla
    ) {
        // Escala: convierte medidas de Figma al tamaño real de este celular
        val s = size.width / FIGMA_WIDTH

        // Para las formas de abajo: cuánto las separa del borde inferior en Figma
        fun fromBottom(figmaY: Float) = size.height - (FIGMA_HEIGHT - figmaY) * s

        val squareSize = Size(370f * s, 370f * s)
        val squareStroke = Stroke(width = 2f * s)

        // Cuadrado recto (abajo a la izquierda)
        drawRect(
            color = InputBackground,
            topLeft = Offset(-305f * s, fromBottom(635f)),
            size = squareSize,
            style = squareStroke
        )

        // Cuadrado girado 27° (abajo a la izquierda)
        val rotatedTopLeft = Offset(-194.462f * s, fromBottom(576.051f))
        rotate(degrees = 27.0888f, pivot = rotatedTopLeft) {
            drawRect(
                color = InputBackground,
                topLeft = rotatedTopLeft,
                size = squareSize,
                style = squareStroke
            )
        }

        // Aro (arriba)
        drawCircle(
            color = DecorativeShape,
            radius = 246.5f * s,
            center = Offset(271f * s, 77f * s),
            style = Stroke(width = 3f * s)
        )

        // Círculo relleno (arriba a la derecha)
        drawCircle(
            color = DecorativeShape,
            radius = 317.5f * s,
            center = Offset(431.5f * s, -38.5f * s)
        )
    }
}

@Preview(showBackground = true, widthDp = 428, heightDp = 926)
@Composable
private fun DecorativeBackgroundPreview() {
    TP3MyApplicationTheme {
        Surface {
            DecorativeBackground()
        }
    }
}