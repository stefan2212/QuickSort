class Partitionning{

    private int []array;
    private int arraySize;

    public void quickSort(int left, int right){
        if(right - left <=0)
            return ;
        else{
            int pivot = array[right];
            int pivotLocation = partitionArray(left,right,pivot);
            quickSort(left,pivotLocation -1 );
            quickSort(pivotLocation+1,right);
        }
    }

    public int partitionArray(int left, int right, int pivot){
        int leftPointer = left -1;
        int rightPointer = right;
        while(true){

            while(array[++leftPointer]< pivot);
            while(rightPointer >0 && array[--rightPointer]> pivot);
            if(leftPointer >= rightPointer) break;
            else{
                swap(leftPointer,rightPointer);
            }
        }
        swap(leftPointer,right);
        return leftPointer;
    }

    Partitionning(int newArraySize){
        this.arraySize = newArraySize;
        array = new int[arraySize];
        generateRandomArray();
    }

    private void generateRandomArray(){
        for(int i=0; i<arraySize;i++)
            array[i]=(int)(Math.random()*10)+10;
    }

    private void swap(int index1, int index2)
    {
        int aux=array[index1];
        array[index1]=array[index2];
        array[index2]=aux;
    }

    public void printArray(){
        for(int i=0;i<arraySize;i++)
        {
            System.out.print(" | " + array[i]);
        }
        System.out.println(" | ");
    }
}



public class Main {

    public static void main(String[] args) {
        Partitionning partitionning = new Partitionning(10);
        partitionning.printArray();
        partitionning.quickSort(0,9);
        partitionning.printArray();
    }
}
