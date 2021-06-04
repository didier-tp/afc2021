package fr.afcepf.al35.serverRest.util;

import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/*
 * JwtUtil classe utilitaire (Helper with static methods)
 * generic (no spring)
 */

public class JwtUtil {
	
	 public  static String ROLES_AUTHORITIES_CLAIM="authorities" ; //"roles" or "authorities" or "scopes" or ... 
	 public  static String MY_DEFAULT_JWT_ISSUER="http://www.mycompany" ; 
	 
	 private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);


	 public static String buildToken(String userNameOrId , long jwtExpirationInMs , 
			                         String jwtSecret , Collection<String> roleNameList) {
            //exemples: jwtExpirationInMs=60*05*1000= 300000ms pour 5minutes
		 	//			jwtExpirationInMs=60*15*1000= 900000ms pour 15minutes
		    //			jwtExpirationInMs=60*30*1000=1800000ms pour 30minutes
		    //			jwtExpirationInMs=60*60*1000=3600000ms pour 60minutes
		    //		   jwtExpirationInMs=60*120*1000=7200000ms pour 120minutes
		    //          usernameOrId="user1"
		    //			jwtSecret="MyJWTSuperSecretKey"
		    //          roleNameList=[USER,ADMIN,MANAGER]
		 
	        Date now = new Date();
	        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

	        return Jwts.builder()
	        		.setIssuer(MY_DEFAULT_JWT_ISSUER)
	                .setSubject(userNameOrId)
	                .setIssuedAt(new Date())
	                //.claim(ROLES_AUTHORITIES_CLAIM, roleNameList.toString())
	                .setExpiration(expiryDate)
	                .signWith(SignatureAlgorithm.HS512, jwtSecret)
	                .compact();
	    }
	 
	 public static Claims extractClaimsFromJWT(String token, String jwtSecret) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(jwtSecret)
	                .parseClaimsJws(token)
	                .getBody();
	        logger.debug("extracted claims in JWT="+claims.toString());
	        return claims;
	    }
	 
	 public static boolean validateToken(String authToken,  String jwtSecret) {
	        try {
	            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	            return true;
	        } catch (SignatureException ex) {
	            logger.error("Invalid JWT signature");
	        } catch (MalformedJwtException ex) {
	            logger.error("Invalid JWT token");
	        } catch (ExpiredJwtException ex) {
	            logger.error("Expired JWT token");
	        } catch (UnsupportedJwtException ex) {
	            logger.error("Unsupported JWT token");
	        } catch (IllegalArgumentException ex) {
	            logger.error("JWT claims string is empty.");
	        }
	        return false;
	    }
}
