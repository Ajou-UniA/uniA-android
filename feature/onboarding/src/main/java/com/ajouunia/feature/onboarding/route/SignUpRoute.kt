package com.ajouunia.feature.onboarding.route

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavOptions
import com.ajouunia.core.designsystem.UniAIconPack
import com.ajouunia.core.designsystem.component.UniASelectDialog
import com.ajouunia.core.designsystem.uniaiconpack.IconBackArrow
import com.ajouunia.feature.onboarding.ui.SignUpScreen
import com.ajouunia.feature.onboarding.vm.SignUpViewModel
import com.ajouunia.feature.onboarding.model.SignUpUiState

private val list by lazy {
    listOf(
        "Mechanical Engineering",
        "Industrial Engineering",
        "Chemical Engineering",
        "Materials Science and Engineering",
        "Applied Chemistry and Biological Engr.",
        "Environmental Engineering",
        "Civil System Engineering",
        "Transportation System Engineering",
        "Architecture",
        "Electrical and Computer Engineering",
        "Cyber Security"
    )
}

@Composable
internal fun SignUpRoute(
    userEmail: String,
    navigateToBack: () -> Unit,
    navigateToOnBoarding: (NavOptions) -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    when (uiState) {
        is SignUpUiState.DepartmentDialog -> {
            UniASelectDialog(
                title = "Select department",
                list = list,
                onClickConfirm = viewModel::changeInfoDepartment,
                onClickCancel = {
                    viewModel.changeInfoDepartment("")
                }
            )
        }
        else -> Unit
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {
                focusManager.clearFocus()
            },
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    UniAIconPack.IconBackArrow,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(start = 24.dp, top = 60.dp)
                        .clickable { navigateToBack() },
                )
            }
        }
    ) { padding ->
        SignUpScreen(
            modifier = Modifier.padding(padding),
            uiState = uiState,
            navigateToOnBoarding = navigateToOnBoarding,
            changeInputFirstName = viewModel::changeInfoFirstName,
            changeInfoLastName = viewModel::changeInfoLastName,
            changeInfoStudentId = viewModel::changeInfoStudentId,
            onClickDepartment = viewModel::onClickDepartment,
            changeInfoPassword = viewModel::changeInfoPassword,
            changeInfoConfirmPassword = viewModel::changeInfoConfirmPassword
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpRoutePreview() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .background(Color.White),
                contentAlignment = Alignment.CenterStart
            ) {
                Icon(
                    UniAIconPack.IconBackArrow,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(start = 24.dp, top = 60.dp)
                        .clickable {},
                )
            }
        }
    ) { padding ->
        SignUpScreen(
            modifier = Modifier.padding(padding),
            uiState = SignUpUiState.Init,
            navigateToOnBoarding = {}
        )
    }
}