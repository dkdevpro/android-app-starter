package dev.dineshktech.app.starter.feature.crud.notes

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dineshktech.app.starter.core.model.data.Note
import dev.dineshktech.app.starter.feature.crud.addedit.BlueColor
import dev.dineshktech.app.starter.feature.crud.addedit.DefaultColor
import dev.dineshktech.app.starter.feature.crud.addedit.DefaultNoteBgColor
import dev.dineshktech.app.starter.feature.crud.addedit.NoteTextColor

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    cornerRadius: Dp = 10.dp,
    onClick: () -> Unit,
) {
    val color =
        if (Color(note.color) == DefaultColor || Color(note.color) == BlueColor) MaterialTheme.colorScheme.onSecondary else NoteTextColor

    Column(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(cornerRadius))
            .fillMaxWidth()
            .background(
                if (Color(note.color) == DefaultColor) {
                    DefaultNoteBgColor
                } else {
                    Color(note.color)
                },
            )
            .clickable { onClick() }
            .padding(16.dp),
    ) {
        Text(
            text = note.title,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = color,
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp),
        )

        if (note.isFavourite) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "",
                tint = color,
            )
        } else {
            Text(
                modifier = Modifier,
                text = note.content,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 10,
                lineHeight = 23.sp,
                overflow = TextOverflow.Ellipsis,
                color = color,
            )
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NoteItemPreview() {
    NoteItem(
        note = Note(
            title = "My Title",
            content = """
                Hello, I am android developer
                working 
            """.trimIndent(),
            timestamp = 100,
            isFavourite = true,
        ),
        onClick = {},
    )
}
