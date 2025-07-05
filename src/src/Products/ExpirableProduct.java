package Products;

import Exceptions.ExpirationException;

import java.time.LocalDate;

public interface ExpirableProduct {
    public LocalDate getExpirationDate();
    public void setExpirationDate(LocalDate expirationDate);

}
