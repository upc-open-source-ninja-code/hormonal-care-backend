package com.acme.hormonalcare.backend.iam.infrastructure.hashing.bcrypt;

import com.acme.hormonalcare.backend.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
