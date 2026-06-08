package com.mrk.userinfo.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService { // jwt token creation

	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey12345";

	public String generateToken(String username, String role) {

		Key key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

		return Jwts.builder()

				.subject(username).claim("role", role)

				.issuedAt(new Date())

				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))

				.signWith(key)

				.compact();
	}

	private SecretKeySpec getSignKey() {

		return new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
	}

	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> resolver) {

		Claims claims = extractAllClaims(token);

		return resolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {

		return Jwts.parser()

				.verifyWith((javax.crypto.SecretKey) getSignKey())

				.build()

				.parseSignedClaims(token)

				.getPayload();
	}

	public boolean validateToken(String token, String username) {

		String extractedUsername = extractUsername(token);

		return extractedUsername.equals(username) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {

		return extractClaim(token, Claims::getExpiration).before(new Date());
	}

	public String extractRole(String token) {
		return extractAllClaims(token).get("role", String.class);
	}

}
