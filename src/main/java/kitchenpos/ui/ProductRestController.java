package kitchenpos.ui;

import kitchenpos.application.ProductService;
import kitchenpos.dto.product.ProductCreateRequest;
import kitchenpos.dto.product.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/products")
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid final ProductCreateRequest productCreateRequest) {
        final ProductResponse created = productService.create(productCreateRequest);
        final URI uri = URI.create("/api/products/" + created.getId());

        return ResponseEntity.created(uri)
                .body(created);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> list() {
        return ResponseEntity.ok()
                .body(productService.list());
    }
}
