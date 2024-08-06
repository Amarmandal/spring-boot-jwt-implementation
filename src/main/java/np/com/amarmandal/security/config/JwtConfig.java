package np.com.amarmandal.security.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    public SecretKey getSecret() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}


