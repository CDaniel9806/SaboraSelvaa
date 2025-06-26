package com.saboraselva.saboraselva.config;

import org.springframework.stereotype.Component;

import com.saboraselva.saboraselva.Repo.IGenericRepository;
import com.saboraselva.saboraselva.model.Categoria;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {
     private final IGenericRepository<Categoria, Long> categoriaRepository;

    @PostConstruct
    public void init() {
        if (categoriaRepository.count() == 0) {
            categoriaRepository.save(new Categoria(null, "Entradas", "Platos de entrada"));
            categoriaRepository.save(new Categoria(null, "Platos de fondo", "Platos principales"));
            categoriaRepository.save(new Categoria(null, "Bebidas", "Bebidas frías y calientes"));
            // Agrega más categorías si lo deseas
        }
    }
}
