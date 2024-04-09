package com.xiqi.wzq.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String KEY = "Wang";

    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256(KEY));
    }

    public static String genToken(Map<String, Object> claims, Date expires) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(expires)
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

}
