package com.netcracker.vectors;

/**
 * Created with IntelliJ IDEA.
 * User: Rimma
 * Date: 24.10.13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public interface VectorFactory {
  public  Vector createVector();
  public   Vector createVectorWithSize(int newSize);
}
