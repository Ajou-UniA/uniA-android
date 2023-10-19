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

public val UniAIconPack.IcCommunity: ImageVector
    get() {
        if (_icCommunity != null) {
            return _icCommunity!!
        }
        _icCommunity = Builder(name = "IcCommunity", defaultWidth = 23.0.dp, defaultHeight =
                23.0.dp, viewportWidth = 23.0f, viewportHeight = 23.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF8A8A8A)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(2.333f, 1.0f)
                lineTo(20.333f, 1.0f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 21.833f, 2.5f)
                lineTo(21.833f, 8.5f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 20.333f, 10.0f)
                lineTo(2.333f, 10.0f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 0.833f, 8.5f)
                lineTo(0.833f, 2.5f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 2.333f, 1.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF8A8A8A)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(2.333f, 13.0f)
                lineTo(8.333f, 13.0f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 9.833f, 14.5f)
                lineTo(9.833f, 20.5f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 8.333f, 22.0f)
                lineTo(2.333f, 22.0f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 0.833f, 20.5f)
                lineTo(0.833f, 14.5f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 2.333f, 13.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF8A8A8A)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.333f, 13.0f)
                lineTo(20.333f, 13.0f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 21.833f, 14.5f)
                lineTo(21.833f, 20.5f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 20.333f, 22.0f)
                lineTo(14.333f, 22.0f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 12.833f, 20.5f)
                lineTo(12.833f, 14.5f)
                arcTo(1.5f, 1.5f, 0.0f, false, true, 14.333f, 13.0f)
                close()
            }
        }
        .build()
        return _icCommunity!!
    }

private var _icCommunity: ImageVector? = null
