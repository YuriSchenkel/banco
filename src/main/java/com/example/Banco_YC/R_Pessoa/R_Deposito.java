package com.example.Banco_YC.R_Pessoa;

import com.example.Banco_YC.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Deposito extends JpaRepository<M_Usuario, Long> {
    @Query(value="SELECT * FROM usuario WHERE cpf = :cpf", nativeQuery = true)
    M_Usuario buscarPorCpf(@Param("cpf") Long cpf);
}
