public class Empresas {
	public static void main(String[] args) {
		int fila = 3;
		int columna = 4;
		int [][] a = {	{50, 20, 120, -50}, 
						{60, 20, 70, 60}, 
						{-20, 0, -40, 60}};
		int [][] b = new int [fila][columna];  
		
		System.out.println("Empresa busca quedarse con la menor fila. DII se quiere quedar con la mayor columna");
		imprimeMatriz(a);
		
        System.out.println("\n Mayor suma de filas es: " + calcSumaMayorFila(a));
        System.out.println("\n Menor suma de columnas es: " + calcSumaMenorColum(a));
        System.out.println();
        b = removerFila(a, calcMayorFila(a));
        imprimeMatriz(b);
        System.out.println("\n El jugador Empresa ha eliminado la fila " + calcMayorFila(a));
        System.out.println();
        System.out.println("\n Mayor suma de filas es: " + calcSumaMayorFila(b));
        System.out.println("\n Menor suma de columnas es: " + calcSumaMenorColum(b));
        System.out.println();
        b = removerColum(b, calcMenorColum(b));
        imprimeMatriz(b);
        System.out.println("\n El jugador DII ha eliminado la columna " + calcMenorColum(b));
        
	}

public static int[][] removerFila(int[][] matriz, int fila) {
    if (fila < 0 || fila >= matriz.length) {
        return matriz;
    } else {
        int[][] nueva = new int[matriz.length - 1][matriz[0].length];
        int i;
        for (i = 0; i < fila; i++) {
            nueva[i] = matriz[i];
        }
        for (; i < nueva.length; i++) {
            nueva[i] = matriz[i + 1];
        }
        return nueva;
    }
}
public static int[][] removerColum(int[][] matriz, int col){
    int[][] nargs = null;
    if(matriz != null && matriz.length > 0 && matriz[0].length > col){
        nargs = new int[matriz.length][matriz[0].length-1];
        for(int i=0; i<matriz.length; i++){ 
            int newColIdx = 0;
            for(int j=0; j<matriz[i].length; j++){
                if(j != col){
                    nargs[i][newColIdx] = matriz[i][j];
                    newColIdx++;
                }          
            }
        }
    }
    return nargs; 
}

public static int calcSumaMayorFila(int[][] matriz){
	int mayorSuma = matriz[0][0];
	int sumaFilas;
	sumaFilas = 0;
	for (int i = 0; i < matriz.length; i++) {  //para cada fila de la matriz
    	for (int j = 0; j < matriz[i].length; j++) {
    		sumaFilas += matriz[i][j];
    	}
    	if (sumaFilas > mayorSuma) {
			mayorSuma = sumaFilas;
		}
    	//System.out.println("Suma de la fila " + i + ": " + sumaFilas);
    }
	return mayorSuma;
}

public static int calcMayorFila(int[][] matriz){
	int mayorSuma = matriz[0][0];
	int filaMayor, sumaFilas;
	sumaFilas = filaMayor = 0;
	for (int i = 0; i < matriz.length; i++) {  //para cada fila de la matriz
    	for (int j =0; j<matriz[i].length;j++) {
    		sumaFilas += matriz[i][j];
    	}
    	if (sumaFilas > mayorSuma) {
    		filaMayor = i;
			mayorSuma = sumaFilas;
		}
    }
	return filaMayor;
}

public static int calcSumaMenorColum(int[][] matriz){
	int menorSuma = matriz[0][0];
	int sumaColum;
	sumaColum = 0;
	for (int j =0; j<matriz.length-1;j++) {  //para cada fila de la matriz
    	for (int i = 0; i < matriz[j].length; i++) {
    		sumaColum += matriz[i][j];
    	}
    	if (sumaColum < menorSuma) {
    		menorSuma = sumaColum;
		}
    }
	return menorSuma;
}

public static int calcMenorColum(int[][] matriz){
	int menorSuma = matriz[0][0];
	int colMenor, sumaColum;
	sumaColum = colMenor = 0;
	for (int j = 0; j<20;j++) {  //para cada fila de la matriz
    	for (int i = 0; i < matriz[i].length; i++) {
    		sumaColum += matriz[i][j];
    	}
    	if (sumaColum < menorSuma) {
    		colMenor = j;
    		menorSuma = sumaColum;
		}
    	//System.out.println("Suma de la fila " + i + ": " + sumaFilas);
    }
	return colMenor;
}

public static void imprimeMatriz(int[][] matriz) {
	for (int i =0; i<matriz.length;i++) {
		for (int j =0; j<matriz[i].length;j++) {
			System.out.print("[" + matriz[i][j] + "] ");
		}
	System.out.println();
}
}
}
