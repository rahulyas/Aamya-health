package com.rahul.aamyahealth.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rahul.aamyahealth.model.Appointment
import com.rahul.aamyahealth.model.Doctor
import com.rahul.aamyahealth.presentation.components.CalendarSection
import com.rahul.aamyahealth.presentation.components.CategorySection
import com.rahul.aamyahealth.presentation.components.DoctorListSection
import com.rahul.aamyahealth.presentation.components.SearchSection
import com.rahul.aamyahealth.presentation.components.TopAppBarSection
import com.rahul.aamyahealth.presentation.components.UpcomingScheduleSection

@Composable
fun HealthcareAppUI() {
    val doctors = listOf(
        Doctor("Ralph Edward", "Cardiologist", 4.8),
        Doctor("Bessie Cooper", "Endocrinologist", 4.6),
        Doctor("Annette Black", "Surgeon Specialist", 4.2)
    )

    val appointments = listOf(
        Appointment("Dr. Lailaa Russell", "Cardiologist", "20 September", "12:30 - 10:30 PM"),
        Appointment("Dr. Cries Jacks", "Psychiatrist", "22 September", "09:00 - 10:00 AM")
    )

    var selectedDate by remember { mutableIntStateOf(18) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
    ) {
        TopAppBarSection()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchSection()
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    CalendarSection(selectedDate) { selectedDate = it }
                    Spacer(modifier = Modifier.height(20.dp))
                    DoctorListSection(doctors)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            CategorySection()
            Spacer(modifier = Modifier.height(24.dp))
            UpcomingScheduleSection(appointments)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}