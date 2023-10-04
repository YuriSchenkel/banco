package com.example.Banco_YC.R_Pessoa;

import com.example.Banco_YC.Model.M_Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Responsavel extends JpaRepository<M_Responsavel, Long> {

}