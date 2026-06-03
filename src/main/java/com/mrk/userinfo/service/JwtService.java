package com.mrk.userinfo.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService { // jwt token creation

	private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey12345";

	public String generateToken(String username) {

		Key key = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

		return Jwts.builder()

				.subject(username)

				.issuedAt(new Date())

				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))

				.signWith(key)

				.compact();
	}

}
