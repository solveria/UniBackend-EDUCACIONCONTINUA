package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Sin esto los {@code @Scheduled} quedan registrados como bean y nunca se disparan: el relay del
 * outbox no avisa que esta apagado, simplemente no corre.
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {}
