package com.ajouunia.core.data.di

import com.ajouunia.core.data.remote.GuideDataSource
import com.ajouunia.core.data.remote.MemberDataSource
import com.ajouunia.core.data.remote.ResetPasswordDataSource
import com.ajouunia.core.data.remote.SignUpDataSource
import com.ajouunia.core.data.remote.TaskDataSource
import com.ajouunia.core.data.remote.VerificationDataSource
import com.ajouunia.core.data.remote.impl.GuideDataSourceImpl
import com.ajouunia.core.data.remote.impl.MemberDataSourceImpl
import com.ajouunia.core.data.remote.impl.ResetPasswordDataSourceImpl
import com.ajouunia.core.data.remote.impl.SignUpDataSourceImpl
import com.ajouunia.core.data.remote.impl.TaskDataSourceImpl
import com.ajouunia.core.data.remote.impl.VerificationDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindMemberDataSource(
        memberDataSourceImpl: MemberDataSourceImpl,
    ): MemberDataSource

    @Binds
    @Singleton
    abstract fun bindResetPasswordDataSource(
        resetPasswordDataSourceImpl: ResetPasswordDataSourceImpl,
    ): ResetPasswordDataSource

    @Binds
    @Singleton
    abstract fun bindSignUpDataSource(
        signUpDataSourceImpl: SignUpDataSourceImpl,
    ): SignUpDataSource

    @Binds
    @Singleton
    abstract fun bindVerificationDataSource(
        verificationDataSourceImpl: VerificationDataSourceImpl,
    ): VerificationDataSource

    @Binds
    @Singleton
    abstract fun bindGuideDataSource(
        guideDataSourceImpl: GuideDataSourceImpl,
    ): GuideDataSource

    @Binds
    @Singleton
    abstract fun bindTaskDataSource(
        taskDataSourceImpl: TaskDataSourceImpl,
    ): TaskDataSource

}