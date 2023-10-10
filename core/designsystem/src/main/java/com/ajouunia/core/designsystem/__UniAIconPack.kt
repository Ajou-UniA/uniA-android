package com.ajouunia.core.designsystem

import androidx.compose.ui.graphics.vector.ImageVector
import com.ajouunia.core.designsystem.uniaiconpack.IconArrow
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.core.designsystem.uniaiconpack.IconEyeHide
import com.ajouunia.core.designsystem.uniaiconpack.IconEyeShow
import com.ajouunia.core.designsystem.uniaiconpack.IconLogoName
import com.ajouunia.core.designsystem.uniaiconpack.IconUncheckEllipse
import kotlin.collections.List as ____KtList

public object UniAIconPack

private var __UniAAllIcons: ____KtList<ImageVector>? = null

public val UniAIconPack.UniAAllIcons: ____KtList<ImageVector>
  get() {
    if (__UniAAllIcons != null) {
      return __UniAAllIcons!!
    }
    __UniAAllIcons= listOf(IconBackArrow, IconLogoName, IconUncheckEllipse, IconArrow, IconEyeHide, IconEyeShow)
    return __UniAAllIcons!!
  }
