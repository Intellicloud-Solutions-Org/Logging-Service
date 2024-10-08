package com.LoggingService.controller;

import com.LoggingService.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/info")
    public String logInfo(@RequestParam String message,
                          @RequestParam String source,
                          @RequestParam Long userId,
                          @RequestParam String serviceName) {
        logService.logInfo(message, source, userId, serviceName);
        return "Info log saved";
    }

    @PostMapping("/error")
    public String logError(@RequestParam String message,
                           @RequestParam String source,
                           @RequestParam Long userId,
                           @RequestParam String serviceName,
                           @RequestParam String exceptionTrace) {
        logService.logError(message, source, userId, serviceName, exceptionTrace);
        return "Error log saved";
    }
}
