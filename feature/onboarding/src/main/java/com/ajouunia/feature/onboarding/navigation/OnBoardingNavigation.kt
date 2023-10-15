package com.ajouunia.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ajouunia.feature.onboarding.route.AgreementServiceRoute
import com.ajouunia.feature.onboarding.route.ConfirmEmailRoute
import com.ajouunia.feature.onboarding.route.OnBoardingRoute
import com.ajouunia.feature.onboarding.route.SignInRoute
import com.ajouunia.feature.onboarding.route.SignUpRoute
import com.ajouunia.feature.onboarding.route.VerificationCodeRoute

const val SIGN_IN_NAVIGATION_ROUTE = "sign_in_route"
const val AGREEMENT_SERVICE_NAVIGATION_ROUTE = "agreement_service_route"
const val FORGOT_PASSWORD_NAVIGATION_ROUTE = "forgot_password_route"
const val CONFIRM_EMAIL_SIGN_UP_NAVIGATION_ROUTE = "confirm_email_route/sign_up"
const val CONFIRM_EMAIL_FORGOT_PASSWORD_NAVIGATION_ROUTE = "confirm_email_route/forgot_password"
const val VERIFICATION_CODE_SIGN_UP_NAVIGATION_ROUTE = "verification_code_route/sign_up/{userEmail}"
const val VERIFICATION_CODE_FORGOT_PASSWORD_NAVIGATION_ROUTE = "verification_code_route/forgot_password/{userEmail}"
const val SIGN_UP_NAVIGATION_ROUTE = "sign_up_route/{userEmail}"
const val ON_BOARDING_NAVIGATION_ROUTE = "on_boarding_route"

fun NavController.navigateToSignIn(navOptions: NavOptions? = null) {
    this.navigate(SIGN_IN_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToAgreementService(navOptions: NavOptions? = null) {
    this.navigate(AGREEMENT_SERVICE_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToForgotPassword(navOptions: NavOptions? = null) {
    this.navigate(FORGOT_PASSWORD_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToConfirmEmailSignUp(navOptions: NavOptions? = null) {
    this.navigate(CONFIRM_EMAIL_SIGN_UP_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToConfirmEmailForgotPassword(navOptions: NavOptions? = null) {
    this.navigate(CONFIRM_EMAIL_FORGOT_PASSWORD_NAVIGATION_ROUTE, navOptions)
}

fun NavController.navigateToVerificationCodeSignUp(
    navOptions: NavOptions? = null,
    userEmail: String
) {
    this.navigate(VERIFICATION_CODE_SIGN_UP_NAVIGATION_ROUTE.replace("userEmail", userEmail), navOptions)
}

fun NavController.navigateToVerificationCodeForgotPassword(
    navOptions: NavOptions? = null,
    userEmail: String
) {
    this.navigate(VERIFICATION_CODE_FORGOT_PASSWORD_NAVIGATION_ROUTE.replace("userEmail", userEmail), navOptions)
}


fun NavController.navigateToSignUp(
    navOptions: NavOptions? = null,
    userEmail: String
) {
    this.navigate(SIGN_UP_NAVIGATION_ROUTE.replace("userEmail", userEmail), navOptions)
}

fun NavController.navigateToOnBoarding(navOptions: NavOptions? = null) {
    this.navigate(ON_BOARDING_NAVIGATION_ROUTE, navOptions)
}

fun NavGraphBuilder.onBoarding(
    navigateToBack: () -> Unit,
    navigateToAgreementService: (NavOptions) -> Unit,
    navigateToForgotPassword: (NavOptions) -> Unit,
    navigateToConfirmEmailSignUp: (NavOptions) -> Unit,
    navigateToConfirmEmailForgotPassword: (NavOptions) -> Unit,
    navigateToVerificationCodeSignUp: (NavOptions, String) -> Unit,
    navigateToVerificationCodeForgotPassword: (NavOptions, String) -> Unit,
    navigateToSignUp: (NavOptions, String) -> Unit,
    navigateToOnBoarding: (NavOptions) -> Unit,
    navigateToHome: (NavOptions) -> Unit
) {
    composable(route = SIGN_IN_NAVIGATION_ROUTE) {
        SignInRoute(
            navigateToAgreementService = navigateToAgreementService,
            navigateToForgotPassword = navigateToConfirmEmailForgotPassword,
            navigateToHome = navigateToHome
        )
    }
    composable(route = AGREEMENT_SERVICE_NAVIGATION_ROUTE) {
        AgreementServiceRoute(
            navigateToBack = navigateToBack,
            navigateToTerms = {},
            navigateToPrivacy = {},
            navigateToConfirmEmail = navigateToConfirmEmailSignUp
        )
    }
    composable(route = CONFIRM_EMAIL_SIGN_UP_NAVIGATION_ROUTE) {
        ConfirmEmailRoute(
            isSignUp = true,
            navigateToBack = navigateToBack,
            navigateToConfirmCodeSignUp = navigateToVerificationCodeSignUp,
            navigateToConfirmCodeForgotPassword = navigateToVerificationCodeForgotPassword
        )
    }
    composable(route = CONFIRM_EMAIL_FORGOT_PASSWORD_NAVIGATION_ROUTE) {
        ConfirmEmailRoute(
            isSignUp = false,
            navigateToBack = navigateToBack,
            navigateToConfirmCodeSignUp = navigateToVerificationCodeSignUp,
            navigateToConfirmCodeForgotPassword = navigateToVerificationCodeForgotPassword
        )
    }
    composable(route = VERIFICATION_CODE_SIGN_UP_NAVIGATION_ROUTE) {
        VerificationCodeRoute(
            userEmail = it.arguments?.getString("userEmail") ?: "",
            navigateToBack = navigateToBack,
            navigateToSignUp = navigateToSignUp,
            navigateToResetPassword = null
        )
    }
    composable(route = SIGN_UP_NAVIGATION_ROUTE) {
        SignUpRoute(
            userEmail = it.arguments?.getString("userEmail") ?: "",
            navigateToBack = navigateToBack,
            navigateToOnBoarding = navigateToOnBoarding
        )
    }
    composable(route = ON_BOARDING_NAVIGATION_ROUTE) {
        OnBoardingRoute(navigateToBack = navigateToBack)
    }
}