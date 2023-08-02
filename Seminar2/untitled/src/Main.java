// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        public static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }

        public static void SSort(int[] arr){
            for(int i = 0; i<arr.length; i++){
                for(int j = i; j < arr.length-i-1; j++){
                    if(arr[i] > arr[j+1]){
                        swap(arr[j], arr[j+1]);
                    }
                }

                for(int j = arr.length - i - 1; j >= i; j--){

                }

            }
        };

    }
}