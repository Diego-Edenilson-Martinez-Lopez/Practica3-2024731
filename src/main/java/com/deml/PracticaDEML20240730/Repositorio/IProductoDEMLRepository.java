package com.deml.PracticaDEML20240730.Repositorio;

import com.deml.PracticaDEML20240730.Modelo.ProductoDEML;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDEMLRepository extends JpaRepository<ProductoDEML, Long> {
}