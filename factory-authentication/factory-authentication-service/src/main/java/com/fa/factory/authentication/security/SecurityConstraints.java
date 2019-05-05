package com.fa.factory.authentication.security;

public class SecurityConstraints {
    public static long EXPIRATION_TIME = 24 * 60 * 60 * 1000;
    public static String TOKEN_HEADER = "Authorization";
    public static String TOKEN_KEY = "JWTAuthorityKey";
    public static String TOKEN_SECRET = "JWTSecretKey";
    public static String TOKEN_PREFIX = "Bearer ";
}
