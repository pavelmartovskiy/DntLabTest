package com.pm.dntlabtest.data.repository

import com.pm.dntlabtes.domain.repository.Repository
import com.pm.dntlabtest.data.net.NetApi

abstract class AbsNetRepository(protected val api: NetApi) : Repository