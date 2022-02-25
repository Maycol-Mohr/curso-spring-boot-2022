package com.maycolmohrcursospringboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maycolmohrcursospringboot.domain.Categoria;
import com.maycolmohrcursospringboot.domain.Cidade;
import com.maycolmohrcursospringboot.domain.Cliente;
import com.maycolmohrcursospringboot.domain.Endereco;
import com.maycolmohrcursospringboot.domain.Estado;
import com.maycolmohrcursospringboot.domain.Produto;
import com.maycolmohrcursospringboot.domain.enums.TipoCliente;
import com.maycolmohrcursospringboot.repositories.CategoriaRepository;
import com.maycolmohrcursospringboot.repositories.CidadeRepository;
import com.maycolmohrcursospringboot.repositories.ClienteRepository;
import com.maycolmohrcursospringboot.repositories.EnderecoRepository;
import com.maycolmohrcursospringboot.repositories.EstadoRepository;
import com.maycolmohrcursospringboot.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringbootApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36458602834", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("123456789", "98765432"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "Jardim", "32254396", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "24345678", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));		
	}
}