/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsi;

import Jama.*;

/**
 *
 * @author ferfl
 */
public class LSI {
    
    //Diferencia entre ambas matrices
    public void euclidean()
    {
        
    }

    public static void printMatrix(double a[][])
    {
        for(int i=0; i<a.length; i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //JAVA is ROW FIRST
        
        //Test Values: https://web.mit.edu/be.400/www/SVD/Singular_Value_Decomposition.htm#:~:text=The%20SVD%20represents%20an%20expansion,up%20the%20columns%20of%20U.
        //Checked
        double[][] test = {{2.,4.},{1.,3.},{0.,0.},{0.,0.}};
        Matrix C = new Matrix(test);
        C.print(2, 0);
        test = C.getArrayCopy();
        //Los resultados de la matriz están redondeados hacia abajo 
        Matrix D = C.svd().getS();
        D.print(C.getColumnDimension(), 0);
        printMatrix(D.getArrayCopy()); //puntos decimales
        
        Matrix E = C.svd().getU();
        E.print(Math.min(C.getRowDimension(),C.getColumnDimension()), 0);
        
        Matrix F = C.svd().getV();
        F.print(C.getColumnDimension(), 0);
        
    }
    
}
