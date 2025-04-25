package com.snapgram.infrastructure.persistence.repository;

import com.snapgram.domain.repository.HiDomainRepo;
import org.springframework.stereotype.Repository;

@Repository
public class HiInfrastructureRepo implements HiDomainRepo {

    @Override
    public String hi(String name) {
        return "hi " + name + " from infrastructure!";
    }
}
