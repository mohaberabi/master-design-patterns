package com.mohaberabi.masterdesignpattern.apply.behavioral.chain_of_responsiblity

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base.SupportTicket
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.base.TicketType
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.impl.CriticalSupportHandler
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.impl.GeneralSupportHandler
import com.mohaberabi.masterdesignpattern.theoritical.behavioral.chain_of_responsiblity.impl.TechnicalSupportHandler


@Composable
fun HelpScreen(
    modifier: Modifier = Modifier,
) {

    val context = LocalContext.current

    val general = rememberGeneralSupport {

        Toast.makeText(
            context, "Handled By General",
            Toast.LENGTH_LONG
        ).show()
    }
    val technical = rememberTechnicalSupport {
        Toast.makeText(
            context, "Handled By Technical",
            Toast.LENGTH_LONG
        ).show()
    }
    val critical = rememberCriticalSupport {
        Toast.makeText(
            context, "Handled By Critical",
            Toast.LENGTH_LONG
        ).show()
    }
    general.setNext(technical)
    technical.setNext(critical)
    var selectedIssueType by remember { mutableStateOf(TicketType.General) }
    var issueDescription by remember { mutableStateOf("") }
    var handlingResult by remember { mutableStateOf("") }
    Scaffold { padding ->

        Column(
            modifier = modifier
                .padding(16.dp)
                .padding(padding)
        ) {
            Text(text = "Submit an Issue", style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(16.dp))

            TicketMenu(selectedIssueType, onIssueTypeSelected = { selectedIssueType = it })

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = issueDescription,
                onValueChange = { issueDescription = it },
                label = { Text("Issue Description") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val issue = SupportTicket(
                        title = issueDescription,
                        type = selectedIssueType,
                        body = issueDescription,
                    )
                    handlingResult = ""
                    general.handleRequest(issue)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Submit")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = handlingResult,
                style = MaterialTheme.typography.bodyLarge,
            )
        }


    }
}


@Composable
fun TicketMenu(
    selectedIssueType: TicketType,
    onIssueTypeSelected: (TicketType) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    val issueTypes = TicketType.entries

    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = selectedIssueType.name,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(16.dp)
                .background(Color.LightGray)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            issueTypes.forEach { issueType ->
                DropdownMenuItem(
                    onClick = {
                        onIssueTypeSelected(issueType)
                        expanded = false
                    },
                    text = {
                        Text(text = issueType.name)

                    }
                )
            }
        }
    }
}

@Composable
fun rememberGeneralSupport(
    onHandle: () -> Unit = {},
): GeneralSupportHandler {
    return remember {
        GeneralSupportHandler(onHandle)
    }
}

@Composable
fun rememberTechnicalSupport(
    onHandle: () -> Unit = {},
): TechnicalSupportHandler {
    return remember {
        TechnicalSupportHandler(onHandle)
    }
}

@Composable
fun rememberCriticalSupport(
    onHandle: () -> Unit = {},
): CriticalSupportHandler {
    return remember {
        CriticalSupportHandler(onHandle)
    }
}