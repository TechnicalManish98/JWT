import io.jsonwebtoken.Claims;

public class JwtTest {
	
	public static void main(String[] args) {
		
		JwtUtil jwt = new JwtUtil();
	
		
		String token = jwt.generateToken("A987", "Jwt", "SD8tysHukdTRFTfdysll980A");
		System.out.println(token);
		
		Claims claim = jwt.getClaims("SD8tysHukdTRFTfdysll980A", token);
		
		System.out.println(claim.getSubject());
		
		System.out.println(jwt.validateToken("SD8tysHukdTRFTfdysll980A", token));
		
		
	}

}
