package com.ajouunia.core.designsystem.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

val TextUnit.nonScaleSp
    @Composable
    get() = when (this) {
        TextUnit.Unspecified -> this
        else -> (this.value / LocalDensity.current.fontScale).sp
    }