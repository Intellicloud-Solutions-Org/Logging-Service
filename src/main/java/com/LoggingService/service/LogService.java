package com.LoggingService.service;

import com.LoggingService.entity.LogEntity;
import com.LoggingService.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void logInfo(String message, String source, Long userId, String serviceName) {
        LogEntity log = createLog(message, "INFO", source, userId, serviceName, null);
        logRepository.save(log);
    }

    public void logError(String message, String source, Long userId, String serviceName, String exceptionTrace) {
        LogEntity log = createLog(message, "ERROR", source, userId, serviceName, exceptionTrace);
        logRepository.save(log);
    }

    private LogEntity createLog(String message, String level, String source, Long userId, String serviceName, String exceptionTrace) {
        LogEntity log = new LogEntity();
        log.setLogTimestamp(LocalDateTime.now());
        log.setLogLevel(level);
        log.setLogMessage(message);
        log.setLogSource(source);
        log.setUserId(userId);
        log.setServiceName(serviceName);
        log.setExceptionTrace(exceptionTrace);
        log.setEnvironment("prod");  // Can be dynamically set
        return log;
    }
}