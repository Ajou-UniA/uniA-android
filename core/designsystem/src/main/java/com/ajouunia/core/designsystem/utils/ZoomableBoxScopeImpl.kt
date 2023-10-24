package com.ajouunia.core.designsystem.utils

data class ZoomableBoxScopeImpl(
    override val scale: Float,
    override val offsetX: Float,
    override val offsetY: Float
) : ZoomableBoxScope
