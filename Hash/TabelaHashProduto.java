public class TabelaHashProduto {

	private int M;	/// tamanho da tabela hash.
    				/// M deve ser um número primo grande para diminuirmos a probabilidade de colisões.

	//private ListaProduto[] tabelaProdutos; 	/// tabela que referenciará todas as listas lineares encadeadas de produtos.
    	private CelulaProduto[] tabelaProduto; 									/// Nesse caso, estamos utilizando uma tabela hash com endereçamento em separado,
    										/// ou seja, os produtos são armazenados em listas lineares encadeadas.

	public TabelaHashProduto(int tamanho){
		int i = 0;
		this.M = tamanho;
		//this.tabelaProdutos = new ListaProduto[M];
		while(i < M){
			//tabelaProdutos[i] = new ListaProduto();
			tabelaProduto[i] = new CelulaProduto();
			i++;
		}
	}

	private int funcaoHash(int chave){ 
		return chave % M;
	}

	public int inserir(Produto produtoNovo){
		int i = funcaoHash(produtoNovo.getCodigoBarras());
		//ENDECERAMENTO COM LISTA ENCADEADA
		/*if(tabelaProdutos[i].localizar(produtoNovo.getCodigoBarras()) != null)
			return -1;
		else {
			tabelaProdutos[i].inserirFinal(produtoNovo);
			return i;
		}*/
		
		//HASH COM ENDERECAMENTO ABERTO
		if(tabelaProduto[i] != null)
	}

	public Produto pesquisar(int codigoBarras){
		int i = funcaoHash(codigoBarras);
		return tabelaProdutos[i].localizar(codigoBarras);
	}

	public void imprimir(){
		int i = 0;
		
		while(i < M){
			tabelaProdutos[i].imprimir();
			System.out.print("\n");
			i++;
		}
		
	}
}