package util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secret:mySecretKey123456789012345678901234567890}")
	private String jwtSecret;

	@Value("${jwt.expiration:86400000}") // 24 hours
	private Long jwtExpiration;

	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())) // Sửa thành thời
																										// gian hiện tại
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpiration)).signWith(getSigningKey()) // Bỏ
																												// SignatureAlgorithm
																												// vì đã
																												// tự
																												// động
																												// xác
																												// định
				.compact();
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}
}