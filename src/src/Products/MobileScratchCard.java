package Products;

import java.time.LocalDate;

public class MobileScratchCard extends Product implements ExpirableProduct {

    private LocalDate expirationDate;

    public MobileScratchCard(long quantity, String name, double price, double v, LocalDate expirationDate) {
        super(quantity, name, price);

        this.expirationDate = expirationDate;
    }


    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
