package com.ajouunia.core.designsystem.uniaiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.ajouunia.core.designsystem.UniAIconPack

public val UniAIconPack.IcSelectedCircle: ImageVector
    get() {
        if (_icSelectedCircle != null) {
            return _icSelectedCircle!!
        }
        _icSelectedCircle = Builder(name = "IcSelectedCircle", defaultWidth = 15.0.dp, defaultHeight
                = 15.0.dp, viewportWidth = 15.0f, viewportHeight = 15.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF8354FF)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(7.5f, 7.5f)
                moveToRelative(-7.0f, 0.0f)
                arcToRelative(7.0f, 7.0f, 0.0f, true, true, 14.0f, 0.0f)
                arcToRelative(7.0f, 7.0f, 0.0f, true, true, -14.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF8354FF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(7.5f, 7.5f)
                moveToRelative(-4.5f, 0.0f)
                arcToRelative(4.5f, 4.5f, 0.0f, true, true, 9.0f, 0.0f)
                arcToRelative(4.5f, 4.5f, 0.0f, true, true, -9.0f, 0.0f)
            }
        }
        .build()
        return _icSelectedCircle!!
    }

private var _icSelectedCircle: ImageVector? = null
