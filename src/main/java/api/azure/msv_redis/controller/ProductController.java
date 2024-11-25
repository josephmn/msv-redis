package api.azure.msv_redis.controller;

import api.azure.msv_redis.model.Product;
import api.azure.msv_redis.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> obtenerTodosLosProductos() {
        return ResponseEntity.ok().body(productService.obtenerTodosLosProductos());
    }

    @PostMapping
    public ResponseEntity<String> guardarProducto(@RequestBody Product product) {
        productService.guardarProducto(product);
        return ResponseEntity.ok("Producto guardado con éxito");
    }

    @GetMapping("/{id}")
    public Product obtenerProductoPorId(@PathVariable String id) {
        return productService.obtenerProductoPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable String id) {
        productService.eliminarProducto(id);
        return "Producto eliminado con ID: " + id;
    }

//    @GetMapping("/{id}")
//    public String getProduct(@PathVariable(value = "id") String id) {
//        return productService.getProductById(id);
//    }
}
