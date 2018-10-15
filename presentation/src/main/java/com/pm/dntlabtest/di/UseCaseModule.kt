package com.pm.dntlabtest.di

import com.pm.dntlabtes.domain.repository.CategoryRepository
import com.pm.dntlabtes.domain.usecase.GetCategoryUseCase
import com.pm.dntlabtest.core.NamedConstants.IO
import com.pm.dntlabtest.core.NamedConstants.UI
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named

@Module
class UseCaseModule {

    @Provides
    fun provideGetCategoryUseCase(
            repository: CategoryRepository,
            @Named(IO) scheduler: Scheduler,
            @Named(UI) postExecutionScheduler: Scheduler
    ) = GetCategoryUseCase(
            repository = repository,
            scheduler = scheduler,
            postExecutionScheduler = postExecutionScheduler
    )

}