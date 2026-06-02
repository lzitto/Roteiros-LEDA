package problems;

public class CountLessThanImpl implements CountLessThan{

    @Override
	public int countLess(Integer[] array, Integer x){
       // eu ia abrir o tibia pra agradecer a deus primeiramente
       // e dizer que estou grato por cada segundo que posso estar aqui sendo um pouco mais de mim mesmo..
       // fico contente em poder implementar mais uma vez esse roteiro ^^ espero que 
       // o meu conhecimento possa ter algum auxilio.
        return binarySearchLessThan(array, x,0,array.length-1);

    }
    public static int binarySearchLessThan(Integer[] array, Integer x, int left, int right) {
        int result;

        if (left > right) {
            result = left;
        } else {
            int mid = (left + right)/2; 
            if(array[mid] < x) {
                result = binarySearchLessThan(array, x, mid + 1, right);
            }
            else{
                result = binarySearchLessThan(array, x, left, mid -1);
            }
        }            
        return result;
    }
}
    

