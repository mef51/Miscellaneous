package mef;

/**
 * nananana BATMAN
 * @author mohammed
 * @since fall 2012
 *
 */
public class LinearAlgebraMain 
{
    public static void main(String[] args){
        new LinearAlgebraMain();
    } // end main
    
    public LinearAlgebraMain(){
        Vector<Integer> xAxis = new Vector<Integer>(1, 0, 0);
        Vector<Integer> yAxis = new Vector<Integer>(0, 1, 0);
        Vector<Integer> zAxis = new Vector<Integer>(0, 0, 1);
        
        Vector<Vector<Integer>> identityMatrix = new Vector<Vector<Integer>>(xAxis, yAxis, zAxis);
        System.out.println(identityMatrix);
        
    }
    
    public class Vector<E>{
        private int mDimension;
        private E[] mData;
        
        @SuppressWarnings("unchecked")
        public Vector(int dimension){
            this.mDimension = dimension;
            this.mData = (E[]) new Object[this.mDimension];
        }
        
        /**
         * Eww ellipsis
         * @param e
         */
        @SuppressWarnings("unchecked")
        public Vector(E ... e){
            this.mDimension = e.length;
            this.mData = (E[]) new Object[this.mDimension];
            for(int i = 0; i < mData.length; i++){
                mData[i] = e[i];
            }
        }
        
        public int getDimension(){
            return this.mDimension;
        }
        
        /**
         * Counting of components starts from 0.
         * @param component
         * @return
         */
        public E get(int component){
            return mData[component];
        }
        
        public String toString(){
            String s = " ";
            for(int i = 0; i < this.getDimension(); i++){
                s += this.get(i) + " ";
            }
            return s + "\n";
        }
        
    } // end Vector
    
} // end class
