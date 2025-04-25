package com.snapgram.controller.http;

import com.snapgram.application.service.HiApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello")
@RequiredArgsConstructor
public class Controller {
    private final HiApplicationService hiApplicationService;

    @GetMapping("/hi")
    public String hello(@RequestParam("name") String name) {
        return hiApplicationService.hi(name);
    }
}
