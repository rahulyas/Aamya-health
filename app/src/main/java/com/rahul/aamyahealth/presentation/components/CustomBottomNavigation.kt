package com.rahul.aamyahealth.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rahul.aamyahealth.domain.BottomNavItem

@Composable
fun CustomBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
    items: List<BottomNavItem>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()) // keeps above back gesture bar
    ) {
        Surface(
            color = Color.White,
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEach { item ->
                    if (item !is BottomNavItem.Add) {
                        BottomNavItemView(
                            item = item,
                            isSelected = currentRoute == item.route,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    } else {
                        Spacer(modifier = Modifier.width(64.dp))
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate(BottomNavItem.Add.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            shape = CircleShape,
            containerColor = Color.Black,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(64.dp)
        ) {
            AddIcon(Color.White)
        }
    }
}

@Composable
fun BottomNavItemView(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val iconColor = if (isSelected) Color(0xFFFFC107) else Color(0xFF9CA3AF) // yellow when selected
    val isAddButton = item is BottomNavItem.Add

    Column(
        modifier = Modifier
            .size(56.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.size(28.dp), // smaller than FAB
            contentAlignment = Alignment.Center
        ) {
            when (item) {
                is BottomNavItem.Home -> HomeIcon(iconColor)
                is BottomNavItem.Messages -> MessageIcon(iconColor)
                is BottomNavItem.Schedule -> ScheduleIcon(iconColor)
                is BottomNavItem.Profile -> ProfileIcon(iconColor)
                else -> {}
            }
        }

        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
        }
    }
}

@Composable
fun HomeIcon(color: Color) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val path = Path().apply {
            moveTo(size.width * 0.5f, size.height * 0.2f)
            lineTo(size.width * 0.9f, size.height * 0.5f)
            lineTo(size.width * 0.9f, size.height * 0.9f)
            lineTo(size.width * 0.1f, size.height * 0.9f)
            lineTo(size.width * 0.1f, size.height * 0.5f)
            close()
        }
        drawPath(path, color)
    }
}

@Composable
fun MessageIcon(color: Color) {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawRoundRect(
            color = color,
            topLeft = Offset(size.width * 0.1f, size.height * 0.25f),
            size = Size(size.width * 0.8f, size.height * 0.6f),
            cornerRadius = CornerRadius(4.dp.toPx())
        )
        val path = Path().apply {
            moveTo(size.width * 0.1f, size.height * 0.25f)
            lineTo(size.width * 0.5f, size.height * 0.55f)
            lineTo(size.width * 0.9f, size.height * 0.25f)
        }
        drawPath(path, color, style = Stroke(width = 2.dp.toPx()))
    }
}

@Composable
fun AddIcon(color: Color) {
    Canvas(modifier = Modifier.size(28.dp)) {
        drawLine(
            color = color,
            start = Offset(size.width * 0.5f, size.height * 0.2f),
            end = Offset(size.width * 0.5f, size.height * 0.8f),
            strokeWidth = 3.dp.toPx()
        )
        drawLine(
            color = color,
            start = Offset(size.width * 0.2f, size.height * 0.5f),
            end = Offset(size.width * 0.8f, size.height * 0.5f),
            strokeWidth = 3.dp.toPx()
        )
    }
}

@Composable
fun ScheduleIcon(color: Color) {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawRoundRect(
            color = color,
            topLeft = Offset(size.width * 0.15f, size.height * 0.2f),
            size = Size(size.width * 0.7f, size.height * 0.7f),
            cornerRadius = CornerRadius(4.dp.toPx()),
            style = Stroke(width = 2.dp.toPx())
        )
        drawLine(
            color = color,
            start = Offset(size.width * 0.15f, size.height * 0.35f),
            end = Offset(size.width * 0.85f, size.height * 0.35f),
            strokeWidth = 2.dp.toPx()
        )
    }
}

@Composable
fun ProfileIcon(color: Color) {
    Canvas(modifier = Modifier.size(24.dp)) {
        drawCircle(
            color = color,
            radius = size.minDimension * 0.15f,
            center = Offset(size.width * 0.5f, size.height * 0.35f)
        )
        drawArc(
            color = color,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(size.width * 0.25f, size.height * 0.55f),
            size = Size(size.width * 0.5f, size.height * 0.4f)
        )
    }
}