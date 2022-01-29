import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	public String generateToken(String id, String subject, String key) {
		// JWT token generation		
		
		String token = Jwts.builder()
		.setId(id)
		.setSubject(subject)
		.setIssuer(key)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(10)))
		.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes()))
		.compact();
		
		return token;
		// reading/parsing token		
	}
	
	public Claims getClaims(String key, String token) {
		
		Claims claims = Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
				.parseClaimsJws(token)
				.getBody();
				
				return claims;
	}
	
	public boolean validateToken(String key, String token) {
		
		return getClaims(key, token).getExpiration().after(new Date(System.currentTimeMillis()));			
		
	}
	
	
}
