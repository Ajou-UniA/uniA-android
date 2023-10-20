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

public val UniAIconPack.IcHamMenu: ImageVector
    get() {
        if (_icHamMenu != null) {
            return _icHamMenu!!
        }
        _icHamMenu = Builder(name = "IcHamMenu", defaultWidth = 20.0.dp, defaultHeight = 17.0.dp,
                viewportWidth = 20.0f, viewportHeight = 17.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(20.0f)
                verticalLineToRelative(2.6842f)
                horizontalLineToRelative(-20.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 7.1579f)
                horizontalLineToRelative(20.0f)
                verticalLineToRelative(2.6842f)
                horizontalLineToRelative(-20.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 14.3158f)
                horizontalLineToRelative(20.0f)
                verticalLineToRelative(2.6842f)
                horizontalLineToRelative(-20.0f)
                close()
            }
        }
        .build()
        return _icHamMenu!!
    }

private var _icHamMenu: ImageVector? = null
