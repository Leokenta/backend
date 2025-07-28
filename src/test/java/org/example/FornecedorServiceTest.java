package org.example;

import org.example.entities.Fornecedores;
import org.example.services.FornecedorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FornecedorServiceTest {

    @Autowired
    private FornecedorService fornecedorService;

    @Test
    public void testCriarFornecedor() {
        Fornecedores fornecedor = new Fornecedores();
        fornecedor.setNome_for("Fornecedor Teste");
        fornecedor.setCnpj_for("12345678000199");
        fornecedor.setEmail_for("email@teste.com");
        fornecedor.setTelefone_for("11999999999");

        Fornecedores salvo = fornecedorService.insert(fornecedor);

        assertNotNull(salvo.getId_fornecedor());
        assertEquals("Fornecedor Teste", salvo.getNome_for());
    }

    @Test
    public void testBuscarFornecedorPorId() {
        Fornecedores novo = new Fornecedores();
        novo.setNome_for("Fornecedor ABC");
        novo.setCnpj_for("12345678000111");
        novo.setEmail_for("abc@fornecedor.com");
        novo.setTelefone_for("11999990000");

        Fornecedores salvo = fornecedorService.insert(novo);
        Fornecedores encontrado = fornecedorService.findById(salvo.getId_fornecedor());

        assertEquals("Fornecedor ABC", encontrado.getNome_for());
    }
}
