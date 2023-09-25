package com.example.kakao._core.utils;

import java.time.Instant;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.kakao.user.User;

public class JwtTokenUtils {

    public static String create(User user) {
        // String secret = env.getProperty("token.secret");
        // Long exp = Long.parseLong(env.getProperty("token.exp"));

        String jwt = JWT.create()
                .withSubject("metacoding-key")
                .withClaim("id", user.getId()) // fk가 있어야 조회가 가능. 아이디나 이메일이나.
                .withClaim("email", user.getEmail())
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7)) // 현재시간을 ms(1초) 만료시간
                .sign(Algorithm.HMAC512("meta")); // 원래는 OS에 저장해야됨.

        return "Bearer" + jwt;
    }

    public static DecodedJWT verify(String jwt)
            throws SignatureVerificationException, TokenExpiredException {
        // String secret = env.getProperty("token.secret");
        jwt = jwt.replace("Bearer ", "");

        // 헤더와 페이로드를 검증한 후, 검증이 완료되면, header, payload를 base64로 복호화함.
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("meta"))
                .build().verify(jwt);
        return decodedJWT;
    }

}