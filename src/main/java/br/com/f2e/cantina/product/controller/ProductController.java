package br.com.f2e.cantina.product.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.f2e.cantina.product.model.dto.ProductInputDto;
import br.com.f2e.cantina.product.model.dto.ProductViewDto;
import br.com.f2e.cantina.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductViewDto> save(@RequestBody @Valid ProductInputDto productInputDto,
			UriComponentsBuilder uriBuilder) {
		ProductViewDto productViewDto = ProductViewDto.fromProduct(productService.save(productInputDto));
		URI uri = uriBuilder.path("/product/{id}").buildAndExpand(productViewDto.getId()).toUri();
		return ResponseEntity.created(uri).body(productViewDto);
	}

	@GetMapping
	public ResponseEntity<List<ProductViewDto>> findAll() {
		return ResponseEntity.ok(ProductViewDto.fromListProduct(productService.findAll()));
	}
}
