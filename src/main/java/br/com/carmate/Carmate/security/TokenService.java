package br.com.carmate.Carmate.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import br.com.carmate.Carmate.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



public class TokenService {
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    Instant expiration = issuedAt.plus(3, ChronoUnit.MINUTES);
    
	public String generateToken(Authentication authentication) {
		User loggedIn = (User) authentication.getPrincipal();		
		
		return Jwts.builder()
			.setSubject(loggedIn.getId().toString())
			.setIssuedAt(Date.from(issuedAt))
			.setExpiration(Date.from(expiration))
			.signWith(SignatureAlgorithm.HS256, secret)
			.compact();
		}
		
		
		
	}
	



