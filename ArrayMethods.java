public class ArrayMethods{
   /*
   *PART 1
   */
   public static int rowSum(int[][] ary, int x){
     int sum = 0;
     try{
       for (int i = 0; i < ary[x].length; i++){
         sum += ary[x][i];
       }
     }
     catch(IndexOutOfBoundsException e){
         sum += 0;
       }
     return sum;
   }
    //returns the sum of the elements in Row x of ary.
    //When x is past the last row count it as a zero. (NO indexOutOfBounds should ever occur)

   public static int columnSum(int[][] ary, int x){
     int sum = 0;
     for (int i = 0; i < ary.length; i++){
       try{
         sum += ary[i][x];
       }
       catch(IndexOutOfBoundsException e){
         sum += 0;
       }
     }
     return sum;
   }
    //returns the sum of the elements in Column x of ary (careful with rows of different lengths!).
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)
  public static int maxRowLength(int[][]ary){
    int max = 0;
    for (int i = 0; i < ary.length; i++){
      if (ary[i].length > max){
        max = ary[i].length;
      }
    }
    return max;
  }
   /*
   *PART 2 - use prior methods where appropriate
   */
   public static int[] allRowSums(int[][] ary){
     int[] sums = new int[ary.length];
     for (int i = 0; i < ary.length; i++){
       try{
         sums[i] = rowSum(ary, i);
       }
       catch(IndexOutOfBoundsException e){
         sums[i] = 0;
       }
     }
     return sums;
   }
    //returns an array of the row sums for each row of ary.
    //Index i of the return array contains the sum of elements in row i.

    public static int[] allColSums(int[][] ary){
      int[] sums = new int[maxRowLength(ary)];
      for (int idx = 0;idx < maxRowLength(ary); idx++){
        try{
          sums[idx] = columnSum(ary, idx);
        }
        catch(IndexOutOfBoundsException e){
          sums[idx] = 0;
        }
      }
      return sums;
    }
    //Returns an array with the column sum of each column of ary.
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)
    //Index i of the return array contains the sum of elements in column i, ignoring any rows that are too short.
    //The length of the returned array should be the length of the LONGEST array in ary.


   /*
   *PART 3 - use prior methods where appropriate
   */
   public static boolean isRowMagic(int[][] ary){
     int sum = rowSum(ary, 0);
     for (int idx = 0; idx < ary.length; idx++){
       if (rowSum(ary, idx) != sum){
         return false;
       }
     }

     return true;
   }
     //checks if the array is row-magic (this means that every row has the same row sum).

   public static boolean isColumnMagic(int[][] ary){
     int sum = columnSum(ary, 0);
     for (int i = 0; i < maxRowLength(ary); i++){
       if (columnSum(ary, i) != sum){
         return false;
       }
     }
     return true;
   }
    //checks if the array is column-magic (this means that every column has the same column sum).

}
