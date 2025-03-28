//package com.FinanceApp.Finance.Util;
//
//import java.security.Key;
//import java.util.Date;
//
//import javax.crypto.SecretKey;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtUtil {
//
////	private static final Key SECRET_KEY = "MySecretKey";
//	private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//	private static final long EXPIRATION_TIME = 1000*60*60*10;
//	
//	public String generateToken(String email) {
//		
//		return Jwts.builder()
//				.setSubject(email)
//				.setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//				.signWith(secretKey)
//				.compact();
//				
//		
//	}
//	
//	public String extractUserName(String token) {
//		return getClaims(token).getSubject();
//	}
//	
//	public Date extractExpiration(String token) {
//        return getClaims(token).getExpiration();
//    }
//	
//	public boolean validateToken(String token, String email) {
//        return email.equals(extractUserName(token)) && !isTokenExpired(token);
//    }
//	
//	 private Claims getClaims(String token) {
//	        return Jwts.parserBuilder()
//	                .setSigningKey(secretKey)
//	                .build()
//	                .parseClaimsJws(token)
//	                .getBody();
//	    }
//	 
//	 private boolean isTokenExpired(String token) {
//	        return extractExpiration(token).before(new Date());
//	    }
//	
//}
