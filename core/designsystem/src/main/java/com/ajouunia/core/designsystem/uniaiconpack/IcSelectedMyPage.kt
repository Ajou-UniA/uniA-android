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

public val UniAIconPack.IcSelectedMyPage: ImageVector
    get() {
        if (_icSelectedMyPage != null) {
            return _icSelectedMyPage!!
        }
        _icSelectedMyPage = Builder(name = "IcSelectedMyPage", defaultWidth = 24.0.dp, defaultHeight
                = 23.0.dp, viewportWidth = 24.0f, viewportHeight = 23.0f).apply {
            path(fill = SolidColor(Color(0xFF8354FF)), stroke = SolidColor(Color(0xFF8354FF)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.0f, 11.5f)
                curveTo(10.4875f, 11.5f, 9.1927f, 10.9615f, 8.1156f, 9.8844f)
                curveTo(7.0385f, 8.8073f, 6.5f, 7.5125f, 6.5f, 6.0f)
                curveTo(6.5f, 4.4875f, 7.0385f, 3.1927f, 8.1156f, 2.1156f)
                curveTo(9.1927f, 1.0385f, 10.4875f, 0.5f, 12.0f, 0.5f)
                curveTo(13.5125f, 0.5f, 14.8073f, 1.0385f, 15.8844f, 2.1156f)
                curveTo(16.9615f, 3.1927f, 17.5f, 4.4875f, 17.5f, 6.0f)
                curveTo(17.5f, 7.5125f, 16.9615f, 8.8073f, 15.8844f, 9.8844f)
                curveTo(14.8073f, 10.9615f, 13.5125f, 11.5f, 12.0f, 11.5f)
                close()
                moveTo(1.0f, 22.5f)
                verticalLineTo(18.65f)
                curveTo(1.0f, 17.8708f, 1.2007f, 17.1545f, 1.6022f, 16.5009f)
                curveTo(2.0038f, 15.8473f, 2.5363f, 15.3491f, 3.2f, 15.0063f)
                curveTo(4.6208f, 14.2958f, 6.0646f, 13.7628f, 7.5313f, 13.4071f)
                curveTo(8.9979f, 13.0515f, 10.4875f, 12.8741f, 12.0f, 12.875f)
                curveTo(13.5125f, 12.875f, 15.0021f, 13.0528f, 16.4687f, 13.4085f)
                curveTo(17.9354f, 13.7642f, 19.3792f, 14.2968f, 20.8f, 15.0063f)
                curveTo(21.4646f, 15.35f, 21.9976f, 15.8487f, 22.3991f, 16.5022f)
                curveTo(22.8006f, 17.1558f, 23.0009f, 17.8718f, 23.0f, 18.65f)
                verticalLineTo(22.5f)
                horizontalLineTo(1.0f)
                close()
            }
        }
        .build()
        return _icSelectedMyPage!!
    }

private var _icSelectedMyPage: ImageVector? = null
