package com.example.FlowMailApi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SpamControlService {
	private static final int MAXIMO_EMAILS_POR_USUARIO = 10;
    private static final int EMAIL_INTERVALO_MS = 60000; // Intervalo de 1 minuto

    private Map<Long, Integer> emailCount = new HashMap<>();
    private Map<Long, Long> lastEmailTimestamp = new HashMap<>();

    public boolean isSpam(Long id) {
        long now = System.currentTimeMillis();
        emailCount.putIfAbsent(id, 0);
        lastEmailTimestamp.putIfAbsent(id, now);

        long lastTimestamp = lastEmailTimestamp.get(id);
        if (now - lastTimestamp > EMAIL_INTERVALO_MS) {
            emailCount.put(id, 0);
            lastEmailTimestamp.put(id, now);
        }

        int count = emailCount.get(id);
        if (count >= MAXIMO_EMAILS_POR_USUARIO) {
            return true;
        }

        emailCount.put(id, count + 1);
        return false;
    }
}
