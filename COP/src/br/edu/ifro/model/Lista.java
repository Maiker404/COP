package br.edu.ifro.model;
import java.util.HashMap;
import java.util.Map;
public class Lista {
    public Map<String,Integer> toList(String linha,String separator){
        Map<String,Integer> list=new HashMap<>();
        String aux;
        String [] sec;
        aux=linha.substring(0, linha.length());
        sec=aux.split(separator);
        for (int i = 0; i < sec.length; i++) {
           list.put(("Id"+i), Integer.parseInt(sec[i]));
        }
        return list;
    }
    public String toConcat(Map<String,Integer> list){
        String linha="";
        linha+=list.get("Id1");
        for (int c = 1; c < list.size(); c++) {
            linha=linha+":"+list.get("Id"+(c+1));
        }
        return linha;
    }
}