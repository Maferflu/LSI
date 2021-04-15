/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsi;

import Jama.*;
import java.util.Arrays;

/**
 *
 * @author ferfl
 */
public class LSI {
    
    //Diferencia entre ambos documentos
    public static double euclidean(double a[], double b[])
    {
        double similarity = 0.0;
        for(int i=0; i<a.length;i++)
        {
            similarity = similarity + ((a[i]-b[i])*(a[i]-b[i]));
        }
        similarity = Math.sqrt(similarity);
        return similarity;
    }
    
    public static double[] nRelevant(int n, double freqt[][], double q[])
    {
        double[] relevant = new double[n];
        double[] similarity = new double[freqt.length];
        for(int j=0; j<freqt.length;j++)
        {
            //puede estar tomando mal la sección de la matriz
            similarity[j] = euclidean(freqt[j], q);
        }
        
        Arrays.sort(similarity);
        for (int i = 0; i < n; i++)
            relevant[i] = similarity[i];
        return relevant;
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
