package com.snapgram.domain.service;

import com.snapgram.domain.repository.HiDomainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HiDomainService {
    private final HiDomainRepo hiDomainRepo;

    public String hi(String name) {
        return hiDomainRepo.hi(name);
    }
}
