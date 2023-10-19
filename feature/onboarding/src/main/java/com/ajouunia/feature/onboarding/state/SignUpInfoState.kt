package com.ajouunia.feature.onboarding.state

data class SignUpInfoState(
    val firstName: String = "",
    val lastName: String = "",
    val studentId: String = "",
    val department: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isValidPassword: Boolean = false,
    val isValidConfirmPassword: Boolean = false
)
