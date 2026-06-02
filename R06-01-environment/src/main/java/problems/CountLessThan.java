package problems;

/**
 * Dado um array A ordenado de inteiros de tamanho N e um valor x, usar busca binaria para 
 * encontrar o numero de elementos do array que sao menores do que x, onde x pode ou não estar no array.
 *
 * Exemplo:
 *   A = [5, 7, 7, 8, 8, 10]
 *   x = 6
 *   Saida: 1 (apenas o 5 é menor que 6)
 *
 *   A = [5, 17, 100, 111]
     x = 3
 *   Saida: 0 (nao tem nenhum elemento do array menor que 3)
 *
 * Restricoes: 
 * - O uso de memória extra de seu algoritmo deve ser O(1)
 * - O tempo de seu algoritmo deve ser O(k.log n), onde k = 1.
 * - Voce DEVE usar a estratégia de busca binária
 * - Voce DEVE usar recursão (seu algoritmo não pode ter laços)
 * - Você NÃO pode declarar atributos na classe
 * - Você NÃO pode usar estratégia baseada em contagem
 * - Você NÃO pode usar return em métodos void
 * - Você NÃO pode usar mais de um return em métodos que retornam algum valor
 * - Você NÃO pode usar comandos break ou continue
 * - Você PODE criar apenas um método auxiliar com no máximo 4 parâmetros
 */
public interface CountLessThan {
	public int countLess(Integer[] array, Integer x);
}
