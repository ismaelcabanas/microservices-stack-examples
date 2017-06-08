package cabanas.garcia.ismael.msreverse.domain.service;

/**
 * Created by ismaelcabanas on 8/6/17.
 */
public class DefaultReverseService implements ReverseService {
    public String reverse(String stringToReverse) {
        return new StringBuilder(stringToReverse).reverse().toString();
    }
}
