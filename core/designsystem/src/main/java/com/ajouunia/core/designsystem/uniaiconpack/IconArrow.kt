package com.ajouunia.core.designsystem.uniaiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.ajouunia.core.designsystem.UniAIconPack

public val UniAIconPack.IconArrow: ImageVector
    get() {
        if (_iconArrow != null) {
            return _iconArrow!!
        }
        _iconArrow = Builder(name = "IconArrow", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.8752f, 2.9f)
                lineTo(17.3002f, 11.3f)
                curveTo(17.4002f, 11.4f, 17.4709f, 11.5083f, 17.5122f, 11.625f)
                curveTo(17.5542f, 11.7417f, 17.5752f, 11.8667f, 17.5752f, 12.0f)
                curveTo(17.5752f, 12.1333f, 17.5542f, 12.2583f, 17.5122f, 12.375f)
                curveTo(17.4709f, 12.4917f, 17.4002f, 12.6f, 17.3002f, 12.7f)
                lineTo(8.8752f, 21.125f)
                curveTo(8.6419f, 21.3583f, 8.3502f, 21.475f, 8.0002f, 21.475f)
                curveTo(7.6502f, 21.475f, 7.3502f, 21.35f, 7.1002f, 21.1f)
                curveTo(6.8502f, 20.85f, 6.7252f, 20.5583f, 6.7252f, 20.225f)
                curveTo(6.7252f, 19.8917f, 6.8502f, 19.6f, 7.1002f, 19.35f)
                lineTo(14.4502f, 12.0f)
                lineTo(7.1002f, 4.65f)
                curveTo(6.8669f, 4.4167f, 6.7502f, 4.1293f, 6.7502f, 3.788f)
                curveTo(6.7502f, 3.446f, 6.8752f, 3.15f, 7.1252f, 2.9f)
                curveTo(7.3752f, 2.65f, 7.6669f, 2.525f, 8.0002f, 2.525f)
                curveTo(8.3335f, 2.525f, 8.6252f, 2.65f, 8.8752f, 2.9f)
                close()
            }
        }
        .build()
        return _iconArrow!!
    }

private var _iconArrow: ImageVector? = null
