package ru.random_walk.database.auth.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.random_walk.database.auth.entities.RefreshToken;
import ru.random_walk.database.auth.repos.RefreshTokenRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenFunctions {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken getRefreshTokenById(UUID id) {
        return refreshTokenRepository.getReferenceById(id);
    }

    @Transactional(transactionManager = "authTransactionManager")
    public void save(RefreshToken refreshToken) {
        refreshTokenRepository.save(refreshToken);
    }

    @Transactional(transactionManager = "authTransactionManager")
    public void delete(UUID id) {
        refreshTokenRepository.deleteById(id);
    }
}
