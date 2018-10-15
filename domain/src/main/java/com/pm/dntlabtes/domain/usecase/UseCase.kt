package com.pm.dntlabtes.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable

abstract class UseCase<P,R> protected constructor(
        private val scheduler: Scheduler,
        private val postExecutionScheduler: Scheduler) {

    var disposable: Disposable? = null

    fun execute(param: P, success: (result:R) -> Unit, error: (t:Throwable) -> Unit) {

        disposable?.takeIf { !it.isDisposed }?.dispose()

        disposable = this.buildUseCaseSingle(param)
                .subscribeOn(scheduler)
                .observeOn(postExecutionScheduler)
                .doFinally { disposable = null }
                .subscribe(success, error)
    }

    abstract fun buildUseCaseSingle(param: P) : Single<R>

}