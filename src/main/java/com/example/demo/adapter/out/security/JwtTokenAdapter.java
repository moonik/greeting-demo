package com.example.demo.adapter.out.security;

import com.example.demo.application.ports.out.user.JwtTokenPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JwtTokenAdapter implements JwtTokenPort {

    @Value("${spring.security.jwt.key-id}")
    private String jwtKeyId;

    private final JwtEncoder jwtEncoder;

    public JwtTokenAdapter(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String generateToken(String email) {
        Instant now = Instant.now();
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256)
                .keyId(jwtKeyId) // Must match the ID in SecurityConfig
                .build();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuer("demo-app")
                .issuedAt(now)
                .expiresAt(now.plus(2, ChronoUnit.HOURS))
                .subject(email)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, jwtClaimsSet)).getTokenValue();
    }
}
