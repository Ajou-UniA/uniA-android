package com.ajouunia.core.designsystem.uniaiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.ajouunia.core.designsystem.UniAIconPack

public val UniAIconPack.IconCheckedEllipse: ImageVector
    get() {
        if (_iconCheckedEllipse != null) {
            return _iconCheckedEllipse!!
        }
        _iconCheckedEllipse = Builder(name = "IconCheckedEllipse", defaultWidth = 31.0.dp,
                defaultHeight = 30.0.dp, viewportWidth = 31.0f, viewportHeight = 30.0f).apply {
            path(fill = SolidColor(Color(0xFF8354FF)), stroke = SolidColor(Color(0xFF8354FF)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(29.9762f, 15.0f)
                curveTo(29.9762f, 23.0007f, 23.3852f, 29.5f, 15.2381f, 29.5f)
                curveTo(7.091f, 29.5f, 0.5f, 23.0007f, 0.5f, 15.0f)
                curveTo(0.5f, 6.9993f, 7.091f, 0.5f, 15.2381f, 0.5f)
                curveTo(23.3852f, 0.5f, 29.9762f, 6.9993f, 29.9762f, 15.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(9.1426f, 15.0f)
                lineTo(13.714f, 20.0f)
                lineTo(20.3172f, 11.0f)
            }
        }
        .build()
        return _iconCheckedEllipse!!
    }

private var _iconCheckedEllipse: ImageVector? = null
