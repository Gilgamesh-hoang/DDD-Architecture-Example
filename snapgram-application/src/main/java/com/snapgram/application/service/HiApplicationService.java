package com.snapgram.application.service;

import com.snapgram.domain.service.HiDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HiApplicationService {
    private final HiDomainService hiDomainService;

    public String hi(String name) {
        return hiDomainService.hi(name);
    }
}
