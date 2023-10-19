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

public val UniAIconPack.IcSelectedHome: ImageVector
    get() {
        if (_icSelectedHome != null) {
            return _icSelectedHome!!
        }
        _icSelectedHome = Builder(name = "IcSelectedHome", defaultWidth = 22.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 22.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF8354FF)), stroke = SolidColor(Color(0xFF8354FF)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(1.333f, 23.5f)
                verticalLineTo(8.8333f)
                lineTo(11.333f, 1.5f)
                lineTo(21.333f, 8.8333f)
                verticalLineTo(23.5f)
                horizontalLineTo(13.833f)
                verticalLineTo(14.9444f)
                horizontalLineTo(8.833f)
                verticalLineTo(23.5f)
                horizontalLineTo(1.333f)
                close()
            }
        }
        .build()
        return _icSelectedHome!!
    }

private var _icSelectedHome: ImageVector? = null
