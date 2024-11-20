package com.shoppingApp.product_service.client;



import com.shoppingApp.product_service.dto.ProductAttributeDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CategoryServiceClient {

    private final WebClient webClient;

    public CategoryServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ProductAttributeDto> getCategoryById(Long categoryId) {
        return webClient.get()
                .uri("/api/categories/{id}", categoryId)
                .retrieve()
                .bodyToMono(ProductAttributeDto.class);
    }
}
