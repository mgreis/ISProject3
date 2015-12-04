package client;

import artifact.TrocaString;
import artifact.TrocaStringService;


public class Client {

 /**
  * @param args
  */
 public static void main(String[] args) {
  TrocaStringService as = new TrocaStringService();
  TrocaString asp = as.getTrocaStringPort();
  System.out.println(asp.troca("hello world"));
 }

}