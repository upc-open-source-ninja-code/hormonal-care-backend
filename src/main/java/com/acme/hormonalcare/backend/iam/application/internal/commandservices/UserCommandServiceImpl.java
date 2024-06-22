package com.acme.hormonalcare.backend.iam.application.internal.commandservices;

import com.acme.hormonalcare.backend.iam.application.internal.outboundservices.hashing.HashingService;
import com.acme.hormonalcare.backend.iam.application.internal.outboundservices.tokens.TokenService;
import com.acme.hormonalcare.backend.iam.domain.model.aggregates.User;
import com.acme.hormonalcare.backend.iam.domain.model.commands.SignInCommand;
import com.acme.hormonalcare.backend.iam.domain.model.commands.SignUpCommand;
import com.acme.hormonalcare.backend.iam.domain.services.UserCommandService;
import com.acme.hormonalcare.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username()))
            throw new RuntimeException("Username already exists");
        var user = new User(command.username(), hashingService.encode(command.password()));
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var currentUser = user.get();
        var token = tokenService.generateToken(currentUser.getUsername());
        return Optional.of(ImmutablePair.of(currentUser, token));
    }
}
