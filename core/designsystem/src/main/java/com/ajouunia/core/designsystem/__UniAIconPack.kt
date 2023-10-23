package com.ajouunia.core.designsystem

import androidx.compose.ui.graphics.vector.ImageVector
import com.ajouunia.core.designsystem.uniaiconpack.IcAjouGuide
import com.ajouunia.core.designsystem.uniaiconpack.IcCommunity
import com.ajouunia.core.designsystem.uniaiconpack.IcHamMenu
import com.ajouunia.core.designsystem.uniaiconpack.IcHome
import com.ajouunia.core.designsystem.uniaiconpack.IcMoreSee
import com.ajouunia.core.designsystem.uniaiconpack.IcMyPage
import com.ajouunia.core.designsystem.uniaiconpack.IcMyTasks
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedAjouGuide
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedCircle
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedCommunity
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedHome
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedMyPage
import com.ajouunia.core.designsystem.uniaiconpack.IcSelectedMyTaks
import com.ajouunia.core.designsystem.uniaiconpack.IcUnselectedCircle
import com.ajouunia.core.designsystem.uniaiconpack.IconArrow
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.core.designsystem.uniaiconpack.IconCheckedEllipse
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
    __UniAAllIcons= listOf(IcUnselectedCircle, IconBackArrow, IcHome, IcSelectedAjouGuide,
        IcMyTasks, IconLogoName, IcMyPage, IcCommunity, IcMoreSee, IcSelectedMyPage, IcAjouGuide,
        IconUncheckEllipse, IcSelectedCommunity, IconCheckedEllipse, IcSelectedMyTaks, IcHamMenu,
        IcSelectedCircle, IconArrow, IcSelectedHome, IconEyeHide, IconEyeShow)
    return __UniAAllIcons!!
  }
