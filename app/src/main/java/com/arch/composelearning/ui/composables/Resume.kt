package com.arch.composelearning.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arch.composelearning.R
import com.arch.composelearning.data.model.CompanyExperience
import com.arch.composelearning.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun Resume() {
    val list = listOf(
        CompanyExperience("Systems Ltd", "Aug 2021 - Present"),
        CompanyExperience("Finz Games", "Jan 2021 - Aug 2021")
    )

    val skills = listOf(
        "Java",
        "Kotlin",
        "Retrofit",
        "Room DB",
        "Dependency Injection (Dagger Hilt)",
        "Android SDK",
        "Git VCS",
        "RESTful APIs",
        "Design Patterns (MVVM)"
    )
    val languages = listOf(
        "English", "Urdu"
    )
    val hobbies = listOf(
        "Cricket", "Football", "Gaming"
    )
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        item {
            Name(name = "Hamza Mehboob")
            JobTitle(title = "Junior Android Consultant")
            Subheading(subheading = stringResource(id = R.string.professional_summary))
            Summary(summary = stringResource(id = R.string.summary))
            Subheading(subheading = stringResource(id = R.string.experiences))
        }
        items(list) {
            CompanyTitle(title = it.companyName)
            CompanyDetail(detail = it.experience)
            Divider(modifier = Modifier.padding(vertical = 4.dp))
        }
        item {
            Subheading(subheading = stringResource(id = R.string.skills))
        }
        items(skills) {
            BulletList(bullet = it)
        }
        item {
            Subheading(subheading = stringResource(id = R.string.languages))
        }
        items(languages) {
            BulletList(bullet = it)
        }

        item {
            Subheading(subheading = stringResource(id = R.string.hobbies))
        }
        items(hobbies) {
            BulletList(bullet = it)
        }

    }

}


@Composable
fun Name(name: String) {
    Text(
        text = name, style = Typography.h1, modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun JobTitle(title: String) {
    Text(
        text = title, style = Typography.body1, modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Subheading(subheading: String) {
    Text(
        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp),
        text = subheading,
        style = Typography.h2,
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun Summary(summary: String) {
    Text(
        text = summary, style = Typography.body1, modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}

@Composable
fun CompanyTitle(title: String) {
    Text(
        text = title,
        style = Typography.h3,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
fun CompanyDetail(detail: String) {
    Text(
        text = detail,
        style = Typography.h3,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Composable
fun BulletList(bullet: String) {
    val paragraphStyle = ParagraphStyle(textAlign = TextAlign.Start)
    Text(
        text = buildAnnotatedString {
            withStyle(paragraphStyle) {
                append("\u2022")
                append(bullet)
            }
        }, style = Typography.body1, modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
}


