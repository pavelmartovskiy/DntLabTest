package com.pm.dntlabtes.domain.usecase

import com.pm.dntlabtes.domain.model.Category
import com.pm.dntlabtes.domain.repository.CategoryRepository
import io.reactivex.Scheduler

class GetCategoryUseCase(
        private val repository: CategoryRepository,
        scheduler: Scheduler,
        postExecutionScheduler: Scheduler
) : UseCase<Unit,List<Category>>(scheduler, postExecutionScheduler) {
    override fun buildUseCaseSingle(param: Unit) = repository.get()
}