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

public val UniAIconPack.IconUncheckEllipse: ImageVector
    get() {
        if (_iconUncheckEllipse != null) {
            return _iconUncheckEllipse!!
        }
        _iconUncheckEllipse = Builder(name = "IconUncheckEllipse", defaultWidth = 30.0.dp,
                defaultHeight = 30.0.dp, viewportWidth = 30.0f, viewportHeight = 30.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFFE3E3E3)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.0f, 15.0f)
                moveToRelative(-14.5f, 0.0f)
                arcToRelative(14.5f, 14.5f, 0.0f, true, true, 29.0f, 0.0f)
                arcToRelative(14.5f, 14.5f, 0.0f, true, true, -29.0f, 0.0f)
            }
        }
        .build()
        return _iconUncheckEllipse!!
    }

private var _iconUncheckEllipse: ImageVector? = null
