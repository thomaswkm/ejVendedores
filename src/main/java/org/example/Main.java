package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] ventas = new int[15][12];
        ventas = llenarMatriz(ventas);

        //metodos de prueba
        mostrarVentas(ventas);


        System.out.println(Arrays.toString(totalVentasPorVendedor(ventas)));
        System.out.println(Arrays.toString(totalVentasPorMes(ventas)));
        mostrarMayorVendedor(ventas);
        mostrarMesMasBajo(ventas);
        mostrarPromedioTotalMensual(ventas);
        mostrarPromedioVendedor(ventas);

    }

    public static int[][] llenarMatriz(int[][] ventas){

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = (int)(Math.floor(Math.random() * 101)); ;
            }
        }

        return ventas;
    }

    public static void mostrarVentas(int[][] ventas){

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.print("["+ventas[i][j]+"]");
            }
            System.out.println("");

        }

    }

    public static int[] totalVentasPorVendedor(int[][] ventas){

        int[] totalVentas = new int[ventas.length]; //arreglo auxiliar


        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                totalVentas[i] += ventas[i][j];
            }
        }
        return totalVentas;
    }

    public static int[] totalVentasPorMes(int[][] ventas){

        int[] totalVentas = new int[12]; //arreglo auxiliar

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < ventas.length; j++) {
                totalVentas[i] += ventas[j][i];
            }
        }
        return totalVentas;
    }

    public static int obtenerMayorDelArreglo(int[] arreglo){

        int[] n = {0,0};

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]>n[0]){
                n[0] = arreglo[i];
                n[1] = i;
            }
        }

        return n[1]+1;
    }

    public static int obtenerMenorDelArreglo(int[] arreglo){

        int[] n = {100,0};

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]<n[0]){
                n[0] = arreglo[i];
                n[1] = i;
            }
        }

        return n[1]+1;
    }

    public static void mostrarMayorVendedor(int[][] ventas){

        System.out.println("El vendedor que mas vendió fue el número: "+obtenerMayorDelArreglo(totalVentasPorVendedor(ventas)));
    }

    public static void mostrarMesMasBajo(int[][] ventas) {

        System.out.println("El mes mas bajo fue: " + obtenerMenorDelArreglo(totalVentasPorMes(ventas)));

    }

    public static int calcularPromedioTotalMensual(int[] totalVentasPorMes){

        int suma = 0;

        for (int i = 0; i < totalVentasPorMes.length; i++) {
            suma += totalVentasPorMes[i];
        }
        return (int)(suma/12);
    }

    public static void mostrarPromedioTotalMensual(int[][] ventas){

        System.out.println("El promedio mensual total fue: "+calcularPromedioTotalMensual(totalVentasPorMes(ventas)));
    }

    public static int[] calcularPromedioVendedor(int[][] ventas){
        int[] v = totalVentasPorVendedor(ventas);
        for (int i = 0; i < v.length; i++) {
            v[i] = (int)(v[i]/12);
        }
        return v;
    }

    public static void mostrarPromedioVendedor(int[][] ventas){
        System.out.println("El promedio por vendedor fue: "+Arrays.toString(calcularPromedioVendedor(ventas)));
    }

}