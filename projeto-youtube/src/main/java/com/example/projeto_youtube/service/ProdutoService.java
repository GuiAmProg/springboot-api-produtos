package com.example.projeto_youtube.service;

import com.example.projeto_youtube.exceptions.RecursoNaoEncontradoException;
import com.example.projeto_youtube.model.Produto;
import com.example.projeto_youtube.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> ListarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto BuscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com id" + id + "não encontrado"));
    }

    public Produto SalvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void DeletarProduto(Long id){

        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com id" + id + "não encontrado");
        }else {
            produtoRepository.deleteById(id);
        }
    }
}
