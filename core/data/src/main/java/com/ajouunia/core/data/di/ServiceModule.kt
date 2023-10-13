package com.ajouunia.core.data.di

import com.ajouunia.core.data.service.MemberService
import com.ajouunia.core.data.service.ResetPasswordService
import com.ajouunia.core.data.service.SignUpService
import com.ajouunia.core.data.service.VerificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    internal fun provideMemberService(retrofit: Retrofit): MemberService {
        return retrofit.create(MemberService::class.java)
    }

    @Singleton
    @Provides
    internal fun provideResetPasswordService(retrofit: Retrofit): ResetPasswordService {
        return retrofit.create(ResetPasswordService::class.java)
    }

    @Singleton
    @Provides
    internal fun provideSignUpService(retrofit: Retrofit): SignUpService {
        return retrofit.create(SignUpService::class.java)
    }

    @Singleton
    @Provides
    internal fun provideVerificationService(retrofit: Retrofit): VerificationService {
        return retrofit.create(VerificationService::class.java)
    }

}