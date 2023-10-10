package com.ajouunia.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.onboarding.route.AgreementServiceRoute
import com.ajouunia.feature.onboarding.route.ConfirmEmailRoute
import com.ajouunia.feature.onboarding.route.SignInRoute
import com.ajouunia.feature.onboarding.route.VerificationCodeRoute

const val SIGN_IN_NAVIGATION_ROUTE = "sign_in_route"
const val AGREEMENT_SERVICE_ROUTE = "agreement_service_route"
const val FORGOT_PASSWORD_NAVIGATION_ROUTE = "forgot_password_route"
const val CONFIRM_EMAIL_ROUTE = "confirm_email_route"
const val VERIFICATION_CODE_ROUTE = "verification_code_route"

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) {
    this.navigate(SIGN_IN_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToAgreementService(navOptions: NavOptions? = null) {
    this.navigate(AGREEMENT_SERVICE_ROUTE, navOptions)
}

fun NavController.navigateToForgotPassword(navOptions: NavOptions? = null) {
    this.navigate(AGREEMENT_SERVICE_ROUTE, navOptions)
}

fun NavController.navigateToConfirmEmail(navOptions: NavOptions? = null) {
    this.navigate(CONFIRM_EMAIL_ROUTE, navOptions)
}

fun NavController.navigateToVerificationCode(navOptions: NavOptions? = null) {
    this.navigate(VERIFICATION_CODE_ROUTE, navOptions)
}

fun NavGraphBuilder.onBoarding(
    navigateToBack: () -> Unit,
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
    navigateToConfirmEmail: (NavOptions) -> Unit,
    navigateToVerificationCode: (NavOptions) -> Unit,
    navigateToSignUp: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit
) {
    composable(route = SIGN_IN_NAVIGATION_ROUTE) {
        SignInRoute(
            navigateToAgreementService = navigateToAgreementService,
            navigateToForgotPassword = navigateToForgotPassword,
            navigateToHome = navigateToHome
        )
    }
    composable(route = AGREEMENT_SERVICE_ROUTE) {
        AgreementServiceRoute(
            navigateToBack = navigateToBack,
            navigateToTerms = {},
            navigateToPrivacy = {},
            navigateToConfirmEmail = navigateToConfirmEmail
        )
    }
    composable(route = CONFIRM_EMAIL_ROUTE) {
        ConfirmEmailRoute(
            navigateToBack = navigateToBack,
            navigateToConfirmCode = navigateToVerificationCode
        )
    }
    composable(route = VERIFICATION_CODE_ROUTE) {
        VerificationCodeRoute(
            navigateToBack = navigateToBack,
            navigateToSignUp = navigateToSignUp
        )
    }
}