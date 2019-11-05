import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Supermercado {

	public static void main(String[] args) throws IOException {
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int numMaxProdutos;
		TabelaHashProduto tabelaProdutos;
		int codigo;
		String nome;
		double preco;
		Produto produtoPesquisado;
		
		System.out.print("Informe o n�mero m�ximo de produtos distintos que ser�o cadastrados no supermercado: ");
		numMaxProdutos = Integer.parseInt(entrada.readLine());
		tabelaProdutos = new TabelaHashProduto(numMaxProdutos);
		
		codigo = 0;
		while (codigo >= 0) {
			System.out.println("Informe os dados do produto que ser� cadastrado. Digite \'-1\' no campo \"c�digo de barras\" quando desejar encerrar o cadastramento de produtos.");
			System.out.print("Informe o c�digo de barras do produto: ");
			codigo = Integer.parseInt(entrada.readLine());
			if (codigo >= 0) {
				System.out.print("Informe seu nome: ");
				nome = entrada.readLine();
				System.out.print("Informe seu pre�o unit�rio: ");
				preco = Double.parseDouble(entrada.readLine());
				if ((tabelaProdutos.inserir(new Produto(codigo, nome, preco))) == -1){
					System.out.println("N�o foi poss�vel inserir o produto. J� existe produto armazenado na tabela com o mesmo c�digo de barras do produto informado.");
					break;
				}
			}
		}
		
		System.out.print("\nInforme o c�digo de barras do produto a ser pesquisado: ");
        codigo = Integer.parseInt(entrada.readLine());
        produtoPesquisado = tabelaProdutos.pesquisar(codigo);
        if (produtoPesquisado != null)
        {
            System.out.println("Nome do produto pesquisado: " + produtoPesquisado.getNome());
            System.out.println("Pre�o unit�rio do produto pesquisado: " + produtoPesquisado.getPrecoUnitario());
        }
        else
        {
        	System.out.println("O produto n�o foi encontrado.");
        }
        System.out.print("\n\n**************************************************************************\n\n");
		tabelaProdutos.imprimir();

	}
}