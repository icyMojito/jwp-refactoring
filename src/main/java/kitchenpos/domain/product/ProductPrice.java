package kitchenpos.domain.product;

import kitchenpos.exception.InvalidProductPriceException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ProductPrice {
    @Column(name = "price")
    private BigDecimal value;

    public ProductPrice() {
    }

    private ProductPrice(BigDecimal value) {
        this.value = value;
    }

    public static ProductPrice from(BigDecimal value) {
        validateValue(value);
        return new ProductPrice(value);
    }

    private static void validateValue(BigDecimal value) {
        if (Objects.isNull(value) || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidProductPriceException("상품의 가격은 0원 이상이어야 합니다!");
        }
    }

    public BigDecimal multiply(BigDecimal value) {
        return this.value.multiply(value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
