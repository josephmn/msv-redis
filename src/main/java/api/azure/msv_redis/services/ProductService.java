package api.azure.msv_redis.services;

import api.azure.msv_redis.model.Product;
//import lombok.RequiredArgsConstructor;
//import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final RedisTemplate<String, Product> redisTemplate;

    private static final String HASH_KEY = "Product";

    // Listar todos los productos
    public List<Product> obtenerTodosLosProductos() {
        HashOperations<String, String, Product> hashOperations = redisTemplate.opsForHash();
        Map<String, Product> productMap = hashOperations.entries(HASH_KEY);
        return new ArrayList<>(productMap.values());
    }

    // Guardar un producto
    public void guardarProducto(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
    }

    // Obtener un producto por ID
    public Product obtenerProductoPorId(String id) {
        HashOperations<String, String, Product> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(HASH_KEY, id);
    }

    // Eliminar un producto por ID
    public void eliminarProducto(String id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }

//    @Cacheable(value = "products", key = "#id")
//    public String getProductById(String id) {
//        // Simular una operaciones costosa, como una consulta a la base de datos
//        simulateSlowService();
//        return "Product with ID: " + id;
//    }
//
//    private void simulateSlowService() {
//        try {
//            Thread.sleep(3000); //Simula un retraso de 3 segundos
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
}
