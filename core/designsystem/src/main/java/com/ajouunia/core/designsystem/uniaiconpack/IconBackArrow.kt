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

public val UniAIconPack.IconBackArrow: ImageVector
    get() {
        if (_iconBackArrow != null) {
            return _iconBackArrow!!
        }
        _iconBackArrow = Builder(name = "IconBackArrow", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(15.1248f, 21.1f)
                lineTo(6.6998f, 12.7f)
                curveTo(6.5998f, 12.6f, 6.5291f, 12.4917f, 6.4878f, 12.375f)
                curveTo(6.4458f, 12.2583f, 6.4248f, 12.1333f, 6.4248f, 12.0f)
                curveTo(6.4248f, 11.8667f, 6.4458f, 11.7417f, 6.4878f, 11.625f)
                curveTo(6.5291f, 11.5083f, 6.5998f, 11.4f, 6.6998f, 11.3f)
                lineTo(15.1248f, 2.875f)
                curveTo(15.3581f, 2.6417f, 15.6498f, 2.525f, 15.9998f, 2.525f)
                curveTo(16.3498f, 2.525f, 16.6498f, 2.65f, 16.8998f, 2.9f)
                curveTo(17.1498f, 3.15f, 17.2748f, 3.4417f, 17.2748f, 3.775f)
                curveTo(17.2748f, 4.1083f, 17.1498f, 4.4f, 16.8998f, 4.65f)
                lineTo(9.5498f, 12.0f)
                lineTo(16.8998f, 19.35f)
                curveTo(17.1331f, 19.5833f, 17.2498f, 19.8707f, 17.2498f, 20.212f)
                curveTo(17.2498f, 20.554f, 17.1248f, 20.85f, 16.8748f, 21.1f)
                curveTo(16.6248f, 21.35f, 16.3331f, 21.475f, 15.9998f, 21.475f)
                curveTo(15.6665f, 21.475f, 15.3748f, 21.35f, 15.1248f, 21.1f)
                close()
            }
        }
        .build()
        return _iconBackArrow!!
    }

private var _iconBackArrow: ImageVector? = null
