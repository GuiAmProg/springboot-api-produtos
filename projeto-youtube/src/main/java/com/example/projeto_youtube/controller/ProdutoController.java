package com.example.projeto_youtube.controller;

import com.example.projeto_youtube.exceptions.RecursoNaoEncontradoException;
import com.example.projeto_youtube.model.Produto;
import com.example.projeto_youtube.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping()
    public List<Produto> listarProdutos(){
        return produtoService.ListarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id){
            Produto produto = produtoService.BuscarPorId(id);
            return ResponseEntity.ok(produto);
    }

    @PostMapping()
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.SalvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.DeletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
